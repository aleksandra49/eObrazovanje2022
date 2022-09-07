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

  studenti: Student[] | null = [];
  //studenti: Student[] = [];

  constructor(private studentService: StudentService, private router: Router) {
    
  }

  ngOnInit(): void {
    this.getStudenti();
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
      () => this.getStudenti()
    );
  }

 

}
