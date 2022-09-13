import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PredajePredmet } from 'src/app/model/predajePredmet';
import { ProfesorService } from '../profesor.service';

@Component({
  selector: 'app-profesor-predaje',
  templateUrl: './profesor-predaje.component.html',
  styleUrls: ['./profesor-predaje.component.css']
})
export class ProfesorPredajeComponent implements OnInit {

  id: string | null | undefined;
  predajePredmet: PredajePredmet[] | null = [];

  constructor(
    private router: Router, 
    private profesorService: ProfesorService,
    private route: ActivatedRoute,
    
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');

    this.getPredajePredmet()
  }


  getPredajePredmet() {
    this.profesorService.getPredajePredmet(Number(this.id)).subscribe(res =>
      this.predajePredmet = res.body);
  }
}
