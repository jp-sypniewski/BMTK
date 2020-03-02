import { Injectable } from '@angular/core';
import { User } from "../../models/user";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import {catchError, tap} from 'rxjs/operators';
import { UserListComponent } from 'src/app/components/user-list/user-list.component';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  [x: string]: any;

  // go back and update with environment information

  baseUrl = 'http://localhost:8085/';

  constructor(private http: HttpClient ) { }


  // takes strings for username, pw, creates credentials and verifies
  // upon success, creds are saved locally
  login(username, password) {
    const credentials = this.generateBasicAuthCredentials(username, password);
    const httpOptions = {
      headers: new HttpHeaders({
         'Authorization': `Basic ${credentials}`,
         'X-Requested-With': 'XMLHttpRequest'
       })
    };
   return this.http
   .get(this.baseUrl + 'authenticate', httpOptions)
   .pipe(
     tap((res) => {
       localStorage.setItem('credentials' , credentials);
       return res;
     }),
     catchError((err: any) => {
       console.log(err);
       return throwError('UserService.login(): Error logging in.');
     })
   );
  }

  // passes in user creds, returns user object (with user detail)
  // used on account, company pages to display/compare user information
  // does not include password in returned json
  getUserInfo(){
    const credentials = this.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'X-Requested-With': 'XMLHttpRequest',
        'Authorization': `Basic ${credentials}`
      })
    };
    return this.http.get<User>(this.baseUrl + 'api/user', httpOptions)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('UserService.getUserInfo(): error getting user info.');
      })
    );
  }

// takes a user object and passes to db, can fail if username already taken
createUser(user){
   return this.http.post<User>(this.baseUrl+'register', user)
  .pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError('UserService.createUser(): error registering user.');
    })
  );
}

updateUser(user){
  const credentials = this.getCredentials();
  const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'X-Requested-With': 'XMLHttpRequest',
      'Authorization': `Basic ${credentials}`
    })
  };
  return this.http.put<User>(this.baseUrl+'api/user/'+user.id, user, httpOptions)
  .pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError('UserService.createUser(): error registering user.');
    })
  );
}

// removes local creds
logout() {
  localStorage.removeItem('credentials');
 }

// checks for local creds
checkLogin() {
  if (localStorage.getItem('credentials')) {
    return true;
  }
  return false;
 }

 // generates creds (Basic)
generateBasicAuthCredentials(username, password) {
  return btoa(`${username}:${password}`);
 }

 // returns creds to be used in other api calls
getCredentials() {
  return localStorage.getItem('credentials');
 }

 searchUsersByEmail(searchTerm){
  const credentials = this.getCredentials();
  const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'X-Requested-With': 'XMLHttpRequest',
      'Authorization': `Basic ${credentials}`
    })
  };
  return this.http.get<User[]>(this.baseUrl+'api/user/'+searchTerm, httpOptions)
  .pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError('UserService.searchUsersByEmail(): error finding users.');
    })
  );
 }

}
