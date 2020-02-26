import { Component, OnInit, Optional } from '@angular/core';
import { Company } from '../../models/company';
import { User } from '../../models/user';
import { Router, RouterLink } from '@angular/router';
import { UserService } from '../../services/user/user.service';
import { UserDetail } from 'src/app/models/userDetail';
import { CompanyService} from '../../services/company/company.service';

@Component({
  selector: 'app-company-created',
  templateUrl: './company-created.component.html',
  styleUrls: ['./company-created.component.css'],
  providers: [CompanyService, UserService]
})
export class CompanyCreatedComponent implements OnInit {
  userList: User[];
  user: User = new User();
  newUserDetail = new UserDetail();
  companyURL: String = new String();
  company: Company = new Company();

  constructor(private router: Router, private userService: UserService, private companyService: CompanyService,) { }

  ngOnInit(): void {
  }

  getCompany(company){
    this.company = company;
    console.log(JSON.stringify(this.company));
    return this.company;
  }

}
