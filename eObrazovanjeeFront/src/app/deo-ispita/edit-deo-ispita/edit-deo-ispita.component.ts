import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DeoIspitaService } from '../deoIspita.service';

@Component({
  selector: 'app-edit-deo-ispita',
  templateUrl: './edit-deo-ispita.component.html',
  styleUrls: ['./edit-deo-ispita.component.css']
})
export class EditDeoIspitaComponent implements OnInit {
  loaded = false;
  deoIspita: any;
  id: string | null | undefined;



  constructor(private deoIspitaService: DeoIspitaService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
     this.id = this.route.snapshot.paramMap.get('id');
     this.getDeoIspita();
  }

  getDeoIspita() {
    this.deoIspitaService.getDeoIspita(Number(this.id)).subscribe(res =>
      this.deoIspita = res.body);
  }

  edit(){
    this.deoIspitaService.editDeoIspita(this.deoIspita).subscribe(
      () => window.location.reload()
    )
  }
}
