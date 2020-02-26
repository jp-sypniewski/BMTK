import { NgModule } from '@angular/core';
import { EmployeeListComponent } from './components/employee-list/employee-list.component';
import { UserListComponent } from './components/user-list/user-list.component';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { LearnMoreComponent } from './components/learn-more/learn-more.component';
import { CurrentCustomersComponent } from './components/current-customers/current-customers.component';
import { CustomerNewComponent } from './components/customer-new/customer-new.component';
import { CompanyCreatedComponent } from './components/company-created/company-created.component';
import { CompanyListComponent } from './components/company-list/company-list.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  {path: 'employee', component: EmployeeListComponent},
    {path: 'user',component: UserListComponent},
    {path: 'login', component: LoginComponent},
    {path: 'learn', component: LearnMoreComponent},
    {path: 'currentcustomer', component: CurrentCustomersComponent},
    {path: 'customer', component: CustomerNewComponent},
    {path: 'companycreated', component: CompanyCreatedComponent},
    {path: 'companylist', component: CompanyListComponent},
    {path: 'home', component: HomeComponent},


]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {




}
