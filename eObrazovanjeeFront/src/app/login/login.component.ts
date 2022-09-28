import { identifierName } from '@angular/compiler';
import { Component, Injectable, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ProfesorService } from '../profesor/profesor.service';
import { StudentService } from '../student/student.service';
import { LoginService } from './login.service';

const TOKEN_KEY = 'auth-token';
const USER = 'ulogovanUser';
const USER_ID = 'ulogovanUserID';
const ULOGA = 'uloga';
const STUDENT_ID = 'studentID';
const PROFESOR_ID = 'profesorID';
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
    private studentService: StudentService,
    private profesorService: ProfesorService
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
 
        if(data.body.korisnikDTO.uloga == "STUDENT"){
          localStorage.setItem(STUDENT_ID, data.body.korisnikDTO.student.id )
        }else if(data.body.korisnikDTO.uloga == "PROFESOR"){
          localStorage.setItem(PROFESOR_ID, data.body.korisnikDTO.profesor.id )
        }


        console.log('KORISNIK', data.body.korisnikDTO);
        console.log('ID KORISNIK', data.body.korisnikDTO.id);
        

        if(data.body.korisnikDTO.uloga == "STUDENT"){
        this.studentService.sendUloga.next({
          uloga: data.body.korisnikDTO.uloga,
          id: data.body.korisnikDTO.student.id
        });
   
      }

      if(data.body.korisnikDTO.uloga == "PROFESOR"){
        this.studentService.sendUloga.next({
          uloga: data.body.korisnikDTO.uloga,
          id: data.body.korisnikDTO.profesor.id
        });
   
      }



        this.router.navigate(['profesori']);// profesori
      }, (error) => {
        this.router.navigate(['login']);
        alert("Niste uneli dobre kredencijale!");
        this.reloadPage();
      })
  }
  reloadPage(): void {
    window.location.reload();
  }

  login(form: NgForm): void {};



}
