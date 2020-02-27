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

  newUser: User;
  newUserDetail: UserDetail;
  userCreated: String = new String();

  currentUser: User;

  companiesOwned: Company[] = [];
  tasksToDo: Task[] = [];
  projectsRequested: Project[] = [];


  constructor(private router: Router,
    private userSvc: UserService) { }

  ngOnInit(): void {
    if (this.userSvc.checkLogin()){
      this.currentUser = new User();
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

}
