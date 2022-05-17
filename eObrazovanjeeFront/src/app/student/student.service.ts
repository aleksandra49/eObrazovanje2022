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
        return this.http.get<Student[]>(this.studentUrl, {observe: 'response'});
    }

   getStudent(id: number): Observable<HttpResponse<Student>> {
        const url = `${this.studentUrl}/${id}`;
        return this.http.get<Student>(url, {observe: 'response'});
    }

    addStudent(student: Student): Observable<HttpResponse<Student>> {
        return this.http.post<Student>(this.studentUrl, student, {observe: 'response'});
    }

    editStudent(student: Student): Observable<HttpResponse<Student>> {
        return this.http.put<Student>(this.studentUrl, student, {observe: 'response'});
    }

    deleteStudent(studentId: number): Observable<HttpResponse<any>> {
        const url = `${this.studentUrl}/${studentId}`;
        return this.http.delete<any>(url, {observe: 'response'});
    }

}