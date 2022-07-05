import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Transakcija } from '../model/transakcije';
import { TransakcijaService } from './transakcija.service';

@Component({
  selector: 'app-transakcija',
  templateUrl: './transakcija.component.html',
  styleUrls: ['./transakcija.component.css']
})
export class TransakcijaComponent implements OnInit {
 
  transakcije: Transakcija[] | null = [];

  constructor(private transakcijaService: TransakcijaService, private router: Router) { }

  ngOnInit(): void {
    this.getTransakcije();
  }

  getTransakcije() {
    this.transakcijaService.getTransakcije().subscribe(res =>
      this.transakcije = res.body);
  }

  goToOnRightRoute(val: string) {
    console.log('val', val);

    this.router.navigate([val]);
  }
    delete(id: number): void {
      this.transakcijaService.delete(id).subscribe(
        () => this.getTransakcije()
      );
    }

}

