import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-edit-student',
  templateUrl: './edit-student.component.html',
  styleUrls: ['./edit-student.component.css']
})
export class EditStudentComponent implements OnInit {

  loaded = false;
  student: any;
  id: string | null | undefined;
  uloga: any = null;
  idStudenta: any;
  idProfesora: any;



  constructor(private studentService: StudentService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
     this.id = this.route.snapshot.paramMap.get('id');
     this.getStudent();
     this.uloga = localStorage.getItem('uloga');
     this.idStudenta = localStorage.getItem('studentID');
     this.idProfesora = localStorage.getItem('profesorID');
 
     console.log('uloga', this.uloga);
     if(this.uloga =="STUDENT"){
         this.studentService.sendUloga.subscribe((data: any) => {
           console.log('sendUloga', data);
           const { uloga, id } = data;
           this.uloga = uloga;
           this.idStudenta = id;
         })
   
       }
   
       if(this.uloga =="PROFESOR"){
         this.studentService.sendUloga.subscribe((data: any) => {
           console.log('sendUloga', data);
           const { uloga, id } = data;
           this.uloga = uloga;
           this.idProfesora = id;
         })
   
       }
       if(this.uloga =="ADMIN"){
         this.studentService.sendUloga.subscribe((data: any) => {
           console.log('sendUloga', data);
           const { uloga, id } = data;
           this.uloga = uloga;
           this.idProfesora = id;
         })
   
       }
  }

  getStudent() {
    this.studentService.getStudent(Number(this.id)).subscribe(res =>
      this.student = res.body);
  }

  edit(){
    this.studentService.editStudent(this.student).subscribe(
      () => window.location.reload()
    )
  }

  


}

