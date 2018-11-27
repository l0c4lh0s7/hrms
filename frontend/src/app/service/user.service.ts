import { Injectable } from '@angular/core';
import { DataService } from './data.service';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService extends DataService{
  url = "http://localhost:8080/user"
  constructor(http: HttpClient) { 
    super("http://localhost:8080/user",http)
  }

    createUser(resource){
      return this.http.post(this.url + '/register', resource)
    }

}
