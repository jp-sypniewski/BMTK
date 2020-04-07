## Skill Distillery Final Project

### Business Management Toolkit

#### Steve Merwin - Developer
#### Travis Roberts - Developer, DBA, Scrum Master
#### JP Sypniewski - Developer, Repo Owner

### Overview

The Business Management Toolkit (BMTK) application provides users a solution to post-it notes and random to-do's that get lost in the everyday rush.

### Description

BMTK allows users to create a company, to which customers (internal/external) provide requests for service.  These requests (projects) have sub-items (tasks), which the company owner/manager may delegate.

Within the application, users may fill multiple roles at the same time as it relates to one company.  For example, while one company may have a different owner, employee, and customer, a different company may use the application with one user as the owner, employee, and customer!

### Implementation

The project is built as an Angular front-end, with a Spring Boot RESTful API and Spring Data JPA interacting with a MySQL database.  The project is hosted on an AWS EC2 instance.

The main entities/objects in the application are the User, Company, Project, and Task.  The database includes join tables to define owner-Users, customer-Users, and employee-Users and their relationships to Company, Project, and Task objects.

Within the API, there are endpoints that are publicly accessible, including the list of Companies.  Most endpoints are not publicly accessible and require the appropriate user information to be passed for a successful request.

### Technologies Used

* Java 8
* Spring Boot/RESTful API
* Angular
* Typescript/Javascript
* VSCode
* Spring Tool Suite
* Spring Data JPA
* MySQL
* MAMP - local MySQL hosting
* HTML/CSS/Bootstrap
* Github/Git - version control
* AWS EC2
* Gradle
* Tomcat
* Trello
* Agile development

### API Routes

| Return Type | Route                 | Functionality                  |
|-------------|---------------------------------|--------------------------------|
| `Register` | `POST register` | Register user with detail |
| `Authenticate` | `GET authenticate` | Authenticate existing user |
||||
| `List<Project>`  |`GET api/companies/{companyId}/projects` | Gets all projects for a single company |
| `List<Project>`  |`GET api/projects` | Gets all projects for a single customer (with auth) |
| `List<Task>`  |`GET api/tasks` | Gets all tasks for a single employee (with auth) |
| `List<Company>`  |`GET api/myCompanies` | Gets all companies for a single owner (with auth) |
| `Company`  |`GET api/companies/{companyId}` | Gets a company by ID |
||||
| `Company`  |`POST api/companies` | Creates a company and an owner-company relationship |
| `Project`  |`POST api/companies/{companyId}/projects` | Creates a project for a single company |
| `Employee`  |`POST api/companies/{companyId}/employees` | Creates an employee for a single company |
| `Task`  |`POST api/projects/{projectId}/tasks` | Creates a task for a project |
