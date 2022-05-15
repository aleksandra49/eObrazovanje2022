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
    this.ispitService.getIspiti().subscribe(res =>
      this.ispiti = res.body);
  }

}
