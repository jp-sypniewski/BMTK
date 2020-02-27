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



  newCompany: Company;
  companyCreated: string;
  companies: Company[] = [];


  constructor(private router: Router, private compSvc: CompanyService) { }

  ngOnInit(): void {
    this.reload();
  }

  showCreateCompany(){
    this.newCompany = new Company();

  }

  saveCreateCompany(){
    this.companyCreated = "";


    this.compSvc.createCompany(this.newCompany).subscribe(
      data => {
        console.log('RegisterComponent.register(): company registered.');
        this.newCompany = new Company();
        //this.router.navigate(['companynew']);
      },
      err => {
        console.error('RegisterComponent.register(): error registering.');
        this.companyCreated = "Error Creating Company";
      }
    );
  }

reload(){
  this.compSvc.index().subscribe(
    data => {
      return this.companies = data;
    },
    err => {
      return console.error('Observer got an error: ' + err);
    }
  );
}
}
