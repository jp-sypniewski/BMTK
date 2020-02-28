import { Pipe, PipeTransform } from '@angular/core';
import { Company } from '../models/company';

@Pipe({
  name: 'companyNameSearch'
})
export class CompanyNameSearchPipe implements PipeTransform {

  transform(value: Company[], term: string): Company[] {
    let filteredCompanies: Company[] = [];

    value.forEach((company) => {
      if (company.name.includes(term)) {
        filteredCompanies.push(company);
      }
    });

    return filteredCompanies;
  }

}
