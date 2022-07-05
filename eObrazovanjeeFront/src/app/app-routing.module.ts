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
import { AddStudentComponent } from './student/add-student/add-student.component';
import { EditStudentComponent } from './student/edit-student/edit-student.component';
import { DeoIspitaComponent } from './deo-ispita/deo-ispita.component';
import { AddDeoIspitaComponent } from './deo-ispita/add-deo-ispita/add-deo-ispita.component';
import { EditDeoIspitaComponent } from './deo-ispita/edit-deo-ispita/edit-deo-ispita.component';
import { StudijskaGodinaComponent } from './studijska-godina/studijska-godina.component';
import { AddStudijskaGodinaComponent } from './studijska-godina/add-studijska-godina/add-studijska-godina.component';
import { EditStudijskaGodinaComponent } from './studijska-godina/edit-studijska-godina/edit-studijska-godina.component';
import { FinansijskaKartica } from './model/finansijskaKartica';
import { AddFinansijskaKarticaComponent } from './finansijska-kartica/add-finansijska-kartica/add-finansijska-kartica.component';
import { TransakcijaComponent } from './transakcija/transakcija.component';
import { AddTransakcijaComponent } from './transakcija/add-transakcija/add-transakcija.component';
import { AddDokumentComponent } from './dokument/add-dokument/add-dokument.component';

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
  { path: 'addStudent', component: AddStudentComponent },
  { path: 'editstudent', component: EditStudentComponent },

  { path: 'deoIspita', component: DeoIspitaComponent },
  { path: 'addDeoIspita', component: AddDeoIspitaComponent },
  { path: 'editDeoIspita', component: EditDeoIspitaComponent },

  { path: 'studijskaGodina', component: StudijskaGodinaComponent },
  { path: 'addStudijskaGodina', component: AddStudijskaGodinaComponent },
  { path: 'editStudijskaGodina', component: EditStudijskaGodinaComponent },

  { path: 'finansijskaKartica', component: FinansijskaKartica },
  { path: 'addFinansijskaKartica', component: AddFinansijskaKarticaComponent },

  { path: 'transakcija', component: TransakcijaComponent },
  { path: 'addTransakcija', component: AddTransakcijaComponent },
  //{ path: 'editTransakcija', component: EditStudijskaGodinaComponent },

  { path: 'dokument', component: DokumentComponent },
  { path: 'addDokument', component: AddDokumentComponent },

  { path: 'addProfesor', component: AddProfesorComponent },
  

  { path: 'login', component: LoginComponent }



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
