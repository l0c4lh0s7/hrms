import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';
import { PasswordValidators } from '../commons/validators/password.validators';

@Component({
  selector: 'create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {

  createUserForm: FormGroup
  constructor(formBuilder: FormBuilder, private router: Router, private userService:  UserService) {
    this.createUserForm = formBuilder.group({
      newPassword : ['',[Validators.required]],
      confirmPassword:  ['',[Validators.required]],
      qualification:  ['',[Validators.required]],
      id: ['',[Validators.required]],
      Name: ['',[Validators.required]],
      email:  ['',[Validators.required]],
      dob:  ['',[Validators.required]],
      experience: ['',[Validators.required]],
      isAdmin: ['',[Validators.required]]
    },
    {
      validator:  PasswordValidators.passwordShouldMatch
    })
   }

  ngOnInit() {
  }

  
onSubmit(){
  console.log("New user created : ")
  this.userService.createUser(this.formatInputData(this.createUserForm.value)).subscribe()
  this.router.navigate(['/dashboard'])
}

formatInputData(data): JSON{
  let name = data['Name']
  delete data['Name']
  data['name'] = name
  let pass = data['newPassword']
  delete data['newPassword']
  delete data['confirmPassword']
  data['credential'] = {
    'password': pass 
  }
  return data
}


reset(){
  console.log('values reset')
}

get newPassword(){
  return this.createUserForm.get('newPassword')
}

get confirmPassword(){
  return this.createUserForm.get('confirmPassword')
}

get qualification(){
  return this.createUserForm.get('qualification')
}

get Name(){
  return this.confirmPassword.get('Name')
}

get email(){
  return this.confirmPassword.get('email')
}

get dob(){
  return this.createUserForm.get('dob')
}

get experience(){
  return this.createUserForm.get("experience")
}

get isAdmin(){
  return this.createUserForm.get('isAdmin')
}

}
