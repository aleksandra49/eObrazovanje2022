import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from '../student/student.service';
import { PolozenIspitService } from './polozeni-ispiti.service';

@Component({
  selector: 'app-polozeni-ispiti',
  templateUrl: './polozeni-ispiti.component.html',
  styleUrls: ['./polozeni-ispiti.component.css']
})
export class PolozeniIspitiComponent implements OnInit {

  uloga: any = null;
  idKorisnika: any;
  id: string | null | undefined;
  polozenPredmet: any;

  constructor(    
    private router: Router, 
    private studentService: StudentService,
    private route: ActivatedRoute,
    private polozenIspitService: PolozenIspitService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.uloga = localStorage.getItem('uloga');
    this.idKorisnika = localStorage.getItem('ulogovanUserID');

    console.log('uloga', this.uloga);

    this.studentService.sendUloga.subscribe((data: any) => {
      console.log('sendUloga', data);
      const { uloga, id } = data;
      this.uloga = uloga;
      this.idKorisnika = id;
    })

  }

  goToOnRightRouteParams(val: string, id: any) {
    console.log('val', val);
    this.router.navigate([val, id]);
  }

  getPolozenIspit() {
    this.polozenIspitService.getPolozeniPredmeti(Number(this.id)).subscribe(res =>
      this.polozenPredmet = res.body);
  }



}
