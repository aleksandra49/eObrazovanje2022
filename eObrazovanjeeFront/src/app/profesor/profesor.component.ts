import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Profesor } from '../model/profesor.model';
import { ProfesorService } from './profesor.service';

@Component({
  selector: 'app-profesor',
  templateUrl: './profesor.component.html',
  styleUrls: ['./profesor.component.css']
})
export class ProfesorComponent implements OnInit {
 
  profesori: Profesor[] | null = [];

  constructor(private profesorService: ProfesorService, private router: Router) { }

  ngOnInit(): void {
    this.getProfesori();
  }

  getProfesori() {
    this.profesorService.getProfesori().subscribe(res =>
      this.profesori = res.body);
  }
}