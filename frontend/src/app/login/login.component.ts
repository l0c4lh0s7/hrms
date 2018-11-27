import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  form: FormGroup
  constructor(formBuilder: FormBuilder, private service: LoginService) {
    this.form = formBuilder.group({
      email: ['',Validators.required],
      password: ['',Validators.required]
    })
  }

  get email(){
    return this.form.get('email')
  }

  get password(){
    return this.form.get('password')
  }

  Onsubmit(){
    let formattedData = this.formatLoginData(this.form.value)
    // console.log(formattedData)
    this.service.tryLogging(formattedData)
  }


  formatLoginData(inputData: JSON){
    let pass = inputData["password"]
    delete inputData["password"]
    inputData["credential"] = {
      "password": pass
    }
    return inputData
  }
}
