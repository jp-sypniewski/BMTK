import { Injectable } from '@angular/core';
import { User } from "../../models/user";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import {catchError} from 'rxjs/operators';
import { UserListComponent } from 'src/app/components/user-list/user-list.component';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  [x: string]: any;

  baseUrl = 'http://localhost:8085/';
  userListComponent: UserListComponent;

  constructor(private http: HttpClient ) { }

getAllUsers(): Observable<User[]> {
  return this.http.get(this.baseUrl+'user')
  .pipe(
  catchError(this.handleError)
  );
}

getUsersByUsernamePassword(): Observable<User[]> {
  return this.http.get(this.baseUrl+'userByUsernamePassword')
  .pipe(
  catchError(this.handleError)
  );
}

createUser(user){

  console.log(JSON.stringify(user));

   return this.http.post<User>(this.baseUrl+'register', user)
   //this.http.get<User>(this.baseUrl+'api/user')
  .pipe(
    catchError((err: any) => {
      console.log(err);

      return throwError('AuthService.register(): error registering user.');

    })
  );
}

}
