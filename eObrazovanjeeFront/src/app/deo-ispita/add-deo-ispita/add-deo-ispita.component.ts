import { Component, OnInit } from '@angular/core';
import { DeoIspita } from 'src/app/model/deoIspita.model';
import { DeoIspitaService } from '../deoIspita.service';

@Component({
  selector: 'app-add-deo-ispita',
  templateUrl: './add-deo-ispita.component.html',
  styleUrls: ['./add-deo-ispita.component.css']
})
export class AddDeoIspitaComponent implements OnInit {

    naziv = '';
    brojOsvojenihBodova = '';
    minBodova = '';
    polozio = '';

  constructor(private deoIspitaService: DeoIspitaService) { }

  deoIspita: DeoIspita = new DeoIspita({
    id: 0,
    naziv: "",
    brojOsvojenihBodova: 0,
    minBodova: 0,
    polozio: false
  });

  ngOnInit(): void {
  }

  onSubmit() {
    console.log('naziv', this.naziv);
    console.log('brojOsvojenihBodova', this.brojOsvojenihBodova);
    console.log('minBodova', this.minBodova);
    console.log('polozio', this.polozio);

    this.deoIspitaService.saveDeoIspita(this.deoIspita)
      .subscribe(() => {
        alert("Uspesno napravljen deo ispita!")
      })
    }
  }