import { CompanyNameSearchPipe } from './../../pipes/company-name-search.pipe';
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
  searchTerm: string = "";
  isSearching: Boolean = false;

  constructor(private router: Router, private compSvc: CompanyService, private companyNameSearch: CompanyNameSearchPipe) { }

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
        this.newCompany = null;
        this.goToCompanyPage(data.id);
      },
      err => {
        console.error('HomeComponent.register(): error registering.');
        this.companyCreated = "Error Creating Company";
      }
    );
  }

reload(){
  this.compSvc.index().subscribe(
    data => {
      console.log(data);

      return this.companies = data;
    },
    err => {
      return console.error('HomeComponent: Error reloading companies list.');
    }
  );
}

goToCompanyPage(cid){
  this.router.navigateByUrl('/company/'+cid);
}

searchByCompanyName(){
  this.isSearching = true;
}

showAll(){
  this.isSearching = false;
  this.searchTerm = "";
}

cancelCreate() {
  this.newCompany = null;
  this.isSearching = false;
}

}
