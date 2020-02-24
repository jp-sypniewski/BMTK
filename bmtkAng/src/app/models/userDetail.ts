import { User } from './user';

export class UserDetail {

  id: number;
  firstName: string;
  lastName: string;
  email: string;
  street: string;
  city: string;
  zipcode: string;
  country: string;
  phone: string;
  user: User;

  constructor(id?:number, firstName?:string, lastName?:string,
    email?: string, street?: string, city?:string, zipcode?:string,
    country?:string, phone?:string, user?:User ){

      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.street = street;
      this.city = city;
      this.zipcode = zipcode;
      this.country = country;
      this.phone = phone;
      this.user = user;
    }

}
