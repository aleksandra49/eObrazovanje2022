import { Component, OnInit } from '@angular/core';
import { Korisnik } from 'src/app/model/korisnik.model';
import { Profesor } from 'src/app/model/profesor.model';
import { ProfesorService } from '../../profesor.service';

@Component({
  selector: 'app-add-profesor',
  templateUrl: './add-profesor.component.html',
  styleUrls: ['./add-profesor.component.css']
})
export class AddProfesorComponent implements OnInit {
    ime = '';
    prezime = '';
    password = '';
    user = '';

  constructor(private profesorService: ProfesorService) { }

  profesor: Profesor = new Profesor({
    id: 15,
    ime: "",
    prezime: "",
    email: "",
    korisnik: new Korisnik({id: 20, korisnickoIme: "", lozinka: "", uloga: "PROFESOR"})
  });

  ngOnInit(): void {
  }

  onSubmit() {
    console.log('ime', this.ime);
    console.log('prezime', this.prezime);
    console.log('password', this.password);
    console.log('user', this.user);

    this.profesorService.saveProfesor(this.profesor)
      .subscribe(() => {
        alert("Usepsno dodat profesor!")
      })
  }

}
