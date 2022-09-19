import { Injectable } from '@angular/core';
import { HttpResponse, HttpClient, HttpParams } from '@angular/common/http';
import {Observable, Subject} from 'rxjs';
import { Transakcija } from '../model/transakcije';
import { IstorijaTransakcija } from '../model/istorijaTransakcija';


@Injectable()
export class TransakcijaService {
    private transakcijeUrl = 'api/transakcije';

    constructor(private http: HttpClient) { }

   
    
    getTransakcije(): Observable<HttpResponse<Transakcija[]>> {
        const url = `${this.transakcijeUrl}/all`;
        return this.http.get<Transakcija[]>(url, {observe: 'response'});
    }
    getTransakcija(id: number): Observable<HttpResponse<Transakcija>> {
        const url = `${this.transakcijeUrl}/${id}`;
        return this.http.get<Transakcija>(url, {observe: 'response'});
    }

    /*getIstorijaTransakcija(studentId:number):Observable<HttpResponse<IstorijaTransakcija[]>>  {
        const url = `${this.transakcijeUrl+ "/istorijaTransakcija"}`;
        const params = new HttpParams().append("idStudenta", studentId);
        return this.http.get<IstorijaTransakcija[]>(url, {observe: 'response', params});
    }*/

    delete(id: number): Observable<HttpResponse<any>> {
        const url = `${this.transakcijeUrl}/${id}`;
        return this.http.delete<any>(url, {observe: 'response'});
    }

    saveTransakcija(transakcija: Transakcija): Observable<HttpResponse<any>> {
        const url = `${this.transakcijeUrl}`;
//bilo zakucano za medica

        return this.http.post<any>(url, transakcija , {observe: 'response'});
    }
}


