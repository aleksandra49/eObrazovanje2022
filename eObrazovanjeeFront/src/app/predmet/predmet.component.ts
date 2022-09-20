import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Predmet } from '../model/predmet';
import { PredmetService } from './predmet.service';

@Component({
  selector: 'app-predmet',
  templateUrl: './predmet.component.html',
  styleUrls: ['./predmet.component.css']
})
export class PredmetComponent implements OnInit {

  predmeti: Predmet[] | null = [];

  constructor(
    private predmetService: PredmetService, 
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getPredmeti();

  }

  getPredmeti() {
    this.predmetService.getPredmeti().subscribe(res =>{
      console.log('res', res);this.predmeti = res.body});
  }

  goToOnRightRoute(val: string) {
    console.log('val', val);

    this.router.navigate([val]);
  }


}
