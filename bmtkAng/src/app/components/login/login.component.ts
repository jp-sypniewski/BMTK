import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user/user.service';
import { User } from 'src/app/models/user';
import { Router } from '@angular/router';
import { Project } from 'src/app/models/project';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [UserService]
})
export class LoginComponent implements OnInit {

  user: User = new User();
  temp = '';
  temp1 = "";
  temp2 = "";
  temp3 = "";
  constructor(private router: Router,
    private userService: UserService) { }

  ngOnInit(): void {
  }

  getUserByUserNamePassword(){
    this.temp = "Based on the users login in info they now have options:"
    this.temp1 = `If they are an owner: Update company info, view projects, update user account,\n
    create Project, create new company`;

    this.temp2 = `If they are an employee:\n
    Update user info, view Projects, create projects`;

    this.temp3 = `If they are a customer:\n
    Update user info, view projects, create projects, company list drop down\n
    to go to company pages, create a company, search for a company\n
    If they create a new account by default they are a customer\n
    and they have the option to create a company`;

  }

}
