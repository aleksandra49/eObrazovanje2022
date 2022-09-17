import { Component, OnInit } from '@angular/core';
import { IspitiZaOcenjivanje } from 'src/app/model/ispitZaOcenjivanje';
import { IspitService } from '../ispit.service';

@Component({
  selector: 'app-ispiti-ocenjivanje',
  templateUrl: './ispiti-ocenjivanje.component.html',
  styleUrls: ['./ispiti-ocenjivanje.component.css']
})
export class IspitiOcenjivanjeComponent implements OnInit {
  
  ispitiZaOcenjivanje: IspitiZaOcenjivanje[] | null = [];


   studentIme = '';
   studentPrezime = '';
   polozenIspitId= '';
   nazivPredmeta= '';
   datumIspita= '';


  constructor(private ispitService: IspitService) { }

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
  }

  getIspitiZaOcenjivanje() {
    this.ispitService.getIspitiZaOcenjivanje().subscribe(res =>
      this.ispitiZaOcenjivanje = res.body);
  }


}
