import { Project } from './project';
import { Employee } from './employee';

export class Company {

  id: number;
  name: string;
  type: string;
  address: string;
  phone: string;
  description: string;
  companyUrl: string;
  projects: Project[];
  active: boolean;
  employees: Employee[];

  constructor(id?: number, name?: string, type?: string, address?: string,
    phone?: string, description?: string, companyUrl?: string, projects?: Project[],
    active?: boolean, employees?: Employee[]){
    this.id = id;
    this.name = name;
    this.type = type;
    this.address = address;
    this.phone = phone;
    this.description = description;
    this.companyUrl = companyUrl;
    this.projects = projects;
    this.active = active;
    this.employees = employees;
  }

}
