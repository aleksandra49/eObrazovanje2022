import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProfesorComponent } from './profesor/profesor.component';
import { KorisnikComponent } from './korisnik/korisnik.component';
import { IspitComponent } from './ispit/ispit.component';
import { IspitniRokComponent } from './ispitni-rok/ispitni-rok.component';
import { StudentComponent } from './student/student.component';

const routes: Routes = [

  { path: 'profesori', component: ProfesorComponent },
  // { path: '', component: ProfesorComponent },

  { path: 'korisnici', component: KorisnikComponent },
  // { path: '', component: KorisnikComponent }
  { path: 'ispiti', component: IspitComponent },

  { path: 'ispitniRokovi', component: IspitniRokComponent },
  { path: 'student', component: StudentComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
