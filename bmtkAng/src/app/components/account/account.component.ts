import { TaskService } from './../../services/task/task.service';
import { ProjectService } from './../../services/project/project.service';
import { CompanyService } from './../../services/company/company.service';
import { Project } from './../../models/project';
import { Task } from './../../models/task';
import { Company } from './../../models/company';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user/user.service';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserDetail } from 'src/app/models/userDetail';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  newUser: User = new User();
  newUserDetail: UserDetail = new UserDetail();
  userCreated: String = new String();

  currentUser: User;

  headerMessage: string = null;

  editUser: User = null;
  editProject: Project = null;
  editCompany: Company = null;

  companiesOwned: Company[] = [];
  tasksToDo: Task[] = [];
  projectsRequested: Project[] = [];

  constructor(private router: Router,
    private userSvc: UserService,
    private compSvc: CompanyService,
    private projSvc: ProjectService,
    private taskSvc: TaskService) { }

  ngOnInit(): void {
    this.reload();
  }

  reload(){
    if (this.userSvc.checkLogin()){
      this.userSvc.getUserInfo().subscribe(
        data => {
          this.currentUser = data;
        },
        err => {
          this.newUser = new User();
          this.newUserDetail = new UserDetail();
          console.error('UserComponent.reload(): error getting user data with principal.');
        }
      );

      this.compSvc.getMyCompanies().subscribe(
        data => {
          this.companiesOwned = data;
        },
        err => {
          console.error('UserComponent.reload(): error getting user owner company data.');
        }
      );

      this.taskSvc.getTasksByEmpUsername().subscribe(
        data => {
          this.tasksToDo = data;
        },
        err => {
          console.error('UserComponent.reload(): error getting user owner company data.');
        }
      );

      this.projSvc.getMyProjectRequests().subscribe(
        data => {
          this.projectsRequested = data;
        },
        err => {
          console.error('UserComponent.reload(): error getting user customer project data.');
        }
      );

    } else {
      this.newUser = new User();
      this.newUserDetail = new UserDetail();
    }
  }



  saveCreateUser(){
    this.newUser.userDetail = this.newUserDetail;
    this.userSvc.createUser(this.newUser).subscribe(
      data => {
        console.log('RegisterComponent.register(): user registered.');
      },
      err => {
        console.error('RegisterComponent.register(): error registering.');
      }
    );
  }

  goToCompanyPage(cid){
    this.router.navigateByUrl('/company/'+cid);
  }

  showEditUser(){
    this.cancelAllEditForms();
    this.nullHeaderMessage();
    this.editUser = Object.assign({}, this.currentUser);
  }

  saveEditUser(){
    this.userSvc.updateUser(this.editUser).subscribe(
      data => {
        this.headerMessage = "User: " + data.username + " updated!";
        this.editUser = null;
        this.reload();
      },
      err => {
        console.error('CompanyComponent: error updating user');
      }
    );
  }

  showEditCompany(company){
    this.cancelAllEditForms();
    this.nullHeaderMessage();
    this.editCompany = Object.assign({}, company);
  }

  saveEditCompany(){
    this.compSvc.updateCompany(this.editCompany).subscribe(
      data => {
        this.headerMessage = "Company: " + data.name + " updated!";
        this.editCompany = null;
        this.reload();
      },
      err => {
        console.error('CompanyComponent: error editing company');
      }
    );
  }


  showEditProject(project){
    this.cancelAllEditForms();
    this.nullHeaderMessage();
    this.editProject = Object.assign({}, project);
  }

  saveEditProject(){
    this.projSvc.updateProject(this.editProject, this.editProject.company.id, this.editProject.id).subscribe(
      data => {
        this.headerMessage = "Project: " + data.name + " updated!";
        this.editProject = null;
        this.reload();
      },
      err => {
        console.error('ProjectComponent: error getting updating project');
      }
    );
  }

  cancelAllEditForms(){
    this.editUser = null;
    this.editCompany = null;
    this.editProject = null;
  }

  redirToSignIn(){
    this.router.navigateByUrl('/login');
  }

  nullHeaderMessage(){
    this.headerMessage = null;
  }

}
