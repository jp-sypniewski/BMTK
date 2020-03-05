import { environment } from './../../../environments/environment';
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

  // private baseUrl = 'http://localhost:8085/';
  private baseUrl = environment.baseUrl;

  constructor(private http: HttpClient,
    private userSvc: UserService) { }

    // creates a task, takes in project id to tie task to project
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
          return throwError('TaskService.createTask(): error creating task.');
        })
      );
    }

    // updates a task, takes in project id and task id to confirm correct task is being updated
    updateTask(task, tid){
      const credentials = this.userSvc.getCredentials();
      const httpOptions = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Authorization': `Basic ${credentials}`
        })
      };
      return this.http.put<Task>(this.baseUrl+'api/tasks/'+tid, task, httpOptions)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('TaskService.updateTask(): error updating task.');
        })
      );
    }

    getTasksByEmpUsername(){
      const credentials = this.userSvc.getCredentials();
      const httpOptions = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Authorization': `Basic ${credentials}`
        })
      };
      return this.http.get<Task[]>(this.baseUrl+'api/tasks', httpOptions)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('TaskService.getTasksByEmpUsername(): error getting employee\'s tasks.');
        })
      );
    }
}
