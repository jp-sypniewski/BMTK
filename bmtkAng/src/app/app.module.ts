import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { UserListComponent } from './user/user-list/user-list.component';
import {EmployeeListComponent} from './employee/employee-list/employee-list.component'
import { UserService } from './user/user.service';
import {EmployeeService} from './employee/employee.service';

import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home/home.component';

import {RouterModule, Routes} from '@angular/router';
import { LoginComponent } from './login/login/login.component';
import { LearnMoreComponent } from './learn-more/learn-more/learn-more.component';
import { CurrentCustomersComponent } from './current-customers/current-customers/current-customers.component';

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    EmployeeListComponent,
    LoginComponent,
    HomeComponent,
    LearnMoreComponent,
    CurrentCustomersComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,

  ],
  providers: [UserService, EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
