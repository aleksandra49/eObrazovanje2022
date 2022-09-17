import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DokumentService } from '../dokument.service';

@Component({
  selector: 'app-edit-dokument',
  templateUrl: './edit-dokument.component.html',
  styleUrls: ['./edit-dokument.component.css']
})
export class EditDokumentComponent implements OnInit {

  loaded = false;
  dokument: any;
  id: string | null | undefined;



  constructor(private dokumentService: DokumentService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
     this.id = this.route.snapshot.paramMap.get('id');
     this.getDokument();
  }

  getDokument() {
    this.dokumentService.getDokument(Number(this.id)).subscribe(res =>
      this.dokument = res.body);
  }

  edit(){
    this.dokumentService.editDokument(this.dokument).subscribe(
      () => window.location.reload()
    )
  }

}
