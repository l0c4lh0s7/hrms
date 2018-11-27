import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RouterModule } from '@angular/router'
import { FormsModule, ReactiveFormsModule } from "@angular/forms";

import { AppComponent } from './app.component';
import { ApplicantService } from './service/applicant.service';
import { ApplicantComponent } from './applicant/applicant.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { DataService } from './service/data.service';
import { RegisterService } from './service/register.service';
import { CustomEmailValidator } from './commons/validators/email.validator';
import { ValidationService } from './service/validation.service';
import { LoginService } from './service/login.service';
import { AuthGuardService } from './service/auth-guard.service';
import { NotAllowedComponent } from './not-allowed/not-allowed.component';
import { JobsComponent } from './jobs/jobs.component';
import { JobService } from './service/job.service';
import { AuthAccessService } from './service/AuthAccess.service';
import { BasicAuthInterceptor } from './service/BasicAuthInterceptor';
import { NotLoggedInComponent } from './not-logged-in/not-logged-in.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { JobComponent } from './job/job.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { UserComponent } from './user/user.component';
import { CreateJobComponent } from './create-job/create-job.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { UserService } from './service/user.service';
import { DatePipe } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    ApplicantComponent,
    NavbarComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    NotAllowedComponent,
    JobsComponent,
    NotLoggedInComponent,
    DashboardComponent,
    JobComponent,
    NotfoundComponent,
    UserComponent,
    CreateJobComponent,
    CreateUserComponent
  ],
  imports: [
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    BrowserModule,
    HttpModule,
    RouterModule.forRoot([
      // AuthAccessService : means you must be logged in
      // AuthGuardService :  means you must be admin 
      {
        path: 'createUser',
        component:  CreateUserComponent,
        canActivate:  [AuthAccessService, AuthGuardService]
      },
      {
        path: 'createJob',
        component:  CreateJobComponent,
        canActivate:  [AuthAccessService, AuthGuardService]
      },
      {
        path: "user/:id",
        component:  UserComponent
      },
      {
        path: "job/:id", 
        component:  JobComponent,
        canActivate:  [AuthAccessService]
      },
      {
        path: "register",
        component:  RegisterComponent
      },
      {
        path: "dashboard",
        component:  DashboardComponent,
        canActivate:  [AuthAccessService, AuthGuardService]
      }
      ,
      {
        path: "jobs",
        component: JobsComponent,
        canActivate: [AuthAccessService]
      },
      {
        path: 'notLoggedIn',
        component: NotLoggedInComponent
      },
      {
        path:'login',
        component: LoginComponent
      },
      {
        path:'',
        component: HomeComponent
      },
      {
        path: 'home',
        component:  HomeComponent
      },
      {
        path:'applicant',
        component: ApplicantComponent,
        canActivate: [AuthAccessService, AuthGuardService]
      },
      {
        path: 'notallowed',
        component: NotAllowedComponent,
      },
      {
        path: "**",
        component:  NotfoundComponent
      }
    ])

  ],
  providers: [UserService,
              DatePipe,
              ApplicantService,
              JobService,
              LoginService,
              AuthGuardService,
              RegisterService,
              DataService,
              ValidationService,
              CustomEmailValidator,
              {provide: HTTP_INTERCEPTORS, useClass: BasicAuthInterceptor, multi: true}
            ],
  bootstrap: [AppComponent]
})
export class AppModule { }
