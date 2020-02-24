import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LearnMoreRoutingModule } from './learn-more-routing.module';
import { LearnMoreComponent } from './learn-more/learn-more.component';


@NgModule({
  declarations: [LearnMoreComponent],
  imports: [
    CommonModule,
    LearnMoreRoutingModule
  ]
})
export class LearnMoreModule { }
