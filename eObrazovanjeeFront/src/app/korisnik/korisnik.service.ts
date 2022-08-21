import { Injectable } from '@angular/core';
import { HttpResponse, HttpClient } from '@angular/common/http';
import {Observable, Subject} from 'rxjs';

import { Korisnik } from '../model/korisnik.model';


@Injectable()
export class KorisnikService {
    //ovo je putanja iz naseg backend-a
    private korisniciUrl = 'api/korisnik';

    constructor(private http: HttpClient) { }

    getKorisnici(): Observable<HttpResponse<Korisnik[]>> {
        return this.http.get<Korisnik[]>(this.korisniciUrl, {observe: 'response'});
    }

    getKorisnik(id: number): Observable<HttpResponse<Korisnik>> {
        const url = `${this.korisniciUrl}/${id}`;
        return this.http.get<Korisnik>(url, {observe: 'response'});
    }

    delete(id: number): Observable<HttpResponse<any>> {
        const url = `${this.korisniciUrl}/${id}`;
        return this.http.delete<any>(url, {observe: 'response'});
    }

    saveKorisnik(korisnik: Korisnik): Observable<HttpResponse<any>> {
        const url = `${this.korisniciUrl}`;

        return this.http.post<any>(url, korisnik , {observe: 'response'});
    }

    editKorisnik(korisnik: Korisnik): Observable<HttpResponse<any>>{
      const url = `${this.korisniciUrl}`;

      return this.http.put<any>(url, korisnik , {observe: 'response'});
  }

}
