import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StudijskaGodina } from '../model/studijskaGodina.model';
import { StudijskaGodinaService } from './studijska-godina.service';

@Component({
  selector: 'app-studijska-godina',
  templateUrl: './studijska-godina.component.html',
  styleUrls: ['./studijska-godina.component.css']
})
export class StudijskaGodinaComponent implements OnInit {

  studGodine: StudijskaGodina[] | null = [];


  constructor(private studijskaGodinaService: StudijskaGodinaService, private router: Router) { }


  ngOnInit(): void {
    this.getStudijskeGodine();
  }

  getStudijskeGodine() {
    this.studijskaGodinaService.getStudijskeGodine().subscribe(res =>
      this.studGodine = res.body);
  }

  goToOnRightRoute(val: string) {
    console.log('val', val);

    this.router.navigate([val]);
  }
  

    delete(id: number): void {
      this.studijskaGodinaService.delete(id).subscribe(
        () => this.getStudijskeGodine()
      );
    }


}
