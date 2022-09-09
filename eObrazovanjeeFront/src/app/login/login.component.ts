import { Component, Injectable, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { StudentService } from '../student/student.service';
import { LoginService } from './login.service';

const TOKEN_KEY = 'auth-token';
const USER = 'ulogovanUser';
const USER_ID = 'ulogovanUserID';
const ULOGA = 'uloga';
const PROFIL_ID = 'profilID';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [LoginService]
})


export class LoginComponent implements OnInit {

  constructor(
    private loginService: LoginService,
    private router: Router,
    private studentService: StudentService
  ) {}

   public loginRequest = {
    korisnickoIme: "",
    lozinka: ""
  }

  ngOnInit(): void {
    
  }

  onSubmit() {

    console.log('loginRequest', this.loginRequest);
    this.loginService.login(this.loginRequest)
      .subscribe((data : any) => {
        console.log('response', data);
        // alert("Usepsan login!")
        localStorage.setItem(TOKEN_KEY, data.body.accessToken);
        localStorage.setItem(USER, JSON.stringify(data.body.korisnikDTO))
        localStorage.setItem(USER_ID, data.body.korisnikDTO.id)
        localStorage.setItem(ULOGA, data.body.korisnikDTO.uloga);
 
        

        console.log('KORISNIK', data.body.korisnikDTO);
        console.log('ID KORISNIK', data.body.korisnikDTO.id);
        this.studentService.sendUloga.next({
          uloga: data.body.korisnikDTO.uloga,
          id: data.body.korisnikDTO.id
        });
   
        this.router.navigate(['dokument']);// profesori
      }, (error) => {
        this.router.navigate(['login']);
      })
  }

  login(form: NgForm): void {};



}
