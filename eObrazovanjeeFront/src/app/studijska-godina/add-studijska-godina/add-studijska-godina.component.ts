import { Component, OnInit } from '@angular/core';
import { Student } from 'src/app/model/student.model';
import { StudijskaGodina } from 'src/app/model/studijskaGodina.model';
import { StudentService } from 'src/app/student/student.service';
import { StudijskaGodinaService } from '../studijska-godina.service';

@Component({
  selector: 'app-add-studijska-godina',
  templateUrl: './add-studijska-godina.component.html',
  styleUrls: ['./add-studijska-godina.component.css']
})
export class AddStudijskaGodinaComponent implements OnInit {

  nacinFinansiranja = '';
  godinaStudija =  '';
  skolskaGodina = '';
  studentId: any;
  studenti: Student[] | null = [];
  selectedStudent: any;
constructor(
  private studGodinaService: StudijskaGodinaService,
  private studentService: StudentService
  ) { }

studijskaGodina: StudijskaGodina = new StudijskaGodina({
  id: 0,
  pocetakStudija: '' ,//kako ovde za date?
  krajStudija: '' , //isto
  nacinFinansiranja : "samofinansiranje" ,
  godinaStudija: 0,
  skolskaGodina: 0,
  studentId: 0
});

ngOnInit(): void {
  this.getStudenti()
}

getStudenti() {
  this.studentService.getStudenti().subscribe(res =>
    this.studenti = res.body);
}

onChangeStudent(event: any) {
  console.dir(event.id);
  this.studentId = event.id;
}

onSubmit() {

  console.log('nacinFinansiranja', this.nacinFinansiranja);
  console.log('godinaStudija', this.godinaStudija);
  console.log('skolskaGodina', this.skolskaGodina);

  const obj = {

    nacinFinansiranja: this.studijskaGodina.nacinFinansiranja,
    godinaStudija: this.studijskaGodina.godinaStudija,
    studentId: this.studentId
  }


  console.log('obj', obj);

  this.studGodinaService.saveStudijskaGodina(obj)
    .subscribe(() => {
      alert("Uspesno dodata studijska godina!")
    })
}

}
