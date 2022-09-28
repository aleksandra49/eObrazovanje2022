import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PohadjanjePredmetaService } from '../pohadjanje-predmeta.service';

@Component({
  selector: 'app-edit-pohadanje-predmeta',
  templateUrl: './edit-pohadanje-predmeta.component.html',
  styleUrls: ['./edit-pohadanje-predmeta.component.css']
})
export class EditPohadanjePredmetaComponent implements OnInit {

  loaded = false;
  pohadjanjePredmeta: any;
  id: string | null | undefined;



  constructor(private pohadjanjePredmetaService: PohadjanjePredmetaService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
     this.id = this.route.snapshot.paramMap.get('id');

  }


  


}

