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

  userList: User[];
  user: User = new User();
  newUserDetail = new UserDetail();
  userCreated: String = new String();


  constructor(private router: Router,
    private userSvc: UserService) { }

  ngOnInit(): void {
  }

  createUser(){
    // this.router.navigate(['companynew']);

    this.user.userDetail = this.newUserDetail;
    this.userSvc.createUser(this.user).subscribe(
      data => {
        console.log('RegisterComponent.register(): user registered.');
        this.router.navigate(['companynew']);
      },
      err => {
        console.error('RegisterComponent.register(): error registering.');
      }
    );

  }

}
