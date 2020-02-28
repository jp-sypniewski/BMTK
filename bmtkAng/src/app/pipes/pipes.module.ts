import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IsCustomerPipe } from './is-customer.pipe';
import { TaskIsActivePipe } from './task-is-active.pipe';
import { CompanyNameSearchPipe } from './company-name-search.pipe';



@NgModule({
  declarations: [IsCustomerPipe, TaskIsActivePipe, CompanyNameSearchPipe],
  imports: [
    CommonModule
  ]
})
export class PipesModule { }
