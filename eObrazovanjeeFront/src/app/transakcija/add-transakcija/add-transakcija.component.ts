import { Component, OnInit } from '@angular/core';
import { Transakcija } from 'src/app/model/transakcije';
import { TransakcijaService } from '../transakcija.service';

@Component({
  selector: 'app-add-transakcija',
  templateUrl: './add-transakcija.component.html',
  styleUrls: ['./add-transakcija.component.css']
})
export class AddTransakcijaComponent implements OnInit {
  datum = '';
  svrha = '';
  promenaStanja = '';

constructor(private transakcijaService: TransakcijaService) { }

transakcija: Transakcija = new Transakcija({
  id: 0,
  datum: new Date,
  svrha: "",
  promenaStanja: 0,
});

ngOnInit(): void {
}

onSubmit() {
  console.log('datum', this.datum);
  console.log('svrha', this.svrha);
  console.log('promenaStanja', this.promenaStanja);

  this.transakcijaService.saveTransakcija(this.transakcija)
    .subscribe(() => {
      alert("Usepsno dodata transakcija!")
    })
}

}

