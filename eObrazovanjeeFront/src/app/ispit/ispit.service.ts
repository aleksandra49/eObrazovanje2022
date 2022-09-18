import { Injectable } from '@angular/core';
import { HttpResponse, HttpClient, HttpParams } from '@angular/common/http';
import {Observable, Subject} from 'rxjs';

import { Ispit } from '../model/ispit.model';
import { IspitIspitniRok } from '../model/ispitIspitniRok';
import { PrijavljeniIspiti } from '../model/prijavljeniIspiti';
import { IspitiZaOcenjivanje } from '../model/ispitZaOcenjivanje';


@Injectable()
export class IspitService {

    private ispitiUrl = 'api/ispit';

    constructor(private http: HttpClient) { }


    getIspitiZaOcenjivanje():Observable<HttpResponse<IspitiZaOcenjivanje[]>>  {
        const url = `${this.ispitiUrl+ "/ispitiZaOcenjivanje"}`;
        return this.http.get<IspitiZaOcenjivanje[]>(url, {observe: 'response'});
    }

    getPrijavljeniIspiti(studentId:number): Observable<HttpResponse<PrijavljeniIspiti[]>>  {
        const url = `${this.ispitiUrl+ "/prijavljeniIspiti"}`;
        const params = new HttpParams().append("idStudenta", studentId);

        return this.http.get<PrijavljeniIspiti[]>(url, {observe: 'response', params});
      }

    odjavaIspita(prijavljenIspitId: number): Observable<HttpResponse<any>> {
        const url = `${this.ispitiUrl+ "/odjavaIspita"}`;
        const params = new HttpParams().append("prijavljenIspitId", prijavljenIspitId);
        return this.http.delete<any>(url, {observe: 'response', params});
    }

    getIspiti(): Observable<HttpResponse<any[]>> {
        return this.http.get<any[]>(this.ispitiUrl, {observe: 'response'});
    }

    prijaviIspit(ispitId: number, studentId:number): Observable<HttpResponse<any>> {
        const url = `${this.ispitiUrl+ "/prijavaIspita"}`;
        return this.http.post(`api/ispit/prijavaIspita?ispitId=${ispitId}&studentId=${studentId}`, {}) as any
    }

    dodajOcenu(polozenIspitId: number,broj_bodova: number): Observable<HttpResponse<any>> {
        const url = `${this.ispitiUrl+ "/ocenjivanjeIspita"}`;
        return this.http.post(`api/ispit/ocenjivanjeIspita?polozenIspitId=${polozenIspitId}&broj_bodova=${broj_bodova}`, {}) as any
    }

    getIspit(id: number): Observable<HttpResponse<Ispit>> {
        const url = `${this.ispitiUrl}/${id}`;
        return this.http.get<Ispit>(url, {observe: 'response'});
    }

    getIspitIspitniRok(id: number): Observable<HttpResponse<IspitIspitniRok[]>> {
        const url = `${this.ispitiUrl+ "/ispitniRok"}`;
        const params = new HttpParams().append("idIspitnogRoka", id);
        return this.http.get<IspitIspitniRok[]>(url, {observe: 'response', params});

    }

    delete(id: number): Observable<HttpResponse<any>> {
        const url = `${this.ispitiUrl}/${id}`;
        return this.http.delete<any>(url, {observe: 'response'});
    }



    saveIspit(ispit: Ispit): Observable<HttpResponse<any>> {
        const url = `${this.ispitiUrl}`;

        return this.http.post<any>(url, ispit , {observe: 'response'});
    }

    editIspit(ispit: Ispit): Observable<HttpResponse<any>>{
      const url = `${this.ispitiUrl}`;

      return this.http.put<any>(url, ispit , {observe: 'response'});
  }

}
