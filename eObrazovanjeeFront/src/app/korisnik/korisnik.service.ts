import { Injectable } from '@angular/core';
import { HttpResponse, HttpClient } from '@angular/common/http';
import {Observable, Subject} from 'rxjs';

import { Korisnik } from '../model/korisnik.model';


@Injectable()
export class KorisnikService {
    private korisniciUrl = 'api/korisnici';

    constructor(private http: HttpClient) { }

   
    
    getKorisnici(): Observable<HttpResponse<Korisnik[]>> {
        return this.http.get<Korisnik[]>(this.korisniciUrl, {observe: 'response'});
    }

    getKorisnik(id: number): Observable<HttpResponse<Korisnik>> {
        const url = `${this.korisniciUrl}/${id}`;
        return this.http.get<Korisnik>(url, {observe: 'response'});
    }

}