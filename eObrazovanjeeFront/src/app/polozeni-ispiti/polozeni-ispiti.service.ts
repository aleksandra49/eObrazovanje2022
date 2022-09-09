import { Injectable } from '@angular/core';
import { HttpResponse, HttpClient } from '@angular/common/http';
import {Observable, Subject} from 'rxjs';
import { PolozenPredmet } from '../model/polozenPredmet.model';


@Injectable()

export class PolozenIspitService {


    private polozenPredmetUrl = 'api/polaganje_ispita';

    constructor(private http: HttpClient) { }

    getPolozeniPredmeti(id: number): Observable<HttpResponse<PolozenPredmet>> {
        const url = `${this.polozenPredmetUrl+ "/polozeniIspitiZaStudenta"}/${id}`;
        return this.http.get<PolozenPredmet>(url, {observe: 'response'});
    }

    getNepolozeniPredmeti(id: number): Observable<HttpResponse<PolozenPredmet>> {
        const url = `${this.polozenPredmetUrl+ "/NepolozeniIspitiZaStudenta"}/${id}`;
        return this.http.get<PolozenPredmet>(url, {observe: 'response'});
    }

}