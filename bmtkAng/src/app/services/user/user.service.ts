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
  userListComponent: UserListComponent;
  constructor(private http: HttpClient ) { }

  login(username, password) {
    // Make credentials
    const credentials = this.generateBasicAuthCredentials(username, password);

    console.log(credentials);
    // Send credentials as Authorization header (this is spring security convention for basic auth)
    const httpOptions = {
      headers: new HttpHeaders({
         'Authorization': `Basic ${credentials}`,
         'X-Requested-With': 'XMLHttpRequest'
       })
    };
           // create request to authenticate credentials
   return this.http
   .get(this.baseUrl + 'authenticate', httpOptions)
   .pipe(
     tap((res) => {
       localStorage.setItem('credentials' , credentials);
       return res;
     }),
     catchError((err: any) => {
       console.log(err);
       return throwError('AuthService.login(): Error logging in.');
     })
   );
  }

createUser(user){

   return this.http.post<User>(this.baseUrl+'register', user)
  .pipe(
    catchError((err: any) => {
      console.log(err);

      return throwError('AuthService.register(): error registering user.');

    })
  );
}

logout() {
  localStorage.removeItem('credentials');

 }

checkLogin() {
  if (localStorage.getItem('credentials')) {
    return true;
  }
  return false;
 }

generateBasicAuthCredentials(username, password) {
  return btoa(`${username}:${password}`);

 }

getCredentials() {
  return localStorage.getItem('credentials');
 }

}
