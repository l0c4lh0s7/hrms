import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate{

  constructor(private loginService: LoginService,
              private router: Router) { }

  canActivate() : boolean {
    if( this.loginService.loggedInAsAdmin() )
      return true;
    else{
      this.router.navigate(['/notallowed'])
      return false;
    }
  }
}
