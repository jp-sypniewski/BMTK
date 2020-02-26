import { Customer } from './customer';
import { Company } from './company';
import { Task } from './task';

export class Project {
id: number;
name: string;
customer: Customer;
company: Company;
tasks: Array<Task>;

constructor(id?: number, name?: string, customer?: Customer, company?: Company,
  tasks?: Array<Task>){

    this.id = id;
    this.name = name;
    this.customer = customer;
    this.company = company;
    this.tasks = tasks;
}


}
