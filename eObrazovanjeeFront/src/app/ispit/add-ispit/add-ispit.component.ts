import { Component, OnInit } from '@angular/core';
import { Ispit } from 'src/app/model/ispit.model';
import { IspitService } from '../ispit.service';


@Component({
  selector: 'app-add-ispit',
  templateUrl: './add-ispit.component.html',
  styleUrls: ['./add-ispit.component.css']
})
export class AddIspitComponent implements OnInit {
  naziv = '';
  datumVreme = '';
  brojBodova = '';
  

constructor(private ispitService: IspitService) { }

ispit: Ispit = new Ispit({
  id: 0,
  naziv: "",
  datumVreme: "",
  brojBodova: 0
  
});

ngOnInit(): void {
}

onSubmit() {
  console.log('ime', this.naziv);
  console.log('prezime', this.datumVreme);
  console.log('password', this.brojBodova);

  this.ispitService.saveIspit(this.ispit)
    .subscribe(() => {
      alert("Usepsno dodat ispit!")
    })
}


}
