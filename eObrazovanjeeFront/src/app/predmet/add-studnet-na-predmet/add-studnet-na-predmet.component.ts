import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Student } from 'src/app/model/student.model';
import { StudentService } from 'src/app/student/student.service';
import { PredmetService } from '../predmet.service';

@Component({
  selector: 'app-add-studnet-na-predmet',
  templateUrl: './add-studnet-na-predmet.component.html',
  styleUrls: ['./add-studnet-na-predmet.component.css']
})
export class AddStudnetNaPredmetComponent implements OnInit {

  id: string | null | undefined;
  predmet: any;
  selectedStudent: any;
  studentId: any;
  studenti: Student[] | null = [];

  constructor(
    private predmetService: PredmetService, 
    private router: Router, 
    private route: ActivatedRoute,
    private studentService: StudentService) { }


  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.getPredmet();
    this.getStudenti();
  }

  getPredmet() {
    this.predmetService.getPredmet(Number(this.id)).subscribe(res =>
      this.predmet = res.body);
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
    console.log('lista studenata' + this.studenti);

    this.predmetService.addStudentNaPredmet(this.predmet.id, this.studentId).subscribe(
      () =>{
        alert("Usepsno dodat student!")
        }, (error) => {
         alert("Student je vec dodat na predmet!");
         this.router.navigate(['predmeti']);
       });
 
    
       /* this.profesorService.saveProfesor(this.profesor)
          .subscribe(() => {
            alert("Usepsno dodat profesor!")
          })*/
      }

}
