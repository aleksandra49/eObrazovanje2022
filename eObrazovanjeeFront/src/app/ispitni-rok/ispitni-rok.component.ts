import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IspitniRok } from '../model/ispitniRok.model';
import { IspitniRokService } from './ispitni-rok.service';

@Component({
  selector: 'app-ispitni-rok',
  templateUrl: './ispitni-rok.component.html',
  styleUrls: ['./ispitni-rok.component.css']
})
export class IspitniRokComponent implements OnInit {

  ispitniRokovi: IspitniRok[] | null = [];

  constructor(private ispitniRokService: IspitniRokService, private router: Router) { }

  ngOnInit(): void {
    this.getIspitniRokovi();
  }

  getIspitniRokovi(){
    this.ispitniRokService.getRokovi().subscribe(res =>
      this.ispitniRokovi = res.body);
  }

  goToOnRightRoute(val: string) {
    console.log('val', val);

    this.router.navigate([val]);
  }
  

    delete(id: number): void {
      this.ispitniRokService.delete(id).subscribe(
        () => this.getIspitniRokovi()
      );
    }

}
