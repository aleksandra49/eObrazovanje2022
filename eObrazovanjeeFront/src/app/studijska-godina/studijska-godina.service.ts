import { HttpClient, HttpParams, HttpResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { addStudijskaGodina } from "../model/addStudijskaGodina";
import { StudijskaGodina } from "../model/studijskaGodina.model";

@Injectable()
export class StudijskaGodinaService {

    private studijskeGodineUrl = 'api/studijskaGodina';

    constructor(private http: HttpClient) { }

   
    
    getStudijskeGodine(): Observable<HttpResponse<StudijskaGodina[]>> {
        const url = `${this.studijskeGodineUrl}/all`;
        return this.http.get<StudijskaGodina[]>(url, {observe: 'response'});
    }
    getStudijskaGodina(id: number): Observable<HttpResponse<StudijskaGodina>> {
        const url = `${this.studijskeGodineUrl}/${id}`;
        return this.http.get<StudijskaGodina>(url, {observe: 'response'});
    }

    getStudijskaGodinaStudenta(studentId:number):Observable<HttpResponse<StudijskaGodina[]>>  {
        const url = `${this.studijskeGodineUrl+ "/tokStudija"}`;
        const params = new HttpParams().append("idStudenta", studentId);
        return this.http.get<StudijskaGodina[]>(url, {observe: 'response', params});
    }

    

    delete(id: number): Observable<HttpResponse<any>> {
        const url = `${this.studijskeGodineUrl}/${id}`;
        return this.http.delete<any>(url, {observe: 'response'});
    }


    saveStudijskaGodina(godina: addStudijskaGodina): Observable<HttpResponse<any>> {
        const url = `${this.studijskeGodineUrl+ "/dodajStudijskuGodinu"}`;

        return this.http.post<any>(url, godina , {observe: 'response'});
    }

    editStudijskaGodina(studijskaGodina: StudijskaGodina): Observable<HttpResponse<any>>{
        const url = `${this.studijskeGodineUrl}`;

        return this.http.put<any>(url, studijskaGodina , {observe: 'response'});
    }
  
}