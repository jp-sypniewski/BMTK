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


  // get all companies, used in home component
  // credentials created in method, not added
  index(){
    const credentials = this.userSvc.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Basic ${credentials}`
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

  // get one company, used in company component
  // credentials created in method, not added
  getSingleCompany(id){
    const credentials = this.userSvc.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Basic ${credentials}`
      })
    };
    return this.http.get<Company>(this.baseUrl + 'api/companies/' + id)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('CompanyService.getSingleCompany(id): error getting one company.');
      })
    );
  }

  // gets the companies for an owner
  // credentials passed to method
  getMyCompanies(){
    const credentials = this.userSvc.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Basic ${credentials}`
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

  // gets projects for a company
  // credentials passed to method (req?)
  getProjectsByCompany(cid){
    const credentials = this.userSvc.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Basic ${credentials}`
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

  // creates a company, requires company input
  // credentials passed to method (req to tie owner to company)
  createCompany(company){
    const credentials = this.userSvc.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Basic ${credentials}`
      })
    };
     return this.http.post<Company>(this.baseUrl+'api/companies', company, httpOptions)
    .pipe(
      catchError((err: any) => {
        console.log(err);

        return throwError('CompanyService.createCompany(): error registering company.');

      })
    );
  }

  // updates a company, requires company input
  // credentials passed to method (creds must already be tied to company for update to occur)
  updateCompany(company){
    const credentials = this.userSvc.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
<<<<<<< HEAD
        'Authorization': `Basic ${credentials}` // might have to add back x-reqeusted-with 'xmlhttprequest'
      })
    };
    return this.http.put<Company>(this.baseUrl+'api/companies/'+company.id, company, httpOptions)

=======
        'Authorization': `Basic ${credentials}`
      })
    };
    return this.http.put<Company>(this.baseUrl+'api/company/', company, httpOptions)
>>>>>>> 8389bf09fdf474da4d63d94f8bf9e3434c8f6b18
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('CompanyService.updateCompany(): error updating company.');
      })
    );
  }

  // returns boolean if the user in creds is the owner of a company
  // id passed is company id
  // credentials passed to method
  isOwner(id){
    const credentials = this.userSvc.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Basic ${credentials}`
      })
    };
    return this.http.get<Boolean>(this.baseUrl+'api/companies/'+id+'/owner', httpOptions)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('CompanyService.isOwner(): error confirming owner.');
      })
    );
  }
}
