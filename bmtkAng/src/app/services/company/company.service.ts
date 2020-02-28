import { Project } from './../../models/project';
import { UserService } from 'src/app/services/user/user.service';
import { Injectable } from '@angular/core';
import { Company } from "../../models/company";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {
  [x: string]: any;

  baseUrl = 'http://localhost:8085/';

  constructor(private http: HttpClient,
    private userSvc: UserService) { }



  index(){
    const credentials = this.userSvc.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Basic ${credentials}` // might have to add back x-reqeusted-with 'xmlhttprequest'
      })
    };
    return this.http.get<Company[]>(this.baseUrl + 'api/companies')
    .pipe(
      catchError((err: any) => {
        console.log(err);

        return throwError('CompanyService.index(): error getting all companies.');
      })
    );
  }

  getSingleCompany(id){
    const credentials = this.userSvc.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Basic ${credentials}` // might have to add back x-reqeusted-with 'xmlhttprequest'
      })
    };
    return this.http.get<Company>(this.baseUrl + 'api/companies/' + id)
    .pipe(
      catchError((err: any) => {
        console.log(err);

        return throwError('CompanyService.index(): error getting all companies.');
      })
    );
  }

  getMyCompanies(){
    const credentials = this.userSvc.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Basic ${credentials}` // might have to add back x-reqeusted-with 'xmlhttprequest'
      })
    };
    return this.http.get<Company[]>(this.baseUrl + 'api/myCompanies', httpOptions)
    .pipe(
      catchError((err: any) => {
        console.log(err);

        return throwError('CompanyService.getMyCompanies(): error getting all companies.');
      })
    );
  }

  getProjectsByCompany(cid){
    const credentials = this.userSvc.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Basic ${credentials}` // might have to add back x-reqeusted-with 'xmlhttprequest'
      })
    };
    return this.http.get<Project[]>(this.baseUrl + 'api/companies/'+cid+'/projects', httpOptions)
    .pipe(
      catchError((err: any) => {
        console.log(err);

        return throwError('CompanyService.getProjectsByCompany(): error getting all projects for a company.');
      })
    );
  }

  createCompany(company){
    console.log(company);
    const credentials = this.userSvc.getCredentials();
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
