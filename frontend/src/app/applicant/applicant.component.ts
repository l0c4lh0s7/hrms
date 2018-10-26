import { Component, OnInit } from '@angular/core';
import { ApplicantService } from '../service/applicant.service';

@Component({
  selector: 'applicant',
  templateUrl: './applicant.component.html',
  styleUrls: ['./applicant.component.css']
})
export class ApplicantComponent implements OnInit {

  applicants: any[]
  constructor(private service: ApplicantService) { }

  ngOnInit() {
    this.service.list()
    .subscribe(applicant => {
      this.applicants = applicant.json()
    })

  }

}
