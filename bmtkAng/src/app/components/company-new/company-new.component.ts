import { Component, OnInit, Optional, NgModule } from '@angular/core';
import { Company } from '../../models/company';
import { User } from '../../models/user';
import { Router, RouterLink } from '@angular/router';
import { UserService } from '../../services/user/user.service';
import { UserDetail } from 'src/app/models/userDetail';
import { CompanyService} from '../../services/company/company.service';
import { NgEventBus} from 'ng-event-bus';

@Component({
  selector: 'app-company-new',
  templateUrl: './company-new.component.html',
  styleUrls: ['./company-new.component.css'],
  providers: [CompanyService, UserService]
})


export class CompanyNewComponent implements OnInit {

  userList: User[];
  user: User = new User();
  newUserDetail = new UserDetail();
  companyCreated: String = new String();
  company: Company = new Company();
  //eventBus = new NgEventBus();

  constructor(private router: Router, private userService: UserService, private companyService: CompanyService, private eventBus: NgEventBus) { }

  ngOnInit(): void {this.eventBus.cast('companyNew:company', this.company);}

  createCompany(){
    this.companyCreated = "";
    this.company.name = "new company";
    this.company.type = "new company type";
    this.company.address = "new company address";
    this.company.companyUrl = "new company url";
    this.company.description = "new company desc";
    this.company.phone = "new company phone";
    var tempCompany = JSON.stringify(this.company);
    console.log(tempCompany);
    localStorage.setItem('company', tempCompany);

    //this.eventBus.cast('companyNew:company', JSON.stringify(this.company));
    this.router.navigate(['companycreated']);

    /*this.companyService.createCompany(this.company).subscribe(
      data => {
        console.log('RegisterComponent.register(): company registered.');
        this.router.navigate(['companycreated']);
      },
      err => {
        console.error('RegisterComponent.register(): error registering.');
        this.companyCreated = "Error Creating Company";
      }
    );*/

  }

}
