import { Injectable } from '@angular/core';
import { map, catchError } from 'rxjs/operators';
import { BadInputError } from '../commons/errors/bad-input';
import { throwError } from 'rxjs';
import { AppError } from '../commons/errors/app-error';
import { NotFoundError } from '../commons/errors/not-found-error';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(public url: string, public http: HttpClient) { }

  getAll(url?:string){
    let link = url? url: this.url 
    return this.http.get(link)
      .pipe(
              map((response: Response)=> response),
              catchError(this.handleError)
            )
  }

  delete(resource){
    console.log(" value : " + this.url + '/remove/' + resource)
    return this.http.delete(this.url + '/remove/' + resource).pipe(
      map((response: Response) => response) ,
      catchError(this.handleError))
  }

  update(resource){
    return this.http.put(this.url + '/' + 'update',
     resource)
    .pipe(map((response: Response) => response) ,
    catchError(this.handleError))
    // this.http.put(this.url, JSON.stringify(resource))
  }

  create(resource){
    return this.http.post(this.url, resource).pipe(
      map((response: Response) => response.json()) ,
      catchError(this.handleError))
  }


  private handleError(error: Response){
    if(error.status === 400)
      return throwError(new BadInputError(error))
    if( error.status === 404 )
      return throwError(new NotFoundError())
    else
      return throwError(new AppError(error))
  }
}
