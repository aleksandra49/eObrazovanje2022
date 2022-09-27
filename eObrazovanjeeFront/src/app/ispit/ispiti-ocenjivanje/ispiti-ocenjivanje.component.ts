import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { IspitiZaOcenjivanje } from 'src/app/model/ispitZaOcenjivanje';
import { IspitService } from '../ispit.service';

@Component({
  selector: 'app-ispiti-ocenjivanje',
  templateUrl: './ispiti-ocenjivanje.component.html',
  styleUrls: ['./ispiti-ocenjivanje.component.css']
})
export class IspitiOcenjivanjeComponent implements OnInit {
  
  ispitiZaOcenjivanje: IspitiZaOcenjivanje[] | null = [];
  id: string | null | undefined;
  idProfesora: any;

   studentIme = '';
   studentPrezime = '';
   polozenIspitId= '';
   nazivPredmeta= '';
   datumIspita= '';


  constructor(
    private ispitService: IspitService,
    private router: Router, 
    private route: ActivatedRoute) { }

  ispitZaOcenjivanje: IspitiZaOcenjivanje = new IspitiZaOcenjivanje({
   
    studentIme : "",
    studentPrezime : "",
    polozenIspitId: 0,
    nazivPredmeta: "",
    datumIspita: "",
    broj_bodova: 0,
  });



  ngOnInit(): void {
    this.getIspitiZaOcenjivanje();
    this.id = this.route.snapshot.paramMap.get('id');
  }

  getIspitiZaOcenjivanje() {
    this.idProfesora = localStorage.getItem('profesorID');
    this.ispitService.getIspitiZaOcenjivanje(Number(this.idProfesora)).subscribe(res =>
      this.ispitiZaOcenjivanje = res.body);
  }

  dodajOcenu(polozenIspitId: number,broj_bodova: number ): void {
    this.ispitService.dodajOcenu(polozenIspitId,broj_bodova).subscribe(
      () => this.getIspitiZaOcenjivanje()
    );
    console.log("PO ID JE" + polozenIspitId + "UNESEN BROJ BODODVA JE" + broj_bodova)
  }

}
