import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StudijskaGodinaService } from '../studijska-godina.service';

@Component({
  selector: 'app-edit-studijska-godina',
  templateUrl: './edit-studijska-godina.component.html',
  styleUrls: ['./edit-studijska-godina.component.css']
})
export class EditStudijskaGodinaComponent implements OnInit {

  loaded = false;
  studijskaGodina: any;
  id: string | null | undefined;



  constructor(private studijskaGodinaService: StudijskaGodinaService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
     this.id = this.route.snapshot.paramMap.get('id');
     this.getStudijskaGodina();
  }

  getStudijskaGodina() {
    this.studijskaGodinaService.getStudijskaGodina(Number(this.id)).subscribe(res =>
      this.studijskaGodina = res.body);
  }

  edit(){
    this.studijskaGodinaService.editStudijskaGodina(this.studijskaGodina).subscribe(
      () => window.location.reload()
    )
  }

  


}
