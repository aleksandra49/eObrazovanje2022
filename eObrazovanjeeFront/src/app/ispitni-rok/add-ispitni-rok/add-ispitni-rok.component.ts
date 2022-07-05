import { Component, OnInit } from '@angular/core';
import { IspitniRok } from 'src/app/model/ispitniRok.model';
import { IspitniRokService } from '../ispitni-rok.service';

@Component({
  selector: 'app-add-ispitni-rok',
  templateUrl: './add-ispitni-rok.component.html',
  styleUrls: ['./add-ispitni-rok.component.css']
})
export class AddIspitniRokComponent implements OnInit {

  naziv = '';
  pocetakRoka = '';
  krajRoka = '';

constructor(private rokService: IspitniRokService) { }

rok: IspitniRok = new IspitniRok({
  id: 0,
  naziv: "",
  pocetakRoka: "",
  krajRoka: "",
});

ngOnInit(): void {
}

onSubmit() {
  console.log('naziv', this.naziv);
  console.log('pocetakRoka', this.pocetakRoka);
  console.log('krajRoka', this.krajRoka);
 

  this.rokService.saveIspitniRok(this.rok)
    .subscribe(() => {
      alert("Usepsno dodat ispitni rok!")
    })
}

}
