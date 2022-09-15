import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { IspitIspitniRok } from 'src/app/model/ispitIspitniRok';
import { IspitService } from '../ispit.service';

@Component({
  selector: 'app-prijava-ispit',
  templateUrl: './prijava-ispit.component.html',
  styleUrls: ['./prijava-ispit.component.css']
})
export class PrijavaIspitComponent implements OnInit {

  id: string | null | undefined;
  ispitIspitniRok: IspitIspitniRok[] | null = [];

  studentId: any;

  constructor(
    private router: Router, 
    private ispitService: IspitService,
    private route: ActivatedRoute,

  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');

    this.studentId = localStorage.getItem('studentID')

    this.getIspitIspitniRok();


  }


  prijaviIspit(ispitId: number, studentId:number): void {
    this.ispitService.prijaviIspit(ispitId,studentId).subscribe(
      () => this.getIspitIspitniRok()
    );
  }


  getIspitIspitniRok() {
    this.ispitService.getIspitIspitniRok(Number(this.id)).subscribe(res =>
      this.ispitIspitniRok = res.body);
  }

}
