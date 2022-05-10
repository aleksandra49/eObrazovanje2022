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

}