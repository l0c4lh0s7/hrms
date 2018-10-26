import { Injectable } from '@angular/core';
import { Http } from '@angular/http'
// import { map } from 'rxjs/operators'

@Injectable({
  providedIn: 'root'
})
export class ApplicantService {

  private url = "http://localhost:8080/applicant/list"
  constructor(private http: Http) {  }

  list(){
    return this.http.get(this.url)

  }

}
