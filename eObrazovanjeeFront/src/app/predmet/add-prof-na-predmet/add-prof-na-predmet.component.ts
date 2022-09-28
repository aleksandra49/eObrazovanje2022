import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Korisnik } from 'src/app/model/korisnik.model';
import { Profesor } from 'src/app/model/profesor.model';
import { AddProfesorComponent } from 'src/app/profesor/add-profesor/add-profesor/add-profesor.component';
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
  selectedProfesor: any;
  profesorId: any;
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

  onChangeProfesor(event: any) {
    console.dir(event.id);
    this.profesorId = event.id;
  }

  onSubmit() {
    console.log('predmet', this.predmet);
    console.log('profesorId', this.profesorId);


      this.predmetService.addProfesorNaPredmet(this.predmet.id, this.profesorId).subscribe(
       () =>  {
       alert("Usepsno dodat profesor!")
       }, (error) => {
        alert("Profesor je vec dodat na predmet!");
        this.router.navigate(['predmeti']);
      });

      
  }
  reloadPage(): void {
    window.location.reload();
  }
}
