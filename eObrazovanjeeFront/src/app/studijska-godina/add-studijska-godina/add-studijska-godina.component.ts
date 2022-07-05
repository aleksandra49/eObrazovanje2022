import { Component, OnInit } from '@angular/core';
import { StudijskaGodina } from 'src/app/model/studijskaGodina.model';
import { StudijskaGodinaService } from '../studijska-godina.service';

@Component({
  selector: 'app-add-studijska-godina',
  templateUrl: './add-studijska-godina.component.html',
  styleUrls: ['./add-studijska-godina.component.css']
})
export class AddStudijskaGodinaComponent implements OnInit {
  pocetakStudija = '';
  krajStudija = '';
  nacinFinansiranja = '';
  godinaStudija =  '';
  skolskaGodina = '';
  

constructor(private studGodinaService: StudijskaGodinaService) { }

studijskaGodina: StudijskaGodina = new StudijskaGodina({
  id: 0,
  pocetakStudija: new Date ,//kako ovde za date?
  krajStudija: new Date , //isto
  nacinFinansiranja : "SAMOFINANSIRANJE" ,
  godinaStudija: 0,
  skolskaGodina: 0,
});

ngOnInit(): void {
}

onSubmit() {
  console.log('pocetakStudija', this.pocetakStudija);
  console.log('krajStudija', this.krajStudija);
  console.log('nacinFinansiranja', this.nacinFinansiranja);
  console.log('godinaStudija', this.godinaStudija);
  console.log('skolskaGodina', this.skolskaGodina);

  this.studGodinaService.saveStudijskaGodina(this.studijskaGodina)
    .subscribe(() => {
      alert("Uspesno dodata studijska godina!")
    })
}

}
