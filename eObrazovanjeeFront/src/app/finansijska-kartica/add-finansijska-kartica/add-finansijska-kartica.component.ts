import { Component, OnInit } from '@angular/core';
import { FinansijskaKartica } from 'src/app/model/finansijskaKartica';
import { FinansijskaKarticaService } from '../finansijska-kartica.service';

@Component({
  selector: 'app-add-finansijska-kartica',
  templateUrl: './add-finansijska-kartica.component.html',
  styleUrls: ['./add-finansijska-kartica.component.css']
})
export class AddFinansijskaKarticaComponent implements OnInit {

  personalniBroj = '';
  trenutnoStanje = '';
  racunFakulteta = '';
  

constructor(private karticaService: FinansijskaKarticaService) { }

kartica: FinansijskaKartica = new FinansijskaKartica({
  id: 0,
  personalniBroj: "",
  trenutnoStanje: 0,
  racunFakulteta: "",
});

ngOnInit(): void {
}

onSubmit() {
  console.log('personalniBroj', this.personalniBroj);
  console.log('trenutnoStanje', this.trenutnoStanje);
  console.log('racunFakulteta', this.racunFakulteta);

  this.karticaService.saveFinanKarica(this.kartica)
    .subscribe(() => {
      alert("Usepsno dodat fiann kartica!")
    })
}

}
