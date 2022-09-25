import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Profesor } from '../model/profesor.model';
import { StudentService } from '../student/student.service';
import { ProfesorService } from './profesor.service';

@Component({
  selector: 'app-profesor',
  templateUrl: './profesor.component.html',
  styleUrls: ['./profesor.component.css']
})
export class ProfesorComponent implements OnInit {
  uloga: any = null;
  idStudenta: any;
  idProfesora: any;
  profesori: Profesor[] | null = [];

  constructor(
    private profesorService: ProfesorService, 
    private router: Router,
    private studentService: StudentService) { }

  ngOnInit(): void {
    this.getProfesori();

    this.uloga = localStorage.getItem('uloga');
    this.idStudenta = localStorage.getItem('studentID');
    this.idProfesora = localStorage.getItem('profesorID');

    console.log('uloga', this.uloga);
  if(this.uloga =="STUDENT"){
      this.studentService.sendUloga.subscribe((data: any) => {
        console.log('sendUloga', data);
        const { uloga, id } = data;
        this.uloga = uloga;
        this.idStudenta = id;
      })

    }

    if(this.uloga =="PROFESOR"){
      this.studentService.sendUloga.subscribe((data: any) => {
        console.log('sendUloga', data);
        const { uloga, id } = data;
        this.uloga = uloga;
        this.idProfesora = id;
      })

    }
    if(this.uloga =="ADMIN"){
      this.studentService.sendUloga.subscribe((data: any) => {
        console.log('sendUloga', data);
        const { uloga, id } = data;
        this.uloga = uloga;
        this.idProfesora = id;
      })

    }

  }

  getProfesori() {
    this.profesorService.getProfesori().subscribe(res =>
      this.profesori = res.body);
  }

  goToOnRightRouteParams(val: string, id: any) {
    this.router.navigate([val, id]);
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
