import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FinansijskaKartica } from '../model/finansijskaKartica';
import { IstorijaTransakcija } from '../model/istorijaTransakcija';
import { FinansijskaKarticaService } from './finansijska-kartica.service';

@Component({
  selector: 'app-finansijska-kartica',
  templateUrl: './finansijska-kartica.component.html',
  styleUrls: ['./finansijska-kartica.component.css']
})
export class FinansijskaKarticaComponent implements OnInit {

  finansijskeKartice: FinansijskaKartica[] | null = [];
  istorijaTransakcija: IstorijaTransakcija[] | null = [];
  id: string | null | undefined;
  finansijskaKartica: any;

  constructor(
    private karitcaService: FinansijskaKarticaService, 
    private router: Router,
    private route: ActivatedRoute,) { }

  ngOnInit(): void {
    this.getFinanKartice();

    this.id = this.route.snapshot.paramMap.get('id');
    this.getFinansijskaKartica();
    this.getIstorijaTransakcija();
    console.log(this.istorijaTransakcija);
  
  }

  getFinanKartice() {
    this.karitcaService.getFinanKartice().subscribe(res =>
      this.finansijskeKartice = res.body);
  }

  getFinansijskaKartica(){
    this.karitcaService.getFinanKarticu(Number(this.id)).subscribe(res =>
      this.finansijskaKartica = res.body);
  }

    getIstorijaTransakcija() {
    this.karitcaService.getIstorijaTransakcija(Number(this.id)).subscribe(res =>
      this.istorijaTransakcija = res.body);
  }
  

  goToOnRightRoute(val: string) {
    console.log('val', val);

    this.router.navigate([val]);
  }
 

  delete(id: number): void {
    this.karitcaService.delete(id).subscribe(
      () => this.getFinanKartice()
    );
  }

}
