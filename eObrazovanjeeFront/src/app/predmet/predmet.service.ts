import { HttpClient, HttpResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { IspitIspitniRok } from "../model/ispitIspitniRok";
import { IspitniRok } from "../model/ispitniRok.model";
import { Predmet } from "../model/predmet";
import { PredmetInstancaPredmet } from "../model/predmetInstancaPredmet";

@Injectable()
export class PredmetService {

    constructor(private http: HttpClient) { }

    private predmetUrl = 'api/predmeti';
    private ispitniRokUrl = 'api/ispitni_rok';


    addProfesorNaPredmet(predmetId: number, profesorId:number): Observable<HttpResponse<any>> {
        return this.http.post(`api/predmeti/dodavanjeProfesora?predmetId=${predmetId}&profesorId=${profesorId}`, {}) as any
    }

    getPredmeti(): Observable<HttpResponse<Predmet[]>> {
        const url = `${this.predmetUrl+"/all"}`;
        return this.http.get<Predmet[]>(url, {observe: 'response'});
    }

    getIspitneRokove(): Observable<HttpResponse<IspitniRok[]>> {
        const url = `${this.ispitniRokUrl+"/all"}`;
        return this.http.get<IspitniRok[]>(url, {observe: 'response'});
    }

    savePredmet(predmet: PredmetInstancaPredmet): Observable<HttpResponse<any>> {
        const url = `${this.predmetUrl}`;
        return this.http.post<any>(url, predmet , {observe: 'response'});
    }

    getPredmet(id: number): Observable<HttpResponse<Predmet>> {
        const url = `${this.predmetUrl}/${id}`;
        return this.http.get<Predmet>(url, {observe: 'response'});
    }
}