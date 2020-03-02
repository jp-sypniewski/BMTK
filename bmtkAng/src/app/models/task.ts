import { Employee } from './employee';
export class Task {

  id: number;
  name: string;
  description: string;
  dueDate: Date;
  paid: boolean;
  createdAt: Date;
  updatedAt: Date;
  template: boolean;
  startDate: Date;
  completeDate: Date;
  status: string;
  type: string;
  priority: string;
  paymentDetails: string;
  price: Float64Array;
  active: Boolean;
  employees: Employee[];

  constructor(id?: number, name?: string, description?: string, dueDate?: Date,
    paid?: boolean, createdAt?: Date, updatedAt?: Date, template?: boolean,
    startDate?: Date, completeDate?: Date, status?: string, type?: string,
    priority?: string, paymentDetails?: string, price?: Float64Array,
    active?: Boolean, employees?: Employee[]){

      this.id = id;
      this.name = name;
      this.description = description;
      this.dueDate = dueDate;
      this.paid = paid;
      this.createdAt = createdAt;
      this.updatedAt = updatedAt;
      this.template = template;
      this.startDate = startDate;
      this.completeDate = completeDate;
      this.status = status;
      this.type = type;
      this.priority = priority;
      this.paymentDetails = paymentDetails;
      this.price = price;
      this.active = active;
      this.employees = employees;
  }


}
