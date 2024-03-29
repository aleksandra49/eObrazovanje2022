import { HttpClient, HttpResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Dokument } from "../model/dokument.model";

@Injectable()
export class DokumentService {
    private dokumentUrl = 'api/dokument';

    constructor(private http: HttpClient) { }

    getDokumenti(): Observable<HttpResponse<Dokument[]>> {
        return this.http.get<Dokument[]>(this.dokumentUrl, {observe: 'response'});
    }

   getDokument(id: number): Observable<HttpResponse<Dokument>> {
        const url = `${this.dokumentUrl}/${id}`;
        return this.http.get<Dokument>(url, {observe: 'response'});
    }

    addDokument(dokument: Dokument): Observable<HttpResponse<Dokument>> {
        return this.http.post<Dokument>(this.dokumentUrl, dokument, {observe: 'response'});
    }

    /*editDokument(dokument: Dokument): Observable<HttpResponse<Dokument>> {
        return this.http.put<Dokument>(this.dokumentUrl, dokument, {observe: 'response'});
    }*/

    deleteDokument(dokumentId: number): Observable<HttpResponse<any>> {
        const url = `${this.dokumentUrl}/${dokumentId}`;
        return this.http.delete<any>(url, {observe: 'response'});
    }

    delete(id: number): Observable<HttpResponse<any>> {
        const url = `${this.dokumentUrl}/${id}`;
        return this.http.delete<any>(url, {observe: 'response'});
    }

    saveProfesor(dokument: Dokument): Observable<HttpResponse<any>> {
        const url = `${this.dokumentUrl}`;

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

        return this.http.post<any>(url, dokument , {observe: 'response'});
    }

    editDokument(dokument: Dokument): Observable<HttpResponse<any>>{
        const url = `${this.dokumentUrl}`;

        return this.http.put<any>(url, dokument , {observe: 'response'});
    }

}