import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Ispit } from '../model/ispit.model';
import { IspitService } from './ispit.service';

@Component({
  selector: 'app-ispit',
  templateUrl: './ispit.component.html',
  styleUrls: ['./ispit.component.css']
})
export class IspitComponent implements OnInit {

  ispiti: Ispit[] | null = [];

  constructor(private ispitService: IspitService, private router: Router) { }

  ngOnInit(): void {
    this.getIspiti();
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
