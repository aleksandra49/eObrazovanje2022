import { Injectable } from '@angular/core';
import { HttpResponse, HttpClient } from '@angular/common/http';
import {Observable, Subject} from 'rxjs';

import { Ispit } from '../model/ispit.model';


@Injectable()
export class IspitService {
    private ispitiUrl = 'api/korisnici';

    constructor(private http: HttpClient) { }

   
    
    getIspiti(): Observable<HttpResponse<any[]>> {
        return this.http.get<any[]>(this.ispitiUrl, {observe: 'response'});
    }

    getIspit(id: number): Observable<HttpResponse<Ispit>> {
        const url = `${this.ispitiUrl}/${id}`;
        return this.http.get<Ispit>(url, {observe: 'response'});
    }

}