import { AbstractControl } from "@angular/forms";
import { Injectable } from "@angular/core";
import { ValidationService } from "../../service/validation.service";


@Injectable()
export class CustomEmailValidator{

  constructor(public service : ValidationService){
  console.log(service) }

  emailTaken(control: AbstractControl) : any {
      return new Promise(resolve=>{
        setTimeout(()=>{
          let valid = this.service.findByEmail("http://localhost:8080/validate/email",control.value )
          if(valid)
            resolve({'emailTaken' : true})
          else
            resolve(null)
        }, 1000)
      })
  }


}
