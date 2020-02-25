import { Injectable } from '@angular/core';
import { User } from "../../models/user";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  [x: string]: any;

  private baseUrl = 'http://localhost:8085/';
  private user = new User();

  constructor(private http: HttpClient) { }

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

createUser(user) {

  console.log(JSON.stringify(user));
   this.http.post<User>(this.baseUrl+'register', user).subscribe(user);
   //this.http.get<User>(this.baseUrl+'api/user')
}

}
