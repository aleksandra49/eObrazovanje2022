import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { IspitService } from '../ispit/ispit.service';
import { IstorijaPolaganja } from '../model/istorijaPolaganja';

@Component({
  selector: 'app-istorija-polaganja',
  templateUrl: './istorija-polaganja.component.html',
  styleUrls: ['./istorija-polaganja.component.css']
})
export class IstorijaPolaganjaComponent implements OnInit {

  id: string | null | undefined;
  istorijaPolaganja: IstorijaPolaganja[] | null = [];

  constructor(
    private router: Router, 
    private ispitService: IspitService,
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');

    this.getIstorijaPolaganja();
  }

  getIstorijaPolaganja() {
    this.ispitService.getIstorijaPolaganja(Number(this.id)).subscribe(res =>
      this.istorijaPolaganja = res.body);
  }

}
