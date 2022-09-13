import { Injectable } from '@angular/core';
import { HttpResponse, HttpClient, HttpParams } from '@angular/common/http';
import {Observable, Subject} from 'rxjs';
import { PolozenPredmet } from '../model/polozenPredmet.model';


@Injectable()

export class PolozenIspitService {


    private polozenPredmetUrl = 'api/polaganje_ispita';

    constructor(private http: HttpClient) { }

    getPolozeniPredmeti(id: number): Observable<HttpResponse<PolozenPredmet[]>> {
        const url = `${this.polozenPredmetUrl+ "/polozeniIspitiZaStudenta"}`;
        const params = new HttpParams().append("idStudenta", id);
        return this.http.get<PolozenPredmet[]>(url, {observe: 'response', params});
    }

    getNepolozeniPredmeti(id: number): Observable<HttpResponse<PolozenPredmet[]>> {
        const url = `${this.polozenPredmetUrl+ "/NepolozeniIspitiZaStudenta"}`;
        const params = new HttpParams().append("idStudenta", id);
        return this.http.get<PolozenPredmet[]>(url,{observe: 'response', params});
    }

}