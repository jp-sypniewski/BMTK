import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { UserListComponent } from './components/user-list/user-list.component';
import {EmployeeListComponent} from './components/employee-list/employee-list.component'
import { UserService } from './services/user/user.service';
import {EmployeeService} from './services/employee/employee.service';

import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './components/home/home.component';

import { LoginComponent } from './components/login/login.component';
import { LearnMoreComponent } from './components/learn-more/learn-more.component';
import { CurrentCustomersComponent } from './components/current-customers/current-customers.component';
import { CompanyNewComponent } from './components/company-new/company-new.component';
import { CustomerNewComponent } from './components/customer-new/customer-new.component';
import { CompanyCreatedComponent } from './components/company-created/company-created.component';

import { FormsModule } from '@angular/forms';
import { CompanyCreatedComponent } from './components/company-created/company-created.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CompanyComponent } from './components/company/company.component';
import { AccountComponent } from './components/account/account.component';
import { CompanyListComponent } from './components/company-list/company-list.component';




@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    EmployeeListComponent,
    LoginComponent,
    HomeComponent,
    LearnMoreComponent,
    CurrentCustomersComponent,
    CompanyNewComponent,
    CustomerNewComponent,
    CompanyCreatedComponent,
    CompanyListComponent,
    NavbarComponent,
    CompanyComponent,
    AccountComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule

  ],
  providers: [UserService, EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
