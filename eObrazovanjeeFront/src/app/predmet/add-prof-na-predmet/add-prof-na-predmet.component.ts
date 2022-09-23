import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Korisnik } from 'src/app/model/korisnik.model';
import { Profesor } from 'src/app/model/profesor.model';
import { ProfesorService } from 'src/app/profesor/profesor.service';
import { PredmetService } from '../predmet.service';

@Component({
  selector: 'app-add-prof-na-predmet',
  templateUrl: './add-prof-na-predmet.component.html',
  styleUrls: ['./add-prof-na-predmet.component.css']
})
export class AddProfNaPredmetComponent implements OnInit {


  id: string | null | undefined;
  predmet: any;
  profesori: Profesor[] | null = [];
  constructor(
    private predmetService: PredmetService, 
    private router: Router, 
    private route: ActivatedRoute,
    private profesorService: ProfesorService) { }


  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.getPredmet();
    this.getProfesori();
  }

  getPredmet() {
    this.predmetService.getPredmet(Number(this.id)).subscribe(res =>
      this.predmet = res.body);
  }

  getProfesori() {
    this.profesorService.getProfesori().subscribe(res =>
      this.profesori = res.body);
  }

  onSubmit() {
console.log('lista profesora' + this.profesori);

   /* this.profesorService.saveProfesor(this.profesor)
      .subscribe(() => {
        alert("Usepsno dodat profesor!")
      })*/
  }

}
