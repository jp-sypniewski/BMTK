import { Task } from './../../models/task';
import { Project } from './../../models/project';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  projectsForCompany: Project[] = [];
  selectedProject: Project;
  newTask: Task;
  editingATask: Boolean;


  empTasksToDo: Task[] = [];

  projectsRequested: Project[] = [];
  newProject: Project;

  constructor() { }

  ngOnInit(): void {


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

  }

}
