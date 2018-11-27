import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApplicantService } from '../service/applicant.service';
import { FormGroup, FormBuilder } from '@angular/forms';
import { USER } from '../commons/interfaces/interfaces';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  url: any;
  user: USER;
  userEditForm: FormGroup;
  constructor(private datePipe: DatePipe,
    private router: Router,
    private route: ActivatedRoute, private applicantService: ApplicantService, formBuilder: FormBuilder) {
    this.route.params.subscribe(params => {
      this.url = 'http://localhost:8080/user/' + params.id
      this.applicantService.getAll(this.url).subscribe(response => {

        this.user = response as any as USER;
        let value = this.datePipe.transform(this.user.dob, 'mm-dd-yyyy')
        console.log("date : ", value)
        this.userEditForm = formBuilder.group({
          credential: [this.user.credential],
          admin: [this.user.admin],
          qualification: [this.user.qualification],
          id: [this.user.id],
          name: [this.user.name],
          email: [this.user.email],
          dob: [value],
          experience: [this.user.experience],
          applied_to_id: [this.user.applied_to_id],
          status_id: [this.user.status_id],
          isAdmin: [this.user.isAdmin]
        })
      })
    })

  }

  ngOnInit() {

  }

  onSubmit() {
    console.log("Saving changed values ")
    this.applicantService.update(this.userEditForm.value).subscribe()
    this.router.navigate([''])
    this.formatInputData(this.userEditForm.value)
  }

  formatInputData(data: JSON) {
    console.log(data)
  }

}
