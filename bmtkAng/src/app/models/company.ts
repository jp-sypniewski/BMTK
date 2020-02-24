import { Employee } from './employee';

export class Company {

  id: number;
  name: string;
  type: string;
  address: string;
  phone: string;
  description: string;
  companyUrl: string;
  employees: Array<Employee>;

  constructor(id?: number, name?: string, type?: string, address?: string,
    phone?: string, description?: string, companyUrl?: string, employees?: Array<Employee>){
    this.id = id;
    this.name = name;
    this.type = type;
    this.address = address;
    this.phone = phone;
    this.description = description;
    this.companyUrl = companyUrl;
    this.employees = employees;
  }

}
