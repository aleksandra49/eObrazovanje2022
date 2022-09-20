import { Injectable } from '@angular/core';
import { HttpResponse, HttpClient, HttpParams } from '@angular/common/http';
import {Observable, Subject} from 'rxjs';

import { Profesor } from '../model/profesor.model';
import { Korisnik } from '../model/korisnik.model';
import { Student } from '../model/student.model';
import { FinansijskaKartica } from '../model/finansijskaKartica';
import { IstorijaTransakcija } from '../model/istorijaTransakcija';


@Injectable()
export class FinansijskaKarticaService {
    private karticaUrl = 'api/finansijskaKartica';
    private transakcijaURL = 'api/transakcija';

    constructor(private http: HttpClient) { }

   
    
    getFinanKartice(): Observable<HttpResponse<FinansijskaKartica[]>> {
        const url = `${this.karticaUrl}/all`;
        return this.http.get<FinansijskaKartica[]>(url, {observe: 'response'});
    }
    getFinanKarticu(id: number): Observable<HttpResponse<FinansijskaKartica>> {
        const url = `${this.karticaUrl}/${id}`;
        return this.http.get<FinansijskaKartica>(url, {observe: 'response'});
    }

    getIstorijaTransakcija(studentId:number):Observable<HttpResponse<IstorijaTransakcija[]>>  {
        const url = `${this.transakcijaURL+ "/istorijaTransakcija"}`;
        const params = new HttpParams().append("idStudenta", studentId);
        return this.http.get<IstorijaTransakcija[]>(url, {observe: 'response', params});
    }


    delete(id: number): Observable<HttpResponse<any>> {
        const url = `${this.karticaUrl}/${id}`;
        return this.http.delete<any>(url, {observe: 'response'});
    }

    saveFinanKarica(finansijaskKartica: FinansijskaKartica): Observable<HttpResponse<any>> {
        const url = `${this.karticaUrl}`;

        /*const body = {
            ime: 'Petar',
            email: 'Medic',
            prezime: '12345',
            korisnik: {
                id: 2,
                korisnickoIme: 'micko333',
                prezime: '123'
            }
        };*/

        return this.http.post<any>(url, finansijaskKartica , {observe: 'response'});
    }
}