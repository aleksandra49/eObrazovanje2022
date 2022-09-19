import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FinansijskaKarticaService } from '../finansijska-kartica/finansijska-kartica.service';
import { IstorijaTransakcija } from '../model/istorijaTransakcija';
import { TransakcijaService } from '../transakcija/transakcija.service';

@Component({
  selector: 'app-istorija-transakcija',
  templateUrl: './istorija-transakcija.component.html',
  styleUrls: ['./istorija-transakcija.component.css']
})
export class IstorijaTransakcijaComponent implements OnInit {

  id: string | null | undefined;
  istorijaTransakcija: IstorijaTransakcija[] | null = [];

  constructor(
    private router: Router, 
    //private transkacijeService: TransakcijaService,
   // private finKarticaService: FinansijskaKarticaService,
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');

   // this.getIstorijaTransakcija();    
  }

 /* getIstorijaTransakcija() {
    this.finKarticaService.getIstorijaTransakcija(Number(this.id)).subscribe(res =>
      this.istorijaTransakcija = res.body);
  }*/

  /*getIstorijaTransakcija() {
    this.transkacijeService.getIstorijaTransakcija(Number(this.id)).subscribe(res =>
      this.istorijaTransakcija = res.body);
  }*/

}
