import { environment } from './../../../environments/environment';
import { Injectable } from '@angular/core';
import { Employee } from "../../models/employee";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  [x: string]: any;

  // private baseUrl = 'http://localhost:8085/';
  private baseUrl = environment.baseUrl;

  constructor(private http: HttpClient) { }

  getAllEmployees(): Observable<Employee[]> {
    return this.http.get(this.baseUrl+'employee')
    .pipe(
    catchError(this.handleError)
    );
  }

  createEmployee(employee: Employee): Observable<Employee> {

    return this.http.post<Employee>(this.baseUrl+'api/createEmployee', employee, {headers: new HttpHeaders({
      'Content-Type': 'application/json', 'Access-Control-Allow-Methods': 'POST',
      'Access-Control-Allow-Headers': 'Content-Type, Authorization'
    })
    })
    .pipe(catchError(this.handleError));

  }
}
