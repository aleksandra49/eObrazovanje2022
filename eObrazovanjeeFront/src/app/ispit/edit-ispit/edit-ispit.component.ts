import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { IspitService } from '../ispit.service';

@Component({
  selector: 'app-edit-ispit',
  templateUrl: './edit-ispit.component.html',
  styleUrls: ['./edit-ispit.component.css']
})


export class EditIspitComponent implements OnInit {
  loaded = false;
  ispit: any;
  id: string | null | undefined;



  constructor(private ispitService: IspitService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
     this.id = this.route.snapshot.paramMap.get('id');
     this.getIspit();
  }

  getIspit() {
    this.ispitService.getIspit(Number(this.id)).subscribe(res =>
      this.ispit = res.body);
  }

  edit(){
    this.ispitService.editIspit(this.ispit).subscribe(
      () => window.location.reload()
    )
  }
}
