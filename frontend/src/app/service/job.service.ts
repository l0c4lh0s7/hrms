import { Injectable } from '@angular/core';
import { DataService } from './data.service';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class JobService extends DataService{

  constructor(http: HttpClient) {
      super("http://localhost:8080/job", http)
  }

  getAppliedCandidates(jobId: number){
    return this.http.get(this.url + "/" + jobId + '/applied' )
  }

  createJob(resource){
    return this.http.post(this.url + "/create", resource)
  }
}
