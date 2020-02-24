import { NgModule } from '@angular/core';
import { EmployeeListComponent } from './employee/employee-list/employee-list.component';
import { UserListComponent } from './user/user-list/user-list.component';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login/login.component';
import { LearnMoreComponent } from './learn-more/learn-more/learn-more.component';
import { CurrentCustomersComponent } from './current-customers/current-customers/current-customers.component';

const routes: Routes = [
  {path: 'employee', component: EmployeeListComponent},
    {path: 'user',component: UserListComponent},
    {path: 'login', component: LoginComponent},
    {path: 'learn', component: LearnMoreComponent},
    {path: 'currentcustomer', component: CurrentCustomersComponent},
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {




}
