import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DeoIspita } from '../model/deoIspita.model';
import { DeoIspitaService } from './deoIspita.service';

@Component({
  selector: 'app-deo-ispita',
  templateUrl: './deo-ispita.component.html',
  styleUrls: ['./deo-ispita.component.css']
})
export class DeoIspitaComponent implements OnInit {


  deolviIspita: DeoIspita[] | null = [];

  constructor(private deoIspitaService: DeoIspitaService, private router: Router) { }

  ngOnInit(): void {
    this.getDeloviIspita();
  }

  getDeloviIspita() {
    this.deoIspitaService.getDeloviIspita().subscribe(res =>
      this.deolviIspita = res.body);
  }

  goToOnRightRoute(val: string) {
    console.log('val', val);

    this.router.navigate([val]);
  }
    

    delete(id: number): void {
      this.deoIspitaService.delete(id).subscribe(
        () => this.getDeloviIspita()
      );
    }

}
