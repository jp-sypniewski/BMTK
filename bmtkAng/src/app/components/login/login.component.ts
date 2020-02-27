import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user/user.service';
import { User } from 'src/app/models/user';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [UserService]
})
export class LoginComponent implements OnInit {

  user: User = new User();
  constructor(private router: Router,
    private userSvc: UserService) { }

  ngOnInit(): void {
  }

  logIn(form: NgForm){


    this.userSvc.login(form.value.username, form.value.password).subscribe(
      next => {
        console.log('RegisterComponent.register(): user logged in');
        this.router.navigateByUrl('/account');
      },
      error => {
        console.error('RegisterComponent.register(): error logging in.');
      }
    );
  }

}
