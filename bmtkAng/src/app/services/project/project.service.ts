import { Project } from './../../models/project';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserService } from '../user/user.service';
import { Company } from 'src/app/models/company';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {


  baseUrl = 'http://localhost:8085/';

  constructor(private http: HttpClient,
    private userSvc: UserService) { }


  // creates a project, takes company id to assign to project
  // takes user credentials to tie customer to project
  createProject(project, cid){
    const credentials = this.userSvc.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Basic ${credentials}`
      })
    };
     return this.http.post<Project>(this.baseUrl+'api/companies/'+cid+'/projects', project, httpOptions)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('ProductService.createProject(): error creating project.');
      })
    );
  }

  // updates a project, takes company id and project id for confirmation of correct project
  // TODO also takes user creds to confirm user is able to update project
  updateProject(project, cid, pid){
    const credentials = this.userSvc.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Basic ${credentials}`
      })
    };
    return this.http.put<Project>(this.baseUrl+'api/companies/'+cid+'/projects/'+pid, project, httpOptions)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('ProductService.updateProject(): error updating project.');
      })
    );
  }

  // gets a user(customer)'s projects
  // takes and passes creds
  getMyProjectRequests(){
    const credentials = this.userSvc.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Basic ${credentials}`
      })
    };
    return this.http.get<Project[]>(this.baseUrl + 'api/projects', httpOptions)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('ProjectService.getMyProjectRequests(): error getting my projects.');
      })
    );
  }
}
