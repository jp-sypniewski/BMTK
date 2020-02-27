import { CompanyService } from './../../services/company/company.service';
import { Company } from './../../models/company';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-company-list',
  templateUrl: './company-list.component.html',
  styleUrls: ['./company-list.component.css']
})
export class CompanyListComponent implements OnInit {

  companies: Company[] = [];

  constructor(private compSvc: CompanyService) { }

  ngOnInit(): void {
    this.reload();
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
