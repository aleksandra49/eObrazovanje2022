import { Injectable } from '@angular/core';
import { HttpResponse, HttpClient } from '@angular/common/http';
import {Observable, Subject} from 'rxjs';
import { Student } from '../model/student.model';




@Injectable()
export class StudentService {
    private studentUrl = 'api/student';

    constructor(private http: HttpClient) { }

   
   /* getAll(): Observable<Student[]> {
        const url = `${this.studentUrl}`;
        return this.http.get<Student[]>(url).pipe();
      }*/
    
    getStudenti(): Observable<HttpResponse<Student[]>> {
        return this.http.get<Student[]>(this.studentUrl+"/all", {observe: 'response'});
    }

   getStudent(id: number): Observable<HttpResponse<Student>> {
        const url = `${this.studentUrl}/${id}`;
        return this.http.get<Student>(url, {observe: 'response'});
    }

    /*addStudent(student: Student): Observable<HttpResponse<Student>> {
        return this.http.post<Student>(this.studentUrl, student, {observe: 'response'});
    }

    editStudent(student: Student): Observable<HttpResponse<Student>> {
        return this.http.put<Student>(this.studentUrl, student, {observe: 'response'});
    }*/

    delete(Id: number): Observable<HttpResponse<any>> {
        const url = `${this.studentUrl}/${Id}`;
        return this.http.delete<any>(url, {observe: 'response'});
    }


    saveStudent(student: Student): Observable<HttpResponse<any>> {
        const url = `${this.studentUrl}`;

        const body = {
            ime: 'Anja',
            email: 'anjiko@',
            prezime: 'Anjic',
            korisnik: {
                id: 3,
                korisnickoIme: 'anjica',
                prezime: 'Anjika'
            }
        };

        return this.http.post<any>(url, student , {observe: 'response'});
    }


    editStudent(student: Student): Observable<HttpResponse<any>>{
        const url = `${this.studentUrl}`;

        return this.http.put<any>(url, student , {observe: 'response'});
    }


}