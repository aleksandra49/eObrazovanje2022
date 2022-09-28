import { Injectable } from '@angular/core';
import { HttpResponse, HttpClient, HttpParams } from '@angular/common/http';
import {Observable, Subject} from 'rxjs';

import { Profesor } from '../model/profesor.model';
import { Korisnik } from '../model/korisnik.model';
import { Student } from '../model/student.model';
import { PohadjanjePredmeta } from '../model/pohadjanjePredmeta.model';
import { PredajePredmet } from '../model/predajePredmet';


@Injectable()
export class PohadjanjePredmetaService {
    private pohadjanjaUrl = 'api/student';

    constructor(private http: HttpClient) { }

   

    getPohadjanjaPredmet(id: number): Observable<HttpResponse<PredajePredmet[]>> {
        const url = `${this.pohadjanjaUrl+ "/pohadjanja"}`;
        const params = new HttpParams().append("idStudenta", id);
        return this.http.get<PredajePredmet[]>(url, {observe: 'response', params});
    }
   
}