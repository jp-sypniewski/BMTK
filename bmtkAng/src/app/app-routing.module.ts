import { NgModule } from '@angular/core';
import { EmployeeListComponent } from './components/employee-list/employee-list.component';
import { UserListComponent } from './components/user-list/user-list.component';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { LearnMoreComponent } from './components/learn-more/learn-more.component';
import { CurrentCustomersComponent } from './components/current-customers/current-customers.component';
import { CompanyNewComponent } from './components/company-new/company-new.component';
import { CustomerNewComponent } from './components/customer-new/customer-new.component';

const routes: Routes = [
  {path: 'employee', component: EmployeeListComponent},
    {path: 'user',component: UserListComponent},
    {path: 'login', component: LoginComponent},
    {path: 'learn', component: LearnMoreComponent},
    {path: 'currentcustomer', component: CurrentCustomersComponent},
    {path: 'companynew', component: CompanyNewComponent},
    {path: 'customer', component: CustomerNewComponent},

]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {




}
