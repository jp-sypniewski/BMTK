import { ProjectService } from './../../services/project/project.service';
import { CompanyService } from './../../services/company/company.service';
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

  newUser: User = new User();
  newUserDetail: UserDetail = new UserDetail();
  userCreated: String = new String();
  userTable: boolean = false;
  companyTable: boolean = false;
  editCompany: Company = new Company();

  currentUser: User;

  companiesOwned: Company[] = [];
  tasksToDo: Task[] = [];
  projectsRequested: Project[] = [];

  constructor(private router: Router,
    private userSvc: UserService, private compSvc: CompanyService, private projSvc: ProjectService) { }

  ngOnInit(): void {
    if (this.userSvc.checkLogin()){
      this.userSvc.getUserInfo().subscribe(
        data => {
          this.currentUser = data;
        },
        err => {
          this.newUser = new User();
          this.newUserDetail = new UserDetail();
          console.error('UserComponent.init(): error getting user data with principal.');
        }
      );

      this.compSvc.getMyCompanies().subscribe(
        data => {
          this.companiesOwned= data;
        },
        err => {

          console.error('UserComponent.init(): error getting user data with principal.');
        }
      );

      this.projSvc.getMyProjectRequests().subscribe(
        data => {
          this.projectsRequested= data;
          console.log()
        },
        err => {

          console.error('UserComponent.init(): error getting user data with principal.');
        }
      );

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

  goToCompanyPage(cid){
    this.router.navigateByUrl('/company/'+cid);
  }

  displayUserInfo(){
    this.userTable = true;
  }

  displayCompanyInfo(cid){
    this.companyTable = true;
    this.compSvc.getSingleCompany(cid).subscribe(
      data => {
        this.editCompany = data;
          err => {
            console.error('CompanyComponent: error getting company by id');
          }
        }
        );

  }

  editUserInfo(){}

  editCompanyInfo(){
    this.compSvc.updateCompany(this.editCompany).subscribe(
      data => {
        this.editCompany = null;
        this.companyTable = false;
        this.router.navigateByUrl('/account');
        },
        err => {
          console.error('CompanyComponent: error editing company');
        }
        );
  }

}
