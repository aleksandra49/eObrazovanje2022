import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Dokument } from '../model/dokument.model';
import { Student } from '../model/student.model';
import { StudentService } from '../student/student.service';
import { DokumentService } from './dokument.service';

@Component({
  selector: 'app-student',
  templateUrl: './dokument.component.html',
  styleUrls: ['./dokument.component.css']
})
export class DokumentComponent implements OnInit {

  dokumenti: Dokument[] | null = [];
  uloga: any = null;
  idStudenta: any;
  idProfesora: any;
  //dokumenti: Dokument[] = [];

  constructor(private dokumentService: DokumentService,
     private router: Router,
     private studentService: StudentService) {
    
  }

  ngOnInit(): void {
    this.getDokumenti();

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

  getDokumenti() {
    this.dokumentService.getDokumenti().subscribe(
      res => this.dokumenti = res.body);
  }

  goToOnRightRoute(val: string) {
    console.log('val', val);

    this.router.navigate([val]);
  }

  goToOnRightRouteParams(val: string, id: any) {
    this.router.navigate([val, id]);
  }


  delete(id: number): void {
    this.dokumentService.delete(id).subscribe(
      () => this.getDokumenti()
    );
  }
 

}