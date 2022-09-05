import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginComponent } from 'src/app/login/login.component';
import { StudentService } from '../student.service';

const userId = localStorage.getItem('ulogovanUserId');

@Component({
  selector: 'app-student-profil',
  templateUrl: './student-profil.component.html',
  styleUrls: ['./student-profil.component.css']
})



export class StudentProfilComponent implements OnInit {

  student: any;
  

  constructor(private studentService: StudentService, private router: Router) { }

  ngOnInit(): void {
  }

  getUlogovanStudent() {
    this.studentService.getUlogovanStudent(Number(localStorage.getItem('ulogovanUserId'))).subscribe(res =>
      this.student = res.body);

      console.log('Profil studenta');
  }
  
}
