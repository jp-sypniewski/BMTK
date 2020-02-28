import { Project } from './../models/project';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'isCustomer'
})
export class IsCustomerPipe implements PipeTransform {

  transform(value: Project[], udId: Number): Project[] {
    let filteredProjects: Project[] = [];

    value.forEach((project) => {
      if (project.customer.userDetail.id === udId) {
        filteredProjects.push(project);
      }
    });

    return filteredProjects;
  }

}
