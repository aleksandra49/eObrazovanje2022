import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProfesorComponent } from './profesor/profesor.component';
import { KorisnikComponent } from './korisnik/korisnik.component';
import { IspitComponent } from './ispit/ispit.component';
import { IspitniRokComponent } from './ispitni-rok/ispitni-rok.component';
import { StudentComponent } from './student/student.component';
import { DokumentComponent } from './dokument/dokument.component';
import { AddProfesorComponent } from './profesor/add-profesor/add-profesor/add-profesor.component';
import { PolaganjeIspitaComponent } from './polaganje-ispita/polaganje-ispita.component';
import { LoginComponent } from './login/login.component';
import { AddIspitComponent } from './ispit/add-ispit/add-ispit.component';

const routes: Routes = [

  { path: 'profesori', component: ProfesorComponent },
  // { path: '', component: ProfesorComponent },

  { path: 'korisnici', component: KorisnikComponent },
  // { path: '', component: KorisnikComponent }
  { path: 'ispiti', component: IspitComponent },
  { path: 'addIspit', component: AddIspitComponent },

  { path: 'ispitniRokovi', component: IspitniRokComponent },
  { path: 'polaganjaIspita', component: PolaganjeIspitaComponent },
  { path: 'student', component: StudentComponent },
  { path: 'dokument', component: DokumentComponent },

  { path: 'addProfesor', component: AddProfesorComponent },
  

  { path: 'login', component: LoginComponent }



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
