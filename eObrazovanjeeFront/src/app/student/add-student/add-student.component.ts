import { Component, OnInit } from '@angular/core';
import { Korisnik } from 'src/app/model/korisnik.model';
import { Student } from 'src/app/model/student.model';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit {

  ime = '';
  prezime = '';
  password = ''; //treba li mi ovo?
  indeks = '';
  email = '';
  //active = '';
  user = '';

  constructor(private studentService: StudentService) { }


  student: Student = new Student({
    id: 0,
    ime: "",
    prezime: "",
    indeks: "",
    email: "",
    active: false,
    korisnik: new Korisnik({id: 0, korisnickoIme: "", lozinka: "", uloga: "STUDENT"})
  });

  ngOnInit(): void {
  }

  onSubmit() {
    console.log('ime', this.ime);
    console.log('prezime', this.prezime);
    console.log('password', this.password);
    console.log('indeks', this.indeks);
    console.log('email', this.email);
    console.log('user', this.user);

    this.studentService.saveStudent(this.student)
      .subscribe(() => {
        alert("Uspesno je  dodat student!")
      })
  }

}
