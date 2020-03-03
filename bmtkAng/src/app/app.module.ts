import { CompanyNameSearchPipe } from './pipes/company-name-search.pipe';
import { TaskIsActivePipe } from './pipes/task-is-active.pipe';
import { IsCustomerPipe } from './pipes/is-customer.pipe';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { UserListComponent } from './components/user-list/user-list.component';
import {EmployeeListComponent} from './components/employee-list/employee-list.component'
import { UserService } from './services/user/user.service';
import {EmployeeService} from './services/employee/employee.service';
import {ProjectService} from './services/project/project.service';
import { TaskService } from './services/task/task.service';

import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { LearnMoreComponent } from './components/learn-more/learn-more.component';
import { CurrentCustomersComponent } from './components/current-customers/current-customers.component';
import { CustomerNewComponent } from './components/customer-new/customer-new.component';
import { CompanyListComponent } from './components/company-list/company-list.component';

import { FormsModule } from '@angular/forms';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CompanyComponent } from './components/company/company.component';
import { AccountComponent } from './components/account/account.component';

import { DragScrollModule } from 'ngx-drag-scroll';





@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    EmployeeListComponent,
    LoginComponent,
    HomeComponent,
    LearnMoreComponent,
    CurrentCustomersComponent,
    CustomerNewComponent,
    CompanyListComponent,
    NavbarComponent,
    CompanyComponent,
    AccountComponent,
    IsCustomerPipe,
    TaskIsActivePipe,
    CompanyNameSearchPipe

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    DragScrollModule,



  ],
  providers: [UserService, EmployeeService, ProjectService, TaskService, IsCustomerPipe, TaskIsActivePipe,
    CompanyNameSearchPipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
