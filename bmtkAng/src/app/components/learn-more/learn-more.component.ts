import { Component, OnInit, ViewChild, NgModule, HostBinding } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgStyle } from '@angular/common';

import {
  trigger,
  state,
  style,
  animate,
  transition,
  // ...
} from '@angular/animations';

@Component({
  selector: 'app-learn-more',
  templateUrl: './learn-more.component.html',
  styleUrls: ['./learn-more.component.css'],
  animations: [
    // animation triggers go here
  ]
})

export class LearnMoreComponent implements OnInit {
  carStyle;
carousel = document.getElementsByClassName('.carousel');
cellCount = 6;
selectedIndex = 0;

  constructor() { }

  ngOnInit(): void {

  }

  prev(){
    this.selectedIndex--;
    var angle = this.selectedIndex / this.cellCount * -360;
  /*this.carousel.style.transform = 'translateZ(-288px) rotateY(' + angle + 'deg)';*/
  this.carStyle = {transform: 'translateZ(-288px) rotateY(' + angle + 'deg)'};
  }

  next(){
    this.selectedIndex++;
    var angle = this.selectedIndex / this.cellCount * -360;
  /*this.carousel.style.transform = 'translateZ(-288px) rotateY(' + angle + 'deg)';*/
  this.carStyle = {transform: 'translateZ(-288px) rotateY(' + angle + 'deg)'};
  }



}
