import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'eObrazovanjeeFront';

  constructor (private router: Router) {

  }

  ngOnInit(): void {
    const token = localStorage.getItem('auth-token');

    console.log('AppComponent', token)
// Ovde je greska, ternarni operator ako ima token da otvori profesore ako nema token login i onda ne mozes otvoriti profil profesora
    token ? this.router.navigate(['profesori']) : this.router.navigate(['login']);
    
  }

  goToOnRightRoute(val: string) {
    console.log('val', val);

    this.router.navigate([val]);
  }

  logout() {
    localStorage.removeItem('auth-token');

    this.router.navigate(['login']);
  }
}
