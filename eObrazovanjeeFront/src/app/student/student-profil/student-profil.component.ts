import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginComponent } from 'src/app/login/login.component';
import { StudentService } from '../student.service';

const user = localStorage.getItem('ulogovanUserID');

@Component({
  selector: 'app-student-profil',
  templateUrl: './student-profil.component.html',
  styleUrls: ['./student-profil.component.css']
})



export class StudentProfilComponent implements OnInit {

  student: any;
  user: string | null | undefined;
  

  constructor(private studentService: StudentService, private router: Router) { }

  ngOnInit(): void {
    
  }





  getStudent() {
    this.studentService.getStudentProfil(Number(user)).subscribe(res =>
      this.student = res.body); 
  }

}
