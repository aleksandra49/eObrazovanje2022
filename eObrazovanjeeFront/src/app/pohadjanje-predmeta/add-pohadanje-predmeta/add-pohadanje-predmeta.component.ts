import { Component, OnInit } from '@angular/core';
import { PohadjanjePredmeta } from 'src/app/model/pohadjanjePredmeta.model';
import { PohadjanjePredmetaService } from '../pohadjanje-predmeta.service';

@Component({
  selector: 'app-add-pohadanje-predmeta',
  templateUrl: './add-pohadanje-predmeta.component.html',
  styleUrls: ['./add-pohadanje-predmeta.component.css']
})
export class AddPohadanjePredmetaComponent implements OnInit {

  pocetak = '';
  kraj = '';
  polozen = '';

constructor(private pohadjanjeService: PohadjanjePredmetaService) { }

pohadjanje: PohadjanjePredmeta = new PohadjanjePredmeta({
  id: 0,
  pocetak: new Date,
  kraj:  new Date,
  polozen: false,
});

ngOnInit(): void {
}

onSubmit() {
  console.log('pocetak', this.pocetak);
  console.log('kraj', this.kraj);
  console.log('polozen', this.polozen);

  this.pohadjanjeService.savePohadjanjaPredmeta(this.pohadjanje)
    .subscribe(() => {
      alert("Uspesno dodato pohadjanje!")
    })
}

}
