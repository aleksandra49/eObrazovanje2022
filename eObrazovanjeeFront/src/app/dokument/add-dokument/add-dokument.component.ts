import { Component, OnInit } from '@angular/core';
import { Dokument } from 'src/app/model/dokument.model';
import { DokumentService } from '../dokument.service';

@Component({
  selector: 'app-add-dokument',
  templateUrl: './add-dokument.component.html',
  styleUrls: ['./add-dokument.component.css']
})
export class AddDokumentComponent implements OnInit {

    naziv = '';
    uri = '';
    

  constructor(private dokumentService: DokumentService) { }

  dokument: Dokument = new Dokument({
    id: 0,
    naziv: "",
    uri: "",
   
  });

  ngOnInit(): void {
  }

  onSubmit() {
    console.log('naziv', this.naziv);
    console.log('uri', this.uri);
   

    this.dokumentService.saveProfesor(this.dokument)
      .subscribe(() => {
        alert("Dokument je uspoesno dodat!")
      })
  }
}
