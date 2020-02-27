import { ProjectService } from './../../services/project/project.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Company } from './../../models/company';
import { CompanyService } from './../../services/company/company.service';
import { UserService } from 'src/app/services/user/user.service';
import { Task } from './../../models/task';
import { Project } from './../../models/project';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  aCompany: Company;
  projectsForCompany: Project[] = [];
  selectedProject: Project;
  newTask: Task;
  editingATask: Boolean;
  id: Number;


  empTasksToDo: Task[] = [];

  projectsRequested: Project[] = [];
  newProject: Project;

  constructor(private router: Router, private userSvc: UserService, private compSvc: CompanyService,
    private currentRoute: ActivatedRoute, private projSvc: ProjectService) { }

  ngOnInit(): void {
    if (this.currentRoute.snapshot.paramMap.get('id')){
      let theId = Number(this.currentRoute.snapshot.paramMap.get('id'));
      this.reload(theId);



    }
  }

  reload(id){
    this.compSvc.getSingleCompany(id).subscribe(
      data => {
        this.aCompany = data;
        this.projectsForCompany = data.projects;
        for (let i = 0; i < data.projects.length; i++){
          for (let j = 0; j < data.projects[i].tasks.length; j++){
            this.empTasksToDo.push(data.projects[i].tasks[j])
          }
        }
        this.projectsRequested = data.projects;
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
  }

  showEditTask(task){
    this.newTask = task;
    this.editingATask = true;
  }

  saveEditTask(){
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
