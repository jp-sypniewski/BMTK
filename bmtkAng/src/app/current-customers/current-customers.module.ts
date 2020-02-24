import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CurrentCustomersRoutingModule } from './current-customers-routing.module';
import { CurrentCustomersComponent } from './current-customers/current-customers.component';


@NgModule({
  declarations: [CurrentCustomersComponent],
  imports: [
    CommonModule,
    CurrentCustomersRoutingModule
  ]
})
export class CurrentCustomersModule { }
