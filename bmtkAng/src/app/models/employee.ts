import { Task } from 'src/app/models/task';
import { Company } from 'src/app/models/company';
import { UserDetail } from './userDetail';

export class Employee {

  id: number;
  userDetail: UserDetail;
  company: Company;
  active: Boolean;
  tasks: Task[];

  constructor(id?: number, userDetail?: UserDetail, company?: Company,
    active?: Boolean, tasks?: Task[]){
    this.id = id;
    this.userDetail = userDetail;
    this.company = company;
    this.active = active;
    this.tasks = tasks;
  }
}
