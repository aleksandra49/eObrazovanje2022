import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TipDokumenta } from '../model/tipDokumenta';
import { TipDokumentaService } from './tip-dokumenta.service';

@Component({
  selector: 'app-tip-dokumenta',
  templateUrl: './tip-dokumenta.component.html',
  styleUrls: ['./tip-dokumenta.component.css']
})
export class TipDokumentaComponent implements OnInit {

  tipovi: TipDokumenta[] | null = [];

  constructor(private tipoviService: TipDokumentaService, private router: Router) { }

  ngOnInit(): void {
    this.getTipoveDok();
  }

  getTipoveDok() {
    this.tipoviService.getTipoveDok().subscribe(res =>
      this.tipovi = res.body);
  }

  goToOnRightRoute(val: string) {
    console.log('val', val);

    this.router.navigate([val]);
  }


    delete(id: number): void {
      this.tipoviService.delete(id).subscribe(
        () => this.getTipoveDok()
      );
    }

}
