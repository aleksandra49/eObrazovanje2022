import { Component, OnInit } from '@angular/core';
import { PolaganjeIspita } from 'src/app/model/polaganjeIspita.model';
import { PolaganjeService } from '../polaganje-ispita.service';

@Component({
  selector: 'app-add-polaganje-ispita',
  templateUrl: './add-polaganje-ispita.component.html',
  styleUrls: ['./add-polaganje-ispita.component.css']
})
export class AddPolaganjeIspitaComponent implements OnInit {

  

constructor(private polaganjeIspitaService: PolaganjeService) { }

// polaganje: PolaganjeIspita = new PolaganjeIspita({

  
// });

ngOnInit(): void {
}

/*onSubmit() {
  // console.log('ime', this.naziv);
  // console.log('prezime', this.datumVreme);
  // console.log('password', this.brojBodova);

  this.polaganjeIspitaService.savePolaganje(this.polaganje)
    .subscribe(() => {
      alert("Usepsno dodato polaganje!")
    })
}*/


}
