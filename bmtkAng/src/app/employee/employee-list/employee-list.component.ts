import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { Router } from '@angular/router';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css'],
  providers: [EmployeeService]
})
export class EmployeeListComponent implements OnInit {
  employeeList: Employee[];
  employee: Employee = new Employee();
    constructor(private router: Router,
      private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.getAllEmployees();
  }

  getAllEmployees(){
    this.employeeService.getAllEmployees().subscribe(
      employee => {
        this.employee = employee;
      },
      err => {console.log(err);
      }
    );
  }

  createEmployee(): void{
    //this.user.username = "test";
    var newEmployee: Employee = Object.assign({}, this.employee);
    //newUser.username = document.getElementById("username").nodeValue;
    this.employeeService.createEmployee(newEmployee).subscribe(

      (error: any) => console.log(error)
      );
  }

}
