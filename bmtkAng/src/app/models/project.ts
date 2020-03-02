import { Customer } from './customer';
import { Company } from './company';
import { Task } from './task';

export class Project {
id: number;
name: string;
description: string;
customer: Customer;
company: Company;
tasks: Array<Task>;
active: Boolean;

constructor(id?: number, name?: string, description?: string, customer?: Customer, company?: Company,
  tasks?: Array<Task>, active?: Boolean){

    this.id = id;
    this.name = name;
    this.description = description;
    this.customer = customer;
    this.company = company;
    this.tasks = tasks;
    this.active = active;
}


}
