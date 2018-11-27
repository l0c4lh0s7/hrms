import { Component } from '@angular/core';
import { LoginService } from '../service/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent  {

  loggedIn : any
  isAdmin : boolean
  constructor(loginService: LoginService, private router: Router) {
    this.loggedIn = loginService.loggedIn()
    this.isAdmin = loginService.loggedInAsAdmin()
  }

  onLogout(){
    localStorage.removeItem('token')
    window.location.href = ""
    this.router.navigate([''])
  }

}
