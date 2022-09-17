import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Dokument } from '../model/dokument.model';
import { Student } from '../model/student.model';
import { DokumentService } from './dokument.service';

@Component({
  selector: 'app-student',
  templateUrl: './dokument.component.html',
  styleUrls: ['./dokument.component.css']
})
export class DokumentComponent implements OnInit {

  dokumenti: Dokument[] | null = [];
  //dokumenti: Dokument[] = [];

  constructor(private dokumentService: DokumentService, private router: Router) {
    
  }

  ngOnInit(): void {
    this.getDokumenti();
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