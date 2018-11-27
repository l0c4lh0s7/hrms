import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { DataService } from './data.service';
// import { map } from 'rxjs/operators'

@Injectable({
  providedIn: 'root'
})
export class ApplicantService extends DataService {

  constructor(http: HttpClient) {
    super( "http://localhost:8080/user", http)
   }

  getAppliedJobs(userId: number){
    return this.http.get(this.url + "/" + userId + '/applied' )
  }

}
