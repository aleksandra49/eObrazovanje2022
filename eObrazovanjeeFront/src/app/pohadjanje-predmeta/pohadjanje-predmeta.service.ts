import { Injectable } from '@angular/core';
import { HttpResponse, HttpClient } from '@angular/common/http';
import {Observable, Subject} from 'rxjs';

import { Profesor } from '../model/profesor.model';
import { Korisnik } from '../model/korisnik.model';
import { Student } from '../model/student.model';
import { PohadjanjePredmeta } from '../model/pohadjanjePredmeta.model';


@Injectable()
export class PohadjanjePredmetaService {
    private pohadjanjaUrl = 'api/pohadjanje';

    constructor(private http: HttpClient) { }

   
    
    getPohadjanjaPredmeta(): Observable<HttpResponse<PohadjanjePredmeta[]>> {
        const url = `${this.pohadjanjaUrl}/all`;
        return this.http.get<PohadjanjePredmeta[]>(url, {observe: 'response'});
    }
    getPohadjanjePredmeta(id: number): Observable<HttpResponse<PohadjanjePredmeta>> {
        const url = `${this.pohadjanjaUrl}/${id}`;
        return this.http.get<PohadjanjePredmeta>(url, {observe: 'response'});
    }

 
    delete(id: number): Observable<HttpResponse<any>> {
        const url = `${this.pohadjanjaUrl}/${id}`;
        return this.http.delete<any>(url, {observe: 'response'});
    }

    savePohadjanjaPredmeta(pohadjanje: PohadjanjePredmeta): Observable<HttpResponse<any>> {
        const url = `${this.pohadjanjaUrl}`;

        /*const body = {
            pocetak: new Date,
            kraj: new Date,
            polozen: false,
           
        };*/

        return this.http.post<any>(url, pohadjanje , {observe: 'response'});
    }

    editPohadjanjePredmeta(pohadanje: PohadjanjePredmeta): Observable<HttpResponse<any>>{
        const url = `${this.pohadjanjaUrl}`;

        return this.http.put<any>(url, pohadanje , {observe: 'response'});
    }
}