import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { RegisterService } from '../service/register.service';
import { NameValidator } from '../commons/validators/name.validator';
import { CustomEmailValidator } from '../commons/validators/email.validator';
import { Router } from '../../../node_modules/@angular/router';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {


  registrationForm: FormGroup

  constructor(private loginService: LoginService, private router: Router, formBuilder: FormBuilder, private service: RegisterService, emailValidator: CustomEmailValidator) {
    this.registrationForm = formBuilder.group({
      firstName: ['',[ Validators.required, NameValidator.cannotContainSpace]],
      lastName: ['', [Validators.required, NameValidator.cannotContainSpace]],
      qualification: ['', Validators.required],
      email:  ['',   Validators.required, emailValidator.emailTaken.bind(emailValidator)],
      dob:  ['', Validators.required],
      experience: ['', [Validators.required, Validators.min(0)]],
      password: ['', [Validators.required, NameValidator.cannotContainSpace, Validators.minLength(8), Validators.pattern("([a-zA-Z0-9_@!]*)")]]
    })
  }


  onSubmit(){
    let data = this.formatInputData(this.registrationForm.value)
    this.service.create(data).subscribe()
    this.loginService.tryLogging(data)
  }

  formatInputData(inputData: JSON): JSON{
    let password: string
    let name: string
    name = inputData["firstName"] + " " + inputData["lastName"]
    for( let key in inputData){
      if (key === "password" || key === "firstName" || key === "lastName"){
        password = inputData[key]
        delete inputData[key]
      }
    }
    inputData["credential"] = {
      "password" : password
    }
    inputData["name"] = name
    return inputData
  }

  get firstName(){
    return this.registrationForm.get('firstName')
  }

  get lastName(){
    return this.registrationForm.get('lastName')
  }

  get qualification(){
    return this.registrationForm.get('qualification')
  }

  get email(){
    return this.registrationForm.get('email')
  }

  get dob(){
    return this.registrationForm.get('dob')
  }

  get experience(){
    return this.registrationForm.get('experience')
  }

  get password(){
    return this.registrationForm.get('password')
  }
}
