import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css'],
  providers: [UserService]
})
export class UserListComponent implements OnInit {
userList: User[];
user: User = new User();
  constructor(private router: Router,
    private userService: UserService) { }

  ngOnInit(): void {
    this.getAllUsers();
  }

  getAllUsers(){
    this.userService.getAllUsers().subscribe(
      user => {
        this.user = user;
      },
      err => {console.log(err);
      }
    );
  }

  createUser(): void{
    this.user.username = "test";
    var newUser: User = Object.assign({}, this.user);
    //newUser.username = document.getElementById("username").nodeValue;
    this.userService.createUser(newUser).subscribe(

      (error: any) => console.log(error)
      );
  }

}
