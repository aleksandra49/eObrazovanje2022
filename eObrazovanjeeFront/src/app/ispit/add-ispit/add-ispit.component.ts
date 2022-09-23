import { Component, OnInit } from '@angular/core';
import { Ispit } from 'src/app/model/ispit.model';
import { IspitService } from '../ispit.service';
import { ViewEncapsulation, Inject } from '@angular/core';


@Component({
  selector: 'app-add-ispit',
  templateUrl: './add-ispit.component.html',
  styleUrls: ['./add-ispit.component.css']
})
export class AddIspitComponent implements OnInit {
  naziv = '';
  datumVreme = new Date();
  brojBodova = '';
  predmeti = [
    {naziv: "predmet1", stvar: "asd"},
    {naziv: "predmet2", stvar: "asd"}
  ];


constructor(private ispitService: IspitService) { }

ispit: Ispit = new Ispit({
  id: 0,
  naziv: "",
  datumVreme: new Date(),
  brojBodova: 0

});

ngOnInit(): void {
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
