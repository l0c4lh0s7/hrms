import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  userName: string
  isAdmin: boolean
  constructor(loginService: LoginService, private router: Router) {
    let decoded = loginService.decodedToken()
    let isToken = !!decoded
    if( isToken ){
      this.userName = decoded.name
      this.isAdmin = decoded.admin
    }
    else{
      this.userName = null
    }
  }

  ngOnInit() {
    if( this.isAdmin ){
      this.router.navigate(['dashboard'])
    }
  }

}
