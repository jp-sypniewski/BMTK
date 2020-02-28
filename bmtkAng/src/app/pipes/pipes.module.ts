import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IsCustomerPipe } from './is-customer.pipe';



@NgModule({
  declarations: [IsCustomerPipe],
  imports: [
    CommonModule
  ]
})
export class PipesModule { }
