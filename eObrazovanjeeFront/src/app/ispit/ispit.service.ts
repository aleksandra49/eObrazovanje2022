import { Injectable } from '@angular/core';
import { HttpResponse, HttpClient } from '@angular/common/http';
import {Observable, Subject} from 'rxjs';

import { Ispit } from '../model/ispit.model';


@Injectable()
export class IspitService {
    private ispitiUrl = 'api/ispit';

    constructor(private http: HttpClient) { }

   
    
    getIspiti(): Observable<HttpResponse<any[]>> {
        return this.http.get<any[]>(this.ispitiUrl, {observe: 'response'});
    }

    getIspit(id: number): Observable<HttpResponse<Ispit>> {
        const url = `${this.ispitiUrl}/${id}`;
        return this.http.get<Ispit>(url, {observe: 'response'});
    }

    delete(id: number): Observable<HttpResponse<any>> {
        const url = `${this.ispitiUrl}/${id}`;
        return this.http.delete<any>(url, {observe: 'response'});
    }

    saveIspit(ispit: Ispit): Observable<HttpResponse<any>> {
        const url = `${this.ispitiUrl}`;

        return this.http.post<any>(url, ispit , {observe: 'response'});
    }

}