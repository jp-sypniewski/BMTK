import { UserDetail } from './userDetail';
import { Project } from './project';

export class Customer {

  id: number;
  paymentMethod: string;
  userDetail: UserDetail;
  projects: Array<Project>;

constructor(id?: number, paymentMethod?: string, userDetail?: UserDetail,
  projects?: Array<Project>){
this.id = id;
this.paymentMethod = paymentMethod;
this.userDetail = userDetail;
this.projects = projects;
  }
}
