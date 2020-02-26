import { CompanyService } from './../../services/company/company.service';
import { Company } from './../../models/company';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  company: Company = new Company();
  companyCreated: string;

  constructor(private router: Router, private compSvc: CompanyService) { }

  ngOnInit(): void {
  }

  createCompany(){
    this.companyCreated = "";


    this.compSvc.createCompany(this.company).subscribe(
      data => {
        console.log('RegisterComponent.register(): company registered.');
        this.company = new Company();
        //this.router.navigate(['companynew']);
      },
      err => {
        console.error('RegisterComponent.register(): error registering.');
        this.companyCreated = "Error Creating Company";
      }
    );

}
}
