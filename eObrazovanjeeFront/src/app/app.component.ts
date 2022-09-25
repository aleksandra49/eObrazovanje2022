import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StudentService } from './student/student.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'eObrazovanjeeFront';
  uloga: any = null;
  idStudenta: any;
  idProfesora: any;

  constructor (
    private router: Router, 
    private studentService: StudentService) {

  }

  ngOnInit(): void {
    const token = localStorage.getItem('auth-token');

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

    // Ovde je greska, ternarni operator ako ima token da otvori profesore ako nema token login i onda ne mozes otvoriti profil profesora
    token ? this.router.navigate(['profesori']) : this.router.navigate(['login']);
  }

  goToOnRightRoute(val: string) {
    console.log('val', val);
    this.router.navigate([val]);
  }

  goToOnRightRouteParams(val: string, id: any) {
    console.log('val', val);
    this.router.navigate([val, id]);
  }

  logout() {
    localStorage.removeItem('auth-token');
    localStorage.removeItem('uloga');
    localStorage.removeItem('ulogovanUserID');

    this.studentService.sendUloga.next({
      uloga: null,
      id: null
    });


    this.router.navigate(['login']);
  }
}
