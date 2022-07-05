import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginService: LoginService) {}

  loginRequest = {
    korisnickoIme: "",
    lozinka: ""
  }

  ngOnInit(): void {
  }

  onSubmit() {

    this.loginService.login(this.loginRequest)
      .subscribe((data : any) => {
        console.log(data)
        alert("Usepsan login!")
      })
  }

  login(form: NgForm): void {};

}
