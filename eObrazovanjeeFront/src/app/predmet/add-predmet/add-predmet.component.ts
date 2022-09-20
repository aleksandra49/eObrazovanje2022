import { Component, OnInit } from '@angular/core';
import { PredmetInstancaPredmet } from 'src/app/model/predmetInstancaPredmet';
import { PredmetService } from '../predmet.service';

@Component({
  selector: 'app-add-predmet',
  templateUrl: './add-predmet.component.html',
  styleUrls: ['./add-predmet.component.css']
})
export class AddPredmetComponent implements OnInit {

	naziv = '';
  espb = '';
	oznaka = '';
	pocetak = '';
  kraj = '';

  constructor(
    private predmetService: PredmetService
  ) { }

  predmet: PredmetInstancaPredmet = new PredmetInstancaPredmet({
    id: 0,
    naziv : '',
    espb : 0,
  	oznaka : '',
	  pocetak : '',
    kraj : ''
  });


  ngOnInit(): void {
  }

  onSubmit() {
    console.log('ime', this.naziv);
    console.log('prezime', this.espb);
    console.log('password', this.pocetak);
    console.log('user', this.kraj);

    this.predmetService.savePredmet(this.predmet)
      .subscribe(() => {
        alert("Usepsno dodat predmet!")
      })
  }

}
