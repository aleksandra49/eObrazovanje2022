import { Injectable } from '@angular/core';
import { HttpResponse, HttpClient } from '@angular/common/http';
import {Observable, Subject} from 'rxjs';

import { Profesor } from '../model/profesor.model';
import { Korisnik } from '../model/korisnik.model';
import { Student } from '../model/student.model';
import { TipDokumenta } from '../model/tipDokumenta';


@Injectable()
export class TipDokumentaService {
    private tipoviUrl = 'api/tipDokumenta';

    constructor(private http: HttpClient) { }

   
    
    getTipoviDokumenta(): Observable<HttpResponse<TipDokumenta[]>> {
        const url = `${this.tipoviUrl}/all`;
        return this.http.get<TipDokumenta[]>(url, {observe: 'response'});
    }
    getTipDokumenta(id: number): Observable<HttpResponse<TipDokumenta>> {
        const url = `${this.tipoviUrl}/${id}`;
        return this.http.get<TipDokumenta>(url, {observe: 'response'});
    }


    delete(id: number): Observable<HttpResponse<any>> {
        const url = `${this.tipoviUrl}/${id}`;
        return this.http.delete<any>(url, {observe: 'response'});
    }

    saveTipDokumenta(tip: TipDokumenta): Observable<HttpResponse<any>> {
        const url = `${this.tipoviUrl}`;

       /* const body = {
            ime: 'Petar',
            email: 'Medic',
            prezime: '12345',
            korisnik: {
                id: 2,
                korisnickoIme: 'micko333',
                prezime: '123'
            }
        };*/

        return this.http.post<any>(url, tip , {observe: 'response'});
    }
}