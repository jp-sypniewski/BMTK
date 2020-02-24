import { Injectable } from '@angular/core';
import { User } from "./user";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  [x: string]: any;

  private baseUrl = 'http://localhost:8085/api/';

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

createUser(user: User): Observable<User> {

  return this.http.post<User>(this.baseUrl+'createUser', user, {headers: new HttpHeaders({
    'Content-Type': 'application/json', 'Access-Control-Allow-Methods': 'POST',
    'Access-Control-Allow-Headers': 'Content-Type, Authorization'
  })
  })
  .pipe(catchError(this.handleError));

}
}
