import { Pipe, PipeTransform } from '@angular/core';
import { Company } from '../models/company';

@Pipe({
  name: 'companyNameSearch'
})
export class CompanyNameSearchPipe implements PipeTransform {

  transform(value: Company[], term: string): Company[] {
    let filteredCompanies: Company[] = [];
    let termLower = term.toLowerCase();
    value.forEach((company) => {
      let nameLower = company.name.toLowerCase();
      if (nameLower.includes(termLower)) {
        filteredCompanies.push(company);
      }
    });

    return filteredCompanies;
  }

}
