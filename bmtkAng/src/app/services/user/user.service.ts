import { Injectable } from '@angular/core';
import { User } from "../../models/user";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  [x: string]: any;

  private baseUrl = 'http://localhost:8085/api/';

  constructor(private http: HttpClient) { }

getAllUsers(): Observable<User[]> {
  return this.http.get(this.baseUrl+'user')
  .pipe(
  catchError(this.handleError)
  );
}

getUsersByUsernamePassword(): Observable<User[]> {
  return this.http.get(this.baseUrl+'userByUsernamePassword')
  .pipe(
  catchError(this.handleError)
  );
}

serializeArray = function (form) {

	// Setup our serialized data
	var serialized = [];

	// Loop through each field in the form
	for (var i = 0; i < form.elements.length; i++) {

		var field = form.elements[i];

		// Don't serialize fields without a name, submits, buttons, file and reset inputs, and disabled fields
		if (!field.name || field.disabled || field.type === 'file' || field.type === 'reset' || field.type === 'submit' || field.type === 'button') continue;

		// If a multi-select, get all selections
		if (field.type === 'select-multiple') {
			for (var n = 0; n < field.options.length; n++) {
				if (!field.options[n].selected) continue;
				serialized.push({
					name: field.name,
					value: field.options[n].value
				});
			}
		}

		// Convert field data to a query string
		else if ((field.type !== 'checkbox' && field.type !== 'radio') || field.checked) {
			serialized.push({
				name: field.name,
				value: field.value
			});
		}
	}
	return serialized;

};

createUser(user: User): void {

 /*  return this.http.post<User>(this.baseUrl+'createUser', user, {headers: new HttpHeaders({
    'Content-Type': 'application/json', 'Access-Control-Allow-Methods': 'POST',
    'Access-Control-Allow-Headers': 'Content-Type, Authorization'
  })
  })
  .pipe(catchError(this.handleError));*/

  var form = document.getElementById("newUser");
  var formArr = this.serializeArray(form);
  var ul = document.getElementById("showNewUser");
  ul.innerHTML = "";

  for (var i = 0; i < formArr.length; i++) {
    var userInput = formArr[i];
    var li = document.createElement('li');
    li.appendChild(document.createTextNode(userInput.name + ": "+ userInput.value));
    ul.appendChild(li);
}
}

}
