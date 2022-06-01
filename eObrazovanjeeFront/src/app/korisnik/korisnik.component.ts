import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Korisnik } from '../model/korisnik.model';
import { KorisnikService } from './korisnik.service';

@Component({
  selector: 'app-korisnik',
  templateUrl: './korisnik.component.html',
  styleUrls: ['./korisnik.component.css']
})
export class KorisnikComponent implements OnInit {

  korisnici: Korisnik[] | null = [];

  constructor(private korisnikService: KorisnikService, private router: Router) { }

  ngOnInit(): void {
    this.getKorisnici();
  }

  getKorisnici(){
    this.korisnikService.getKorisnici()
      .subscribe(res => {
        console.log('res', res);
        this.korisnici = res.body;
    });
  }

}
