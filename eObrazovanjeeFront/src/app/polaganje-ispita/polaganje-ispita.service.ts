import { Injectable } from '@angular/core';
import { HttpResponse, HttpClient } from '@angular/common/http';
import {Observable, Subject} from 'rxjs';

import { PolaganjeIspita } from '../model/polaganjeIspita.model';


@Injectable()
export class PolaganjeService {
    private polaganjaUrl = 'api/polaganje_ispita';

    constructor(private http: HttpClient) { }

   
    
    getPolaganja(): Observable<HttpResponse<PolaganjeIspita[]>> {
        const url = `${this.polaganjaUrl}/all`;
        return this.http.get<PolaganjeIspita[]>(url, {observe: 'response'});
    }

    getPolaganje(id: number): Observable<HttpResponse<PolaganjeIspita>> {
        const url = `${this.polaganjaUrl}/${id}`;
        return this.http.get<PolaganjeIspita>(url, {observe: 'response'});
    }


}