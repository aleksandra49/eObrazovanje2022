import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from 'src/app/student/student.service';
import { ProfesorService } from '../profesor.service';

@Component({
  selector: 'app-edit-profesor',
  templateUrl: './edit-profesor.component.html',
  styleUrls: ['./edit-profesor.component.css']
})
export class EditProfesorComponent implements OnInit {
  loaded = false;
  profesor: any;
  id: string | null | undefined;
  uloga: any = null;
  idStudenta: any;
  idProfesora: any;


  constructor(
    private profesorService: ProfesorService, 
    private router: Router, 
    private route: ActivatedRoute,
    private studentService: StudentService) { }

  ngOnInit(): void {
     this.id = this.route.snapshot.paramMap.get('id');
     this.getProfesor();

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

  getProfesor() {
    this.profesorService.getProfesor(Number(this.id)).subscribe(res =>
      this.profesor = res.body);
  }

  edit(){
    this.profesorService.editProfesor(this.profesor).subscribe(
      () => window.location.reload()
    )
  }

  


}
