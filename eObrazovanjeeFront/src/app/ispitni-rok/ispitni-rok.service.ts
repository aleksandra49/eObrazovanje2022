import { Injectable } from '@angular/core';
import { HttpResponse, HttpClient } from '@angular/common/http';
import {Observable, Subject} from 'rxjs';

import { IspitniRok } from '../model/ispitniRok.model';


@Injectable()
export class IspitniRokService {
    private rokoviUrl = 'api/ispitni_rok';

    constructor(private http: HttpClient) { }

   
    
    getRokovi(): Observable<HttpResponse<IspitniRok[]>> {
        return this.http.get<IspitniRok[]>(this.rokoviUrl, {observe: 'response'});
    }

    getRok(id: number): Observable<HttpResponse<IspitniRok>> {
        const url = `${this.rokoviUrl}/${id}`;
        return this.http.get<IspitniRok>(url, {observe: 'response'});
    }

    delete(id: number): Observable<HttpResponse<any>> {
        const url = `${this.rokoviUrl}/${id}`;
        return this.http.delete<any>(url, {observe: 'response'});
    }

    saveIspitniRok(rok: IspitniRok): Observable<HttpResponse<any>> {
        const url = `${this.rokoviUrl}`;

       /* const body = {
            naizv: 'Januarski',
            pocetakRoka: new Date,
            krajRoka: new Date,
           
        };*/

        return this.http.post<any>(url, rok , {observe: 'response'});
    }

}