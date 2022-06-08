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

  goToOnRightRoute(val: string) {
    console.log('val', val);

    this.router.navigate([val]);
  }
    // splice prvi element start, drugi element delete
 /*   delete(id: number) {
      this.profesorService.delete(id).subscribe(() => {
        if(this.profesori != null) {
        for (let i = 0; i < this.profesori.length; i++) {
          if (this.profesori[i].id === id) {
            this.profesori.splice(i, 1);
          }
        }
      }
      });
    }
    */

    delete(id: number): void {
      this.profesorService.delete(id).subscribe(
        () => this.getProfesori()
      );
    }

}
