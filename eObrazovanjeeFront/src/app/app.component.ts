import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'eObrazovanjeeFront';

  constructor (private router: Router) {

  }

  goToOnRightRoute(val: string) {
    console.log('val', val);

    this.router.navigate([val]);
  }
}
