import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from './login.service';

const TOKEN_KEY = 'auth-token';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [LoginService]
})
export class LoginComponent implements OnInit {

  constructor(private loginService: LoginService, private router: Router) {}

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

        this.router.navigate(['profesori']);
      }, (error) => {
        this.router.navigate(['login']);
      })
  }

  login(form: NgForm): void {};

}
