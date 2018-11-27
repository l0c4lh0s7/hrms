import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from "../../../node_modules/@angular/common/http";
import { Observable } from "../../../node_modules/rxjs";
import { Injectable } from "../../../node_modules/@angular/core";

@Injectable()
export class BasicAuthInterceptor implements HttpInterceptor{

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let username="admin@admin.com"
    let password = "admin"
    request = request.clone({
      setHeaders:{
        Authorization:  'Basic ' + btoa(username + ':' + password)
      }
    })
    return next.handle(request)
  }
}
