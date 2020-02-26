import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user/user.service';
import { User } from 'src/app/models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [UserService]
})
export class LoginComponent implements OnInit {

  user: User = new User();
  constructor(private router: Router,
    private userService: UserService) { }

  ngOnInit(): void {
  }

  getUserByUserNamePassword(){
    this.userService.getAllUsers().subscribe(
      user => {
        //this.user = user;
      },
      err => {console.log(err);
      }
    );
  }

}
