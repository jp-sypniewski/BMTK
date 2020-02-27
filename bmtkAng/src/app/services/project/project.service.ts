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

  createProject(project){
    const credentials = this.userSvc.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Basic ${credentials}` // might have to add back x-reqeusted-with 'xmlhttprequest'
      })
    };

     return this.http.post<Company>(this.baseUrl+'api/companies', project, httpOptions)

    .pipe(
      catchError((err: any) => {
        console.log(err);

        return throwError('AuthService.register(): error registering company.');

      })
    );
  }

  updateProject(project){

    return this.http.put<Company>(this.baseUrl+'api/company/', project)

    .pipe(
      catchError((err: any) => {
        console.log(err);

        return throwError('AuthService.register(): error registering company.');

      })
    );
  }
}
