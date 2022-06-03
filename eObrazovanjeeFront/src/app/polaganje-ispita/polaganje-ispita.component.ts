import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PolaganjeIspita } from '../model/polaganjeIspita.model';
import { PolaganjeService } from './polaganje-ispita.service';

@Component({
  selector: 'app-polaganje-ispita',
  templateUrl: './polaganje-ispita.component.html',
  styleUrls: ['./polaganje-ispita.component.css']
})
export class PolaganjeIspitaComponent implements OnInit {

  polaganja: PolaganjeIspita[] | null = [];

  constructor(private polaganjeService: PolaganjeService, private router: Router) { }

  ngOnInit(): void {
    this.getPolaganja();
  }

  getPolaganja() {
    this.polaganjeService.getPolaganja().subscribe(res =>
      this.polaganja = res.body);
  }

  goToOnRightRoute(val: string) {
    console.log('val', val);

    this.router.navigate([val]);
  }

}
