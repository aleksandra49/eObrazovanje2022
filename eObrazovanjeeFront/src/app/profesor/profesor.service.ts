import { Injectable } from '@angular/core';
import { HttpResponse, HttpClient } from '@angular/common/http';
import {Observable, Subject} from 'rxjs';

import { Profesor } from '../model/profesor.model';


@Injectable()
export class ProfesorService {
    private profesoriUrl = 'api/profesori';

    constructor(private http: HttpClient) { }

   
    
    getProfesori(): Observable<HttpResponse<Profesor[]>> {
        const url = `${this.profesoriUrl}/all`;
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

    saveProfesor(): Observable<HttpResponse<any>> {
        const url = `${this.profesoriUrl}`;

        const body = {
            ime: 'Petar', prezime: 'Medic', user: 'Pera', password: '12345'
        };

        return this.http.post<any>(url, body , {observe: 'response'});
    }
}