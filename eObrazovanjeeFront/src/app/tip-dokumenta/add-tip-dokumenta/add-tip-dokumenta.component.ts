import { Component, OnInit } from '@angular/core';
import { TipDokumenta } from 'src/app/model/tipDokumenta';
import { TipDokumentaService } from '../tip-dokumenta.service';

@Component({
  selector: 'app-add-tip-dokumenta',
  templateUrl: './add-tip-dokumenta.component.html',
  styleUrls: ['./add-tip-dokumenta.component.css']
})
export class AddTipDokumentaComponent implements OnInit {

    nazivDokumenta = '';
    

  constructor(private tipService: TipDokumentaService) { }

  tip: TipDokumenta = new TipDokumenta({
    id: 0,
    nazivDokumenta: ""
  });

  ngOnInit(): void {
  }

  onSubmit() {
    console.log('nazivDokumenta', this.nazivDokumenta);
   

    this.tipService.saveTipDokumenta(this.tip)
      .subscribe(() => {
        alert("Usepsno dodat tip dokumenta!")
      })
  }

}
