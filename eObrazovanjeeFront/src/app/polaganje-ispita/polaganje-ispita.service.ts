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

    delete(id: number): Observable<HttpResponse<any>> {
        const url = `${this.polaganjaUrl}/${id}`;
        return this.http.delete<any>(url, {observe: 'response'});
    }

    savePolaganje(polaganjeIspita: PolaganjeIspita): Observable<HttpResponse<any>> {
        const url = `${this.polaganjaUrl}`;

        return this.http.post<any>(url, polaganjeIspita , {observe: 'response'});
    }

    editProfesor(polaganjeIspita: PolaganjeIspita): Observable<HttpResponse<any>>{
      const url = `${this.polaganjaUrl}`;

      return this.http.put<any>(url, polaganjeIspita , {observe: 'response'});
  }

}
