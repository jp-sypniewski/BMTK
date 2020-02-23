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


findAll(): Observable<User[]> {
  return this.http.get(this.baseUrl+'user')
  .pipe(
  catchError(this.handleError)
  );
}
}
