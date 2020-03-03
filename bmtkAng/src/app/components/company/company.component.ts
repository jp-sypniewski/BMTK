import { Employee } from './../../models/employee';
import { TaskIsActivePipe } from './../../pipes/task-is-active.pipe';
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

  showEmployees: Boolean = false;

  addingEmployee: Boolean = false;

  emailSearch: String = "";
  usersFound: User[] = [];

  aCompany: Company = new Company();
  projectsForCompany: Project[] = [];
  selectedProject: Project;
  editingProject: Project;
  newTask: Task;
  selectedEmployee: number;
  editingATask: Boolean;

  selectedProjectId: Number = 0;
  needToPreselectProject: boolean = false;



  id: Number;
  isOwner: Boolean = false;


  empTasksToDo: Task[] = [];

  projectsRequested: Project[] = [];
  newProject: Project;

  constructor(private router: Router, private userSvc: UserService, private compSvc: CompanyService,
    private currentRoute: ActivatedRoute, private projSvc: ProjectService, private taskSvc: TaskService,
    private isCustomer: IsCustomerPipe, private taskIsActive: TaskIsActivePipe) { }

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
    if (this.userSvc.checkLogin()){
      // if a user is signed in, will display appropriate company data
      this.compSvc.getSingleCompany(id).subscribe(
        compData => {
          this.aCompany = compData;
          this.compSvc.getProjectsByCompany(compData.id).subscribe(
            projData => {
              // assigns projects into array to display if the user is the owner
              this.compSvc.isOwner(this.aCompany.id).subscribe(
                isOwnerCheck => {
                  if (isOwnerCheck){
                    this.projectsForCompany = projData;
                  }
                },
                err => {
                  console.log("CompanyComponent: error checking for owner");
                }
              );
              // check for a preselected project and load it
              if (this.needToPreselectProject){
                for (let i = 0; i < projData.length; i++){
                  if (this.selectedProjectId == projData[i].id){
                    this.selectedProject = projData[i];
                    this.needToPreselectProject = false;
                    this.selectedProjectId = 0;
                    break;
                  }
                }
              }

              // assigns tasks into array to display (for employee, ????)
              this.empTasksToDo = [];
              for (let i = 0; i < projData.length; i++){
                for (let j = 0; j < projData[i].tasks.length; j++){
                  for (let k = 0; k < projData[i].tasks[j].employees.length; k++){
                    if (projData[i].tasks[j].employees[k].userDetail.id === this.currentUser.userDetail.id){
                      this.empTasksToDo.push(projData[i].tasks[j]);
                    }
                  }
                }
              }
              // assigns projects into array to display if the user is the customer for a given company project
              this.projectsRequested = [];
              for (let i = 0; i < projData.length; i++){
                if (projData[i].customer.userDetail.id === this.currentUser.userDetail.id){
                  this.projectsRequested.push(projData[i]);
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
        }
      );
    } else {
      this.compSvc.getSingleCompany(id).subscribe(
        data => {
          this.aCompany = data;
        },
        err => {
          console.error('CompanyComponent: error finding company');
        }
      );
    }
  }

  performSearch(){
    this.userSvc.searchUsersByEmail(this.emailSearch).subscribe(
      data => {
        this.usersFound = data;
      },
      err => {
        console.error('CompanyComponent: error searching users');
      }
    );
  }


  showProjectDetails(project){
    this.selectedProject = project;
  }


  showCreateTask(){
    this.newTask = new Task();
    this.newTask.employees = [];
    this.selectedEmployee = 0;
    this.editingATask = false;
  }


  saveNewTask(){
    for (let i = 0; i < this.aCompany.employees.length; i++){
      if (this.selectedEmployee == this.aCompany.employees[i].id){
        let anEmployee = Object.assign({}, this.aCompany.employees[i])
        this.newTask.employees.push(anEmployee);
      }
    }
    this.taskSvc.createTask(this.newTask, this.selectedProject.id).subscribe(
      data => {
        this.needToPreselectProject = true;
        this.selectedProjectId = this.selectedProject.id;
        this.newTask = null;
        this.reload(this.aCompany.id);
      },
      err => {
        console.error('CompanyComponent: error saving new task');
      }
    );
  }


  showEditTask(task){
    this.newTask = Object.assign({}, task);
    if (task.employees.length != 0){
      this.selectedEmployee = task.employees[0].id;
    }
    this.editingATask = true;
  }


  saveEditTask(){
    this.newTask.employees = [];
    for (let i = 0; i < this.aCompany.employees.length; i++){
      if (this.selectedEmployee == this.aCompany.employees[i].id){
        let anEmployee = Object.assign({}, this.aCompany.employees[i])
        this.newTask.employees.push(anEmployee);
      }
    }
    this.taskSvc.updateTask(this.newTask, this.newTask.id).subscribe(
      data => {
        this.needToPreselectProject = true;
        this.selectedProjectId = this.selectedProject.id;
        this.newTask = null;
        this.reload(this.aCompany.id);
      },
      err => {
        console.error('CompanyComponent: error saving task update');
      }
    );
  }

  cancelNewOrEditTask(){
    this.newTask = null;
    this.selectedEmployee = null;
    this.editingATask = null;
  }

  cancelNewProject(){
    this.newProject = null;
  }


  // shows the form to request a new project as a customer
  // will redirect to login if there is not a logged in user
  showRequestNewProject(){
    if (this.userSvc.checkLogin()){
      this.newProject = new Project();
    } else {
      this.router.navigateByUrl('/login');
    }
  }


  saveRequestNewProject(){
    this.projSvc.createProject(this.newProject, this.aCompany.id).subscribe(
      data => {
        this.newProject = null;
        this.reload(this.aCompany.id);
      },
      err => {
        console.error('CompanyComponent: error saving new project');
      }
    );
  }

  disableTask(task){
    task.active = false;
    this.taskSvc.updateTask(task, task.id).subscribe(
      data => {
        this.needToPreselectProject = true;
        this.selectedProjectId = this.selectedProject.id;
        this.newTask = null;
        this.reload(this.aCompany.id);
      },
      err => {
        console.error('CompanyComponent: error saving task update');
      }
    );
  }

  showEditProject(project){
    this.editingProject = Object.assign({}, this.selectedProject);
  }

  saveEditProject(){
    this.projSvc.updateProject(this.editingProject, this.aCompany.id, this.selectedProject.id).subscribe(
      data => {
        this.needToPreselectProject = true;
        this.selectedProjectId = this.selectedProject.id;
        this.editingProject = null;
        this.reload(this.aCompany.id);
      },
      err => {
        console.error('CompanyComponent: error saving project update');
      }
    )
  }

  cancelEditProject(){
    this.editingProject = null;
  }

  userIsAlreadyEmp(id){
    for (let i = 0; i < this.aCompany.employees.length; i++){
      if (id == this.aCompany.employees[i].userDetail.id){
        return true;
      }
    }
    return false;
  }

  registerEmployee(user){
    this.userSvc.registerEmployee(user, this.aCompany.id).subscribe(
      data => {
        this.reload(this.aCompany.id);
      },
      err => {
        console.error('CompanyComponent: error adding user as employee')
      }
    );
  }

  removeEmployee(id){
    this.userSvc.removeEmployee(id).subscribe(
      data => {
        this.needToPreselectProject = true;
        this.selectedProjectId = this.selectedProject.id;
        this.reload(this.aCompany.id);
      },
      err => {
        console.error('CompanyComponent: error removing employee')
      }
    );
  }

}
