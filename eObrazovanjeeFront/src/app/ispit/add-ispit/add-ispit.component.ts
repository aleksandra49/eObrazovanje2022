import { Component, OnInit } from '@angular/core';
import { Ispit } from 'src/app/model/ispit.model';
import { IspitService } from '../ispit.service';
import { ViewEncapsulation, Inject } from '@angular/core';
import { IspitniRok } from 'src/app/model/ispitniRok.model';
import { Predmet } from 'src/app/model/predmet';
import { IspitniRokService } from 'src/app/ispitni-rok/ispitni-rok.service';
import { PredmetService } from 'src/app/predmet/predmet.service';


@Component({
  selector: 'app-add-ispit',
  templateUrl: './add-ispit.component.html',
  styleUrls: ['./add-ispit.component.css']
})
export class AddIspitComponent implements OnInit {

  //id: string | null | undefined;
  predmeti: any;
  ispitniRokovi: IspitniRok[] | null = [];
  naziv = '';
  datumVreme = new Date();
  brojBodova = '';
  /*predmeti = [
    {naziv: "predmet1", stvar: "asd"},
    {naziv: "predmet2", stvar: "asd"}
  ];*/


constructor(private ispitService: IspitService,
  private ispitniRokService: IspitniRokService,
  private predmetService: PredmetService
  ) { }

ispit: Ispit = new Ispit({
  id: 0,
  naziv: "",
  datumVreme: new Date(),
  brojBodova: 0

});

ngOnInit(): void {
  this.getPredmeti();
  this.getIspitneRokove();
}

getPredmeti() {
  this.predmetService.getPredmeti().subscribe(res =>
    this.predmeti = res.body);
}

getIspitneRokove() {
  this.predmetService.getIspitneRokove().subscribe(res =>
    this.ispitniRokovi = res.body);
}



onSubmit() {
  console.log('naziv', this.naziv);
  console.log('datumVreme', this.datumVreme);
  console.log('brojBodova', this.brojBodova);

  this.ispitService.saveIspit(this.ispit)
    .subscribe(() => {
      alert("Usepsno dodat ispit!")
    })
}


}
