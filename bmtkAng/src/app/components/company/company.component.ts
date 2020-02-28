import { IsCustomerPipe } from './../../pipes/is-customer.pipe';
import { User } from 'src/app/models/user';
import { TaskService } from './../../services/task/task.service';
import { ProjectService } from './../../services/project/project.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Company } from './../../models/company';
import { CompanyService } from './../../services/company/company.service';
import { UserService } from 'src/app/services/user/user.service';
import { Task } from './../../models/task';
import { Project } from './../../models/project';
import { Component, OnInit } from '@angular/core';
import { UserDetail } from 'src/app/models/userDetail';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  currentUser: User;

  aCompany: Company = new Company();
  projectsForCompany: Project[] = [];
  selectedProject: Project;
  newTask: Task;
  editingATask: Boolean;
  id: Number;


  empTasksToDo: Task[] = [];

  projectsRequested: Project[] = [];
  newProject: Project;

  constructor(private router: Router, private userSvc: UserService, private compSvc: CompanyService,
    private currentRoute: ActivatedRoute, private projSvc: ProjectService, private taskSvc: TaskService,
    private isCustomer: IsCustomerPipe) { }

  ngOnInit(): void {
    if (this.currentRoute.snapshot.paramMap.get('id')){
      let theId = Number(this.currentRoute.snapshot.paramMap.get('id'));

      if (this.userSvc.checkLogin()){
        this.userSvc.getUserInfo().subscribe(
          data => {
            this.currentUser = data;
          },
          err => {
            this.currentUser = new User();
            this.currentUser.userDetail = new UserDetail();
            this.currentUser.userDetail.id = 0;
            console.error('UserComponent.init(): error getting user data with principal.');
          }
        );
      } else {
        this.currentUser = new User();
        this.currentUser.userDetail = new UserDetail();
        this.currentUser.userDetail.id = 0;
      }
      this.reload(theId);

    }
  }

  reload(id){
    this.compSvc.getSingleCompany(id).subscribe(
      data => {
        this.aCompany = data;
        this.compSvc.getProjectsByCompany(data.id).subscribe(
          data => {
            this.projectsForCompany = data;
            this.empTasksToDo = [];
            for (let i = 0; i < data.length; i++){
              for (let j = 0; j < data[i].tasks.length; j++){
                this.empTasksToDo.push(data[i].tasks[j])
              }
            }
          },
          err => {
            console.error('CompanyComponent: error getting projects by company');
          }
        );

        this.compSvc.getProjectsByCompany(data.id).subscribe(
          data => {
            this.projectsRequested = [];
            for (let i = 0; i < data.length; i++){
              if (data[i].customer.userDetail.id === this.currentUser.userDetail.id){
                this.projectsRequested.push(data[i]);
              }
            }

          },
          err => {
            console.error('CompanyComponent: error getting projects by company');
          }
        );

      },
      err => {
        console.error('CompanyComponent: error finding company');
        // add redirect to company list
      }
    );
  }

  showProjectDetails(project){
    this.selectedProject = project;
  }

  showCreateTask(){
    this.newTask = new Task();
    this.editingATask = false;
  }

  saveNewTask(){
    this.taskSvc.createTask(this.newTask, this.selectedProject.id).subscribe(
      data => {
        this.newTask = null;
        this.reload(this.aCompany.id);
        this.selectedProject.tasks.push(data);
      },
      err => {
        console.error('CompanyComponent: error saving new task');
        // add redirect to company list
      }
    );

  }

  showEditTask(task){
    this.newTask = task;
    this.editingATask = true;
  }

  saveEditTask(){
    this.taskSvc.updateTask(this.newTask, this.selectedProject.id, this.newTask.id).subscribe(
      data => {
        this.newTask = null;
        this.reload(this.aCompany.id);
      },
      err => {
        console.error('CompanyComponent: error saving task update');
        // add redirect to company list
      }
    );
  }

  showRequestNewProject(){
    this.newProject = new Project();
  }

  saveRequestNewProject(){
    this.projSvc.createProject(this.newProject, this.aCompany.id).subscribe(
      data => {
        this.newProject = null;
        this.reload(this.aCompany.id);
      },
      err => {
        console.error('CompanyComponent: error saving new project');
        // add redirect to company list
      }
    );
  }

}
