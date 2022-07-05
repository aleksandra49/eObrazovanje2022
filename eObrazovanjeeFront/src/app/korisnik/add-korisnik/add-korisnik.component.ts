import { Component, OnInit } from '@angular/core';
import { Korisnik } from 'src/app/model/korisnik.model';
import { KorisnikService } from '../korisnik.service';

@Component({
  selector: 'app-add-korisnik',
  templateUrl: './add-korisnik.component.html',
  styleUrls: ['./add-korisnik.component.css']
})
export class AddIspitComponent implements OnInit {
  korisnickoIme = '';
  lozinka = '';
  uloga = '';

constructor(private korisnikService: KorisnikService) { }

korisnik: Korisnik = new Korisnik({
  id: 0,
  korisnickoIme: "",
  lozinka: "",
  uloga: ""
});

ngOnInit(): void {
}

onSubmit() {
  console.log('korisnickoIme', this.korisnickoIme);
  console.log('lozinka', this.lozinka);
  console.log('uloga', this.uloga);

  this.korisnikService.saveKorisnik(this.korisnik)
    .subscribe(() => {
      alert("Usepsno dodat ispit!")
    })
}
}
