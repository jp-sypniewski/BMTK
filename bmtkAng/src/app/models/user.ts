export class User {

  id: number;
  username: string;
  password: string;
  active: boolean;
  createdAt: string;
  updatedAt: string;

  constructor(id?: number, username?: string, password?: string, active?: boolean, createdAt?: string, updatedAt?: string){
    this.id = id;
    this.username = username;
    this.password = password;
    this.active = active;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

}
