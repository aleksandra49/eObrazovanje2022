import { HTTP_INTERCEPTORS, HttpEvent } from '@angular/common/http';
import { ComponentFactoryResolver, Injectable } from '@angular/core';
import { HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';

// import { TokenStorageService } from '../_services/token-storage.service';
import { Observable } from 'rxjs';

const TOKEN_HEADER_KEY = 'Authorization'; 
const TOKEN_KEY = 'auth-token';      // for Spring Boot back-end

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  // constructor(private token: TokenStorageService) { }

  /* Ovaj interceptor 'presrece' svaki request ka serveru i stavlja u header ovaj token iz localStorage kako bi 
     se autorizovao na bekendu... */

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let authReq = req;
    const token = localStorage.getItem(TOKEN_KEY);
    console.log('token', token);

    // const token = 'yJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJzcHJpbmctc2VjdXJpdHktZXhhbXBsZSIsInN1YiI6Im1hcmUiLCJpYXQiOjE2NjEzNjk4MDMsImV4cCI6MTY2MTM5OTgwMywicm9sZXMiOiJQUk9GRVNPUiIsInVzZXJJZCI6MjN9.G7BkRvBBg5I8DIV5wBjtoma7BGq789LWOaAE8ZJOCuHVADhUCJ_PzDvuckZ30B8U8RsfnqCPiw3H8G5dIienOw';
    if (token != null) {
      // for Spring Boot back-end
      authReq = req.clone({ headers: req.headers.set(TOKEN_HEADER_KEY, 'Bearer ' + token) });
     // authReq = req.clone({headers: req.headers.set('Host', 'localhost:8080')});
      // console.log(token);
    }
    return next.handle(authReq);
  }
}

export const authInterceptorProviders = [
  { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
];