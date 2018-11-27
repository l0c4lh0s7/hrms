import { Injectable } from '@angular/core';
import { HttpClient } from '../../../node_modules/@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ValidationService {
  valid
  constructor(private http: HttpClient) { }

  findByEmail(url: string,email: string):boolean{
    this.http.get<boolean>(url + "?email=" + email)
      .subscribe(response =>{
        this.valid = response
         return response;
      })
      return this.valid
    //   console.log('after subscribe ' + this.valid)
    // return this.valid
  }
}
