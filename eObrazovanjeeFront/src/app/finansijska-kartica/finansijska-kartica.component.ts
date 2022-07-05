import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FinansijskaKartica } from '../model/finansijskaKartica';
import { FinansijskaKarticaService } from './finansijska-kartica.service';

@Component({
  selector: 'app-finansijska-kartica',
  templateUrl: './finansijska-kartica.component.html',
  styleUrls: ['./finansijska-kartica.component.css']
})
export class FinansijskaKarticaComponent implements OnInit {

  kartice: FinansijskaKartica[] | null = [];

  constructor(private karitcaService: FinansijskaKarticaService, private router: Router) { }

  ngOnInit(): void {
    this.getFinanKartice();
  }

  getFinanKartice() {
    this.karitcaService.getFinanKartice().subscribe(res =>
      this.kartice = res.body);
  }

  goToOnRightRoute(val: string) {
    console.log('val', val);

    this.router.navigate([val]);
  }
 

  delete(id: number): void {
    this.karitcaService.delete(id).subscribe(
      () => this.getFinanKartice()
    );
  }

}
