import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Student } from '../model/student.model';
import { StudentService } from './student.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
 
  uloga: any = null;
  idStudenta: any;
  idProfesora: any;
  studenti: Student[] | null = [];
  showError = false;
  //studenti: Student[] = [];

  constructor(private studentService: StudentService, private router: Router) {
    
  }

  ngOnInit(): void {
    this.getStudenti();

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

  getStudenti() {
    this.studentService.getStudenti().subscribe(
      res => this.studenti = res.body);
  }

  goToOnRightRoute(val: string) {
    console.log('val', val);

    this.router.navigate([val]);
  }

  goToOnRightRouteParams(val: string, id: any) {
    this.router.navigate([val, id]);
  }

  delete(id: number): void {
    this.studentService.delete(id).subscribe(
      () =>   this.router.navigateByUrl("/student")
      
    );
    this.reloadPage();
  }

  reloadPage(): void {
    window.location.reload();
  }

 

}
