import { Component, OnInit } from '@angular/core';
import { StudijskaGodina } from 'src/app/model/studijskaGodina.model';
import { StudijskaGodinaService } from '../studijska-godina.service';

@Component({
  selector: 'app-add-studijska-godina',
  templateUrl: './add-studijska-godina.component.html',
  styleUrls: ['./add-studijska-godina.component.css']
})
export class AddStudijskaGodinaComponent implements OnInit {
  //pocetakStudija = '';
  pocetakStudija = '';
  krajStudija = '';
  nacinFinansiranja = '';
  godinaStudija =  '';
  skolskaGodina = '';
  /*nacinFinansiranja = [
    {nacinFinansiranja: "samofinansiranje"},
    {nacinFinansiranja: "buzdet"}
  ];*/
  

constructor(private studGodinaService: StudijskaGodinaService) { }

studijskaGodina: StudijskaGodina = new StudijskaGodina({
  id: 0,
  pocetakStudija: '' ,//kako ovde za date?
  krajStudija: '' , //isto
  nacinFinansiranja : "samofinansiranje" ,
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

  const obj = {
    id: 0,
    pocetakStudija: this.studijskaGodina.pocetakStudija,
    krajStudija: this.studijskaGodina.krajStudija,
    nacinFinansiranja: this.studijskaGodina.nacinFinansiranja,
    godinaStudija: this.studijskaGodina.godinaStudija,
    skolskaGodina: this.studijskaGodina.skolskaGodina
  }

  console.log('obj', obj);

  this.studGodinaService.saveStudijskaGodina(this.studijskaGodina)
    .subscribe(() => {
      alert("Uspesno dodata studijska godina!")
    })
}

}
