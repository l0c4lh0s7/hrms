import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router'

import { AppComponent } from './app.component';
import { ApplicantService } from './service/applicant.service';
import { ApplicantComponent } from './applicant/applicant.component';
import { NavbarComponent } from './navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    ApplicantComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    RouterModule.forRoot([
     
      {
        path:'applicant',
        component: ApplicantComponent
      }
    ])

  ],
  providers: [ApplicantService],
  bootstrap: [AppComponent]
})
export class AppModule { }
