## Skill Distillery Final Project

### Business Management Toolkit

#### Steve Merwin - Developer
#### Travis Roberts - Developer, DBA, Scrum Master
#### JP Sypniewski - Developer, Repo Owner

#### Routes

PLACEHOLDERS

| Return Type | Route                 | Functionality                  |
|-------------|-----------------------|--------------------------------|
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
