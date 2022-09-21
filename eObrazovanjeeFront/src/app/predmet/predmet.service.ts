import { HttpClient, HttpResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Predmet } from "../model/predmet";
import { PredmetInstancaPredmet } from "../model/predmetInstancaPredmet";

@Injectable()
export class PredmetService {

    constructor(private http: HttpClient) { }

    private predmetUrl = 'api/predmeti';

    getPredmeti(): Observable<HttpResponse<Predmet[]>> {
        const url = `${this.predmetUrl+"/all"}`;
        return this.http.get<Predmet[]>(url, {observe: 'response'});
    }

    savePredmet(predmet: PredmetInstancaPredmet): Observable<HttpResponse<any>> {
        const url = `${this.predmetUrl}`;
        return this.http.post<any>(url, predmet , {observe: 'response'});
    }
}