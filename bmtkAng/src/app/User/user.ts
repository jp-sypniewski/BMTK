export class User{
  id: number;
	username: string;
	password: string;
  active: boolean;

  constructor(id?: number, username?: string, password?: string, active?: boolean){
    this.id = id;
    this.username = username;
    this.password = password;
    this.active = active;
  }
}
