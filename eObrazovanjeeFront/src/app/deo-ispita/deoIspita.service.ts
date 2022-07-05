import { HttpClient, HttpResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { DeoIspita } from "../model/deoIspita.model";

@Injectable()
export class DeoIspitaService {
    private deoloviIspitaUrl = 'api/deoIspita';

    constructor(private http: HttpClient) { }

   
    
    getDeloviIspita(): Observable<HttpResponse<DeoIspita[]>> {
        const url = `${this.deoloviIspitaUrl}/all`;
        return this.http.get<DeoIspita[]>(url, {observe: 'response'});
    }
    getDeoIspita(id: number): Observable<HttpResponse<DeoIspita>> {
        const url = `${this.deoloviIspitaUrl}/${id}`;
        return this.http.get<DeoIspita>(url, {observe: 'response'});
    }


    delete(id: number): Observable<HttpResponse<any>> {
        const url = `${this.deoloviIspitaUrl}/${id}`;
        return this.http.delete<any>(url, {observe: 'response'});
    }

    saveDeoIspita(deoIspita: DeoIspita): Observable<HttpResponse<any>> {
        const url = `${this.deoloviIspitaUrl}`;

      /*  const body = {
            naziv: 'Kolokvijum',
            brojOsvojenihBodova: '12',
            minBodova: '5',
            polozio: false
        };*/

        return this.http.post<any>(url, deoIspita , {observe: 'response'});
    }
}