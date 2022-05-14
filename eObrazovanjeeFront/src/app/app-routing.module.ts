import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProfesorComponent } from './profesor/profesor.component';
import { KorisnikComponent } from './korisnik/korisnik.component';

const routes: Routes = [

  { path: 'profesori', component: ProfesorComponent },
  // { path: '', component: ProfesorComponent },

  { path: 'korisnici', component: KorisnikComponent },
  // { path: '', component: KorisnikComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
