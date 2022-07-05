import { Injectable } from '@angular/core';
import { HttpResponse, HttpClient } from '@angular/common/http';
import {Observable, Subject} from 'rxjs';

import { Profesor } from '../model/profesor.model';
import { Korisnik } from '../model/korisnik.model';
import { Student } from '../model/student.model';


@Injectable()
export class ProfesorService {
    private profesoriUrl = 'api/profesori';

    constructor(private http: HttpClient) { }

   
    
    getProfesori(): Observable<HttpResponse<Profesor[]>> {
        const url = `${this.profesoriUrl}`;
        return this.http.get<Profesor[]>(url, {observe: 'response'});
    }
    getProfesor(id: number): Observable<HttpResponse<Profesor>> {
        const url = `${this.profesoriUrl}/${id}`;
        return this.http.get<Profesor>(url, {observe: 'response'});
    }

 /*   delete(id: number) {
        return this.http.delete('/api/profesor/delete/' + id);
      }
      */
    delete(id: number): Observable<HttpResponse<any>> {
        const url = `${this.profesoriUrl}/${id}`;
        return this.http.delete<any>(url, {observe: 'response'});
    }

    saveProfesor(profesor: Profesor): Observable<HttpResponse<any>> {
        const url = `${this.profesoriUrl}`;

        const body = {
            ime: 'Petar',
            email: 'Medic',
            prezime: '12345',
            korisnik: {
                id: 2,
                korisnickoIme: 'micko333',
                prezime: '123'
            }
        };

        return this.http.post<any>(url, profesor , {observe: 'response'});
    }
}