import { Component, OnInit, Optional } from '@angular/core';
import { Company } from '../../models/company';
import { User } from '../../models/user';
import { Router, RouterLink } from '@angular/router';
import { UserService } from '../../services/user/user.service';
import { UserDetail } from 'src/app/models/userDetail';
import { CompanyService} from '../../services/company/company.service';
import { CompanyCreatedComponent } from '../company-created/company-created.component';

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
  companyCreatedComponent: CompanyCreatedComponent = new CompanyCreatedComponent(this.router, this.userService, this.companyService);
  constructor(private router: Router, private userService: UserService, private companyService: CompanyService) { }

  ngOnInit(): void {
  }

  createCompany(){
    this.companyCreated = "";
    console.log(JSON.stringify(this.company));
    this.companyCreatedComponent.getCompany(this.company);

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
