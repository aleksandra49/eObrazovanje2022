import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PohadjanjePredmeta } from '../model/pohadjanjePredmeta.model';
import { PohadjanjePredmetaService } from './pohadjanje-predmeta.service';

@Component({
  selector: 'app-pohadjanje-predmeta',
  templateUrl: './pohadjanje-predmeta.component.html',
  styleUrls: ['./pohadjanje-predmeta.component.css']
})
export class PohadjanjePredmetaComponent implements OnInit {

  pohadjanjaPredmeta: PohadjanjePredmeta[] | null = [];

  constructor(private pohadanjaService: PohadjanjePredmetaService, private router: Router) { }

  ngOnInit(): void {
    this.getPohadjanjaPredmeta();
  }

  getPohadjanjaPredmeta() {
    this.pohadanjaService.getPohadjanjaPredmeta().subscribe(res =>
      this.pohadjanjaPredmeta = res.body);
  }

  goToOnRightRoute(val: string) {
    console.log('val', val);

    this.router.navigate([val]);
  }
   

    delete(id: number): void {
      this.pohadanjaService.delete(id).subscribe(
        () => this.getPohadjanjaPredmeta()
      );
    }

}
