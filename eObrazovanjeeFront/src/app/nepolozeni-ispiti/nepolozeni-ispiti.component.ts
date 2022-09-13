import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PolozenPredmet } from '../model/polozenPredmet.model';
import { PolozenIspitService } from '../polozeni-ispiti/polozeni-ispiti.service';
import { StudentService } from '../student/student.service';

@Component({
  selector: 'app-nepolozeni-ispiti',
  templateUrl: './nepolozeni-ispiti.component.html',
  styleUrls: ['./nepolozeni-ispiti.component.css']
})
export class NepolozeniIspitiComponent implements OnInit {

  uloga: any = null;
  idKorisnika: any;
  id: string | null | undefined;
  polozenPredmet: PolozenPredmet[] | null = [];
  constructor(
    private router: Router, 
    private studentService: StudentService,
    private route: ActivatedRoute,
    private polozenIspitService: PolozenIspitService
  ) { }

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

    this.getNepolozenIspit();
  }

  goToOnRightRouteParams(val: string, id: any) {
    console.log('val', val);
    this.router.navigate([val, id]);
  }

  getNepolozenIspit() {
    this.polozenIspitService.getNepolozeniPredmeti(Number(this.id)).subscribe(res =>
      this.polozenPredmet = res.body);
  }

}




