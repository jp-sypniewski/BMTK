import { Component, OnInit, ViewChild } from '@angular/core';
import { DragScrollComponent } from 'ngx-drag-scroll';


@Component({
  selector: 'app-learn-more',
  templateUrl: './learn-more.component.html',
  styleUrls: ['./learn-more.component.css']
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
