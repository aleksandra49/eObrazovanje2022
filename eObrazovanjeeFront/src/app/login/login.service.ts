import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable()
export class LoginService {
    //ovo je putanja iz naseg backend-a
    private loginUrl = 'api/login';

    constructor(private http: HttpClient) { }

    

}