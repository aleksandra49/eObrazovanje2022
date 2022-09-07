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
  idKorisnika: any;

  constructor (
    private router: Router, 
    private studentService: StudentService) {

  }

  ngOnInit(): void {
    const token = localStorage.getItem('auth-token');

    this.uloga = localStorage.getItem('uloga');
    this.idKorisnika = localStorage.getItem('ulogovanUserID');

    console.log('uloga', this.uloga);

    this.studentService.sendUloga.subscribe((data: any) => {
      console.log('sendUloga', data);
      const { uloga, id } = data;
      this.uloga = uloga;
      this.idKorisnika = id;
    })
// Ovde je greska, ternarni operator ako ima token da otvori profesore ako nema token login i onda ne mozes otvoriti profil profesora
    token ? this.router.navigate(['dokument']) : this.router.navigate(['login']);

    
    
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
