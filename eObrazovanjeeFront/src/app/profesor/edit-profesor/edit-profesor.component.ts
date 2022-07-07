import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProfesorService } from '../profesor.service';

@Component({
  selector: 'app-edit-profesor',
  templateUrl: './edit-profesor.component.html',
  styleUrls: ['./edit-profesor.component.css']
})
export class EditProfesorComponent implements OnInit {
  loaded = false;
  profesor: any;
  id: string | null | undefined;



  constructor(private profesorService: ProfesorService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
     this.id = this.route.snapshot.paramMap.get('id');
     this.getProfesor();
  }

  getProfesor() {
    this.profesorService.getProfesor(Number(this.id)).subscribe(res =>
      this.profesor = res.body);
  }



  


}
