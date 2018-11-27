import { Component, OnInit } from '@angular/core';
import { JobService } from '../service/job.service';

@Component({
  selector: 'app-jobs',
  templateUrl: './jobs.component.html',
  styleUrls: ['./jobs.component.css']
})
export class JobsComponent implements OnInit {

  jobs : any
  constructor(private service : JobService) { }

  ngOnInit() {
    this.service.getAll().subscribe(response => {
      this.jobs = response
    })
  }

}
