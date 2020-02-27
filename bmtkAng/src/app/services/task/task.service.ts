import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserService } from '../user/user.service';
import { Project } from 'src/app/models/project';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { Task } from 'src/app/models/task';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  baseUrl = 'http://localhost:8085/';

  constructor(private http: HttpClient,
    private userSvc: UserService) { }

    createTask(task, pid){
      const credentials = this.userSvc.getCredentials();
      const httpOptions = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Authorization': `Basic ${credentials}`
        })
      };

       return this.http.post<Task>(this.baseUrl+'api/projects/'+pid+'/tasks', task, httpOptions)

      .pipe(
        catchError((err: any) => {
          console.log(err);

          return throwError('TaskService.createTask has encountered an error');

        })
      );
    }

    updateTask(task, pid, tid){
      const credentials = this.userSvc.getCredentials();
      const httpOptions = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Authorization': `Basic ${credentials}`
        })
      };

      return this.http.put<Task>(this.baseUrl+'api/projects/'+pid+'/tasks/'+tid, task, httpOptions)

      .pipe(
        catchError((err: any) => {
          console.log(err);

          return throwError('TaskService.updateTask has encountered an error');

        })
      );
    }
}
