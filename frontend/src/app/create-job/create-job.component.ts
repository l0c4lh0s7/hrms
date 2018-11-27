import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { JobService } from '../service/job.service';
import { Router } from '@angular/router';

@Component({
  selector: 'create-job',
  templateUrl: './create-job.component.html',
  styleUrls: ['./create-job.component.css']
}) 
export class CreateJobComponent implements OnInit {

  jobCreationForm: FormGroup
  constructor(formBuilder: FormBuilder, private jobService: JobService, private router: Router) { 
    this.jobCreationForm = formBuilder.group({
        position: ['',[Validators.required]],
        vacancies:  ['',[Validators.required]],  
        filled: ['',[Validators.required]],
        description:  ['',[Validators.required]],
        ctc:  ['',[Validators.required]],
        bond: ['',[Validators.required]],
        bond_years: ['',[Validators.required]],
        isActive: ['',[Validators.required]]
    })
  }

  ngOnInit() {
  }

  onSubmit(){
    let data = this.jobCreationForm.value
    this.jobService.createJob(data).subscribe(response=>{
      console.log('response: ' + response)
    })
    this.router.navigate(['/dashboard'])
  }

  get position(){
    return this.jobCreationForm.get('position')
  }

  get vacanciees(){
    return this.jobCreationForm.get('vacancies')
  }

  get filled(){
    return this.jobCreationForm.get('filled')
  }

  get description(){
    return this.jobCreationForm.get('description')
  }

  get ctc(){
    return this.jobCreationForm.get('ctc')
  }

  get bond(){
    return this.jobCreationForm.get('bond')
  }

  get bond_years(){
    return this.jobCreationForm.get('bond_years')
  }

  get isActive(){
    return this.jobCreationForm.get('isActive')
  }
}
