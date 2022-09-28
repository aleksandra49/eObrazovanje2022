import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PohadjanjePredmeta } from '../model/pohadjanjePredmeta.model';
import { PredajePredmet } from '../model/predajePredmet';
import { ProfesorService } from '../profesor/profesor.service';
import { PohadjanjePredmetaService } from './pohadjanje-predmeta.service';

@Component({
  selector: 'app-pohadjanje-predmeta',
  templateUrl: './pohadjanje-predmeta.component.html',
  styleUrls: ['./pohadjanje-predmeta.component.css']
})
export class PohadjanjePredmetaComponent implements OnInit {

  id: string | null | undefined;
  pohadjaPredmet: PredajePredmet[] | null = [];

  constructor(
    private router: Router, 
    private pohService: PohadjanjePredmetaService,
    private route: ActivatedRoute,
    
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');

    this.getPohadjanjaPredmet()
  }


  getPohadjanjaPredmet() {
    this.pohService.getPohadjanjaPredmet(Number(this.id)).subscribe(res =>
      this.pohadjaPredmet = res.body);
  }

}
