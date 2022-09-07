import { Injectable } from "@angular/core";
import { HttpResponse, HttpClient } from '@angular/common/http';
import {Observable, Subject} from 'rxjs';


@Injectable()
export class LoginService {
    //ovo je putanja iz naseg backend-a
    private loginUrl = 'api/korisnik/login';

    constructor(private http: HttpClient) { }

    login(loginRequest: any): Observable<HttpResponse<any>> {
        const url = `${this.loginUrl}`;

        return this.http.post<any>(url, loginRequest , {observe: 'response'});
    }

    


}