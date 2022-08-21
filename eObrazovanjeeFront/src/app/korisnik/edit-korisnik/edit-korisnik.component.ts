import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { KorisnikService } from '../korisnik.service';

@Component({
  selector: 'app-edit-korisnik',
  templateUrl: './edit-korisnik.component.html',
  styleUrls: ['./edit-korisnik.component.css']
})
export class EditKorisnikComponent implements OnInit {

  loaded = false;
  korisnik: any;
  id: string | null | undefined;



  constructor(private korisnikService: KorisnikService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
     this.id = this.route.snapshot.paramMap.get('id');
     this.getKorisnik();
  }

  getKorisnik() {
    this.korisnikService.getKorisnik(Number(this.id)).subscribe(res =>
      this.korisnik = res.body);
  }

  edit(){
    this.korisnikService.editKorisnik(this.korisnik).subscribe(
      () => window.location.reload()
    )
  }




}
