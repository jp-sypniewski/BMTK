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

        return throwError('ProductService.createProject has encountered an error');

      })
    );
  }

  updateProject(project, cid, pid){
    const credentials = this.userSvc.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Basic ${credentials}`
      })
    };

    return this.http.put<Project>(this.baseUrl+'api/companyies/'+cid+'/projects/'+pid, project, httpOptions)

    .pipe(
      catchError((err: any) => {
        console.log(err);

        return throwError('ProductService.updateProject has encountered an error');

      })
    );
  }
}
