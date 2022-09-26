import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Ispit } from '../model/ispit.model';
import { ProfesorService } from '../profesor/profesor.service';
import { StudentService } from '../student/student.service';
import { IspitService } from './ispit.service';

@Component({
  selector: 'app-ispit',
  templateUrl: './ispit.component.html',
  styleUrls: ['./ispit.component.css']
})
export class IspitComponent implements OnInit {

  uloga: any = null;
  idStudenta: any;
  idProfesora: any;
  ispiti: Ispit[] | null = [];

  constructor(private ispitService: IspitService,
     private router: Router,
     private studentService: StudentService,
     private profesorService: ProfesorService) { }

  ngOnInit(): void {
    this.getIspiti();


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

  getIspiti(){
    this.ispitService.getIspiti()
      .subscribe(res => {
        console.log('res.body', res.body);
        this.ispiti = res.body;
      });
  }

  goToOnRightRoute(val: string) {
    console.log('val', val);

    this.router.navigate([val]);
  }

  delete(id: number): void {
    this.ispitService.delete(id).subscribe(
      () => this.getIspiti()
    );
  }

}
