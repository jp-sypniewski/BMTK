import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-current-customers',
  templateUrl: './current-customers.component.html',
  styleUrls: ['./current-customers.component.css']
})
export class CurrentCustomersComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

}
