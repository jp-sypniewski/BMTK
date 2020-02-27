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


  empTasksToDo: Task[] = [];

  projectsRequested: Project[] = [];

  constructor() { }

  ngOnInit(): void {
  }

}
