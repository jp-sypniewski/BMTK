import { Injectable } from '@angular/core';
import { Company } from "../../models/company";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import {catchError} from 'rxjs/operators';
import { CompanyNewComponent } from 'src/app/components/company-new/company-new.component';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {
  [x: string]: any;

  baseUrl = 'http://localhost:8085/';
  companyNewComponent: CompanyNewComponent;

  constructor(private http: HttpClient) { }

  createCompany(company){
    const credentials = this.authSvc.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Basic ${credentials}` // might have to add back x-reqeusted-with 'xmlhttprequest'
      })
    };

     return this.http.post<Company>(this.baseUrl+'api/companies', company, httpOptions)

    .pipe(
      catchError((err: any) => {
        console.log(err);

        return throwError('AuthService.register(): error registering company.');

      })
    );
  }

  updateCompany(company){

    return this.http.put<Company>(this.baseUrl+'api/company/', company)

    .pipe(
      catchError((err: any) => {
        console.log(err);

        return throwError('AuthService.register(): error registering company.');

      })
    );
  }
}