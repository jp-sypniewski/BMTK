import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IsCustomerPipe } from './is-customer.pipe';
import { TaskIsActivePipe } from './task-is-active.pipe';



@NgModule({
  declarations: [IsCustomerPipe, TaskIsActivePipe],
  imports: [
    CommonModule
  ]
})
export class PipesModule { }
