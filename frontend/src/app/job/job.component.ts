import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup } from '@angular/forms';
import { JOB } from '../commons/interfaces/interfaces'

@Component({
  selector: 'app-job',
  templateUrl: './job.component.html',
  styleUrls: ['./job.component.css']
})
export class JobComponent implements OnInit {

  url
  job: JOB
  a 
  jobEditForm: FormGroup
  changesSaved: boolean
  constructor(formBuilder: FormBuilder, private route: ActivatedRoute, private http: HttpClient , private router: Router) {
    this.route.params.subscribe( params => {
      this.url = 'http://localhost:8080/job/' + params.id      
    })
    
    this.http.get(this.url).subscribe(response => {
      this.a = response
      this.job = this.a

      this.jobEditForm = formBuilder.group({
        id : [this.job.id],
        position: [this.job.position],
        vacancies:  [this.job.vacancies], 
        filled: [this.job.filled],
        description:  [this.job.description],
        ctc:  [this.job.ctc],
        bond: [this.job.bond],
        bond_years: [this.job.bond_years],
        applied_to_id: [this.job.applied_to_id],
        interviewer_id: [this.job.interviewer_id],
        isActive: [this.job.isActive]
      })

    })

    
   }

  ngOnInit() {
  }

  cancel(){
    console.log('cancel is clicked and called ')
    this.router.navigate([''])
  }

  onSubmit(){
    console.log("Save changes is clicked and called ")
    this.http.put("http://localhost:8080/job/update", this.jobEditForm.value)
      .subscribe(response => {
        console.log("backend response : " + response)
      },
      error=>{
        console.log("error  : " + error)
      })
    console.log("Made a put call to the server with these values : " + this.jobEditForm.value)

    this.changesSaved = true
    setTimeout(()=>{
      this.changesSaved = false
    }, 5000) 
  }

}
