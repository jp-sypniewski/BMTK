import { Component, OnInit, Optional } from '@angular/core';
import { User } from '../../models/user';
import { Router, RouterLink } from '@angular/router';
import { UserService } from '../../services/user/user.service';
import { UserDetail } from 'src/app/models/userDetail';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css'],
  providers: [UserService]
})
export class UserListComponent implements OnInit {

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





