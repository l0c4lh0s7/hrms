import { Component, OnInit } from '@angular/core';
import { JobService } from '../service/job.service';
import { ApplicantService } from '../service/applicant.service';
import { Router } from '@angular/router';
import { USER, JOB } from '../commons/interfaces/interfaces';

@Component({
  selector: 'dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  jobs: JOB[]
  numJobs
  numUsers
  users: USER[]
  showJob:boolean
  showUser:boolean
  selectedJobId: number 
  selectedUserId: number
  userList: any 
  jobList: any
  constructor(private jobService: JobService, 
              private userService:ApplicantService,
              private router: Router
              ) {   }

  ngOnInit() {
    this.jobService.getAll().subscribe(response=>{
      this.jobs = response as any as JOB[]
      this.numJobs = this.jobs.length
    })
    this.userService.getAll().subscribe(response=>{
      this.users = response as any as USER[]
      this.numUsers = this.users.length
    })
    this.showJob = true
    this.showUser = true
  }

  showJobs(){
    this.showJob = this.toggle(this.showJob)
    this.showUser = false
  }

  showUsers(){
    this.showUser = this.toggle(this.showUser)
    this.showJob = false
  }

  listAppliedCandidate(jobId){
    console.log("list is clicked for jobId : " + jobId)
    this.selectedJobId = jobId
    this.jobService.getAppliedCandidates(jobId).subscribe(response=>{
      this.userList = response 
    })
  }

  addnewJob(){
    console.log("new job add ")
    this.router.navigate(['/createJob'])
  }
  
  editJob(jobId){
    console.log("jobId : " + jobId )
    this.router.navigate(['/job', jobId])
  }

  deleteJob(jobId){
    console.log("deleting job with id : " + jobId)
    this.jobService.delete(jobId).subscribe(()=>{
      for( let i = this.jobs.length-1; i--;){
        if ( this.jobs[i].id === jobId) this.jobs.splice(i, 1);
        }
    })
    this.router.navigate([''])
  }

  addnewUser(){
    console.log("Add a new user ")
    this.router.navigate(['/createUser'])
  }

  editUser(userId){
    console.log("userId : " + userId)
    this.router.navigate(['/user',userId])
  }

  deleteUser(userId){
    console.log('deleting user with userId : ' + userId)
    this.userService.delete(userId).subscribe(()=>{
      for( let i = this.users.length-1; i--;){
        if ( this.users[i].id === userId) this.users.splice(i, 1);
        }
    })
    this.router.navigate([''])
  }

  listAppliedJob(userId){
    this.selectedUserId = userId 
    this.userService.getAppliedJobs(userId).subscribe(response=>{
      this.jobList = response 
    })
  }

  toggle(variable){
    return !variable
  }
}
