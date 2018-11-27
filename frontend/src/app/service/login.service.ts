import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import * as JWT from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class LoginService{

  url = "http://localhost:8080/login"
  constructor(private http: HttpClient) {
  }

  tryLogging(credential){
    return this.http.post(this.url, credential, {responseType: 'text', observe: 'response'})
      .subscribe(response=>{
        console.log('logging started ')
        const token = response.headers.get('Authorization')
        localStorage.setItem('token', token)
        this.reload()
        return response
      },
    error=>{
      console.log(error)
      return error
    })
  }

  private reload(){
    window.location.href=""
  }

  loggedIn(): boolean{
    return !!this.getToken()
  }

  loggedInAsAdmin(): boolean{
    let token: Token
    try{
    token = JWT(this.getToken())
    }
    catch(InvalidTokenError){
      console.log("Token is not present")
      return false;
    }
    return token.admin
  }

  getToken(){
    return localStorage.getItem('token')
  }

  decodedToken(): Token{
    try{
    return JWT(this.getToken())
  }catch(InvalidTokenError){
    return null
  }
  }

}

export interface Token {
   admin:boolean,
   subject:string,
   name: string
}
