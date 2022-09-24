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
  selectedPredmet: any;
  predmetId: any;
  ispitniRok: any;
  ispitniRokId: any;
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

onChangePredmet(event: any) {
  this.predmetId = event.id;
  console.log('predmetId', this.predmetId);
}

onChangeIspitniRok(event: any) {
  this.ispitniRokId = event.id;
  console.log('ispitniRokId', this.ispitniRokId);
}

onSubmit() {
  
  console.log('predmetId', this.predmetId);
  console.log('predmetId', this.ispitniRokId);
  console.log('ispit.naziv', this.ispit.naziv);
  console.log('datumVreme', this.datumVreme);

  const obj = {
    id: 0,
    naziv: this.ispit.naziv,
    datumVreme: this.datumVreme,
    predmetId: this.predmetId,
    ispitniRokId: this.ispitniRokId
  }

  console.log('obj', obj);

  // private Long id;
	// private Long id;
	// private String naziv;
	// private Date datumVreme;
	// private Long predmetId;
	// private Long ispitniRokId;

  this.ispitService.saveIspit(obj)
    .subscribe(() => {
      alert("Usepsno dodat ispit!")
    })
}


}
