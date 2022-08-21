import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { IspitniRokService } from '../ispitni-rok.service';

@Component({
  selector: 'app-edit-ispitni-rok',
  templateUrl: './edit-ispitni-rok.component.html',
  styleUrls: ['./edit-ispitni-rok.component.css']
})
export class EditIspitniRokComponent implements OnInit {
  loaded = false;
  ispitniRok: any;
  id: string | null | undefined;



  constructor(private ispitniRokService: IspitniRokService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
     this.id = this.route.snapshot.paramMap.get('id');
     this.getIspitniRok();
  }

  getIspitniRok() {
    this.ispitniRokService.getRok(Number(this.id)).subscribe(res =>
      this.ispitniRok = res.body);
  }

  edit(){
    this.ispitniRokService.editIspitniRok(this.ispitniRok).subscribe(
      () => window.location.reload()
    )
  }




}
