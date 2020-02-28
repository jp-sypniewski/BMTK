import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { DragScrollComponent } from 'ngx-drag-scroll';

@Component({
  selector: 'app-current-customers',
  templateUrl: './current-customers.component.html',
  styleUrls: ['./current-customers.component.css'],
})
export class CurrentCustomersComponent implements OnInit {
  btn = require('button-styles');

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  @ViewChild('nav', {read: DragScrollComponent}) ds: DragScrollComponent;
  moveLeft() {
    this.ds.moveLeft();
  }
  moveRight() {
    this.ds.moveRight();
  }



}
