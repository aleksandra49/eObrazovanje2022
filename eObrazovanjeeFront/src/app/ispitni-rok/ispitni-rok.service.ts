import { Injectable } from '@angular/core';
import { HttpResponse, HttpClient } from '@angular/common/http';
import {Observable, Subject} from 'rxjs';

import { IspitniRok } from '../model/ispitniRok.model';


@Injectable()
export class IspitniRokService {
    private rokoviUrl = 'api/korisnici';

    constructor(private http: HttpClient) { }

   
    
    getRokovi(): Observable<HttpResponse<IspitniRok[]>> {
        return this.http.get<IspitniRok[]>(this.rokoviUrl, {observe: 'response'});
    }

    getRok(id: number): Observable<HttpResponse<IspitniRok>> {
        const url = `${this.rokoviUrl}/${id}`;
        return this.http.get<IspitniRok>(url, {observe: 'response'});
    }

}