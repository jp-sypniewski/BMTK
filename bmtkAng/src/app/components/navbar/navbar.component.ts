import { UserService } from 'src/app/services/user/user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private userSvc: UserService) { }

  ngOnInit(): void {
  }

  checkForUser(){
    return this.userSvc.checkLogin();
  }

  logout(){
    this.userSvc.logout();
  }




}
