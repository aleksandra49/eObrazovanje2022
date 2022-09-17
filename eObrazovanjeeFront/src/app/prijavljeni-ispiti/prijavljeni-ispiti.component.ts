import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IspitService } from '../ispit/ispit.service';
import { PrijavljeniIspiti } from '../model/prijavljeniIspiti';

@Component({
  selector: 'app-prijavljeni-ispiti',
  templateUrl: './prijavljeni-ispiti.component.html',
  styleUrls: ['./prijavljeni-ispiti.component.css']
})
export class PrijavljeniIspitiComponent implements OnInit {

  idStudenta: any = null;
  prijavljenIspit: PrijavljeniIspiti[] | null = [];

  constructor(
    private router: Router, 
    private ispitService: IspitService
  ) { }

  ngOnInit(): void {

    this.idStudenta = localStorage.getItem('studentID');

    this.getPrijavljeniIspiti();
  }



  getPrijavljeniIspiti() {
    this.ispitService.getPrijavljeniIspiti(Number(this.idStudenta)).subscribe(res =>
      this.prijavljenIspit = res.body);
  }

  odjavaIspita(prijavljenIspitId: number): void {
    this.ispitService.odjavaIspita(prijavljenIspitId).subscribe(
      () => this.getPrijavljeniIspiti()
    );
  }
}
