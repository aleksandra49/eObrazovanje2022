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
import { AddPolaganjeIspitaComponent } from './polaganje-ispita/add-polaganje-ispita/add-polaganje-ispita.component';
import { PohadjanjePredmetaComponent } from './pohadjanje-predmeta/pohadjanje-predmeta.component';
import { AddPohadanjePredmetaComponent } from './pohadjanje-predmeta/add-pohadanje-predmeta/add-pohadanje-predmeta.component';
import { StudentProfilComponent } from './student/student-profil/student-profil.component';
import { EditProfesorComponent } from './profesor/edit-profesor/edit-profesor.component';
import { EditIspitComponent } from './ispit/edit-ispit/edit-ispit.component';
import { AddIspitniRokComponent } from './ispitni-rok/add-ispitni-rok/add-ispitni-rok.component';
import { EditIspitniRokComponent } from './ispitni-rok/edit-ispitni-rok/edit-ispitni-rok.component';
import { AddKorisnikComponent } from './korisnik/add-korisnik/add-korisnik.component';
import { EditKorisnikComponent } from './korisnik/edit-korisnik/edit-korisnik.component';
import { EditPohadanjePredmetaComponent } from './pohadjanje-predmeta/edit-pohadanje-predmeta/edit-pohadanje-predmeta.component';
import { PolozeniIspitiComponent } from './polozeni-ispiti/polozeni-ispiti.component';
import { NepolozeniIspitiComponent } from './nepolozeni-ispiti/nepolozeni-ispiti.component';
import { ProfesorPredajeComponent } from './profesor/profesor-predaje/profesor-predaje.component';
import { PrijavaIspitComponent } from './ispit/prijava-ispit/prijava-ispit.component';
import { PrijavljeniIspitiComponent } from './prijavljeni-ispiti/prijavljeni-ispiti.component';
import { IspitiOcenjivanjeComponent } from './ispit/ispiti-ocenjivanje/ispiti-ocenjivanje.component';
import { EditDokumentComponent } from './dokument/edit-dokument/edit-dokument.component';
import { IstorijaPolaganjaComponent } from './istorija-polaganja/istorija-polaganja.component';
import { FinansijskaKarticaComponent } from './finansijska-kartica/finansijska-kartica.component';
import { IstorijaTransakcijaComponent } from './istorija-transakcija/istorija-transakcija.component';


const routes: Routes = [

  { path: 'profesori', component: ProfesorComponent },
  // { path: '', component: ProfesorComponent },

  { path: 'korisnici', component: KorisnikComponent },
  { path: 'addKorisnici', component: AddKorisnikComponent },
  { path: 'editKorisnici', component: EditKorisnikComponent },

  { path: 'ispiti', component: IspitComponent },
  { path: 'addIspit', component: AddIspitComponent },
  { path: 'editIspit', component: EditIspitComponent },
  { path: 'prijavaIspita/:id', component: PrijavaIspitComponent },
  { path: 'listaPrijavljenihIspita', component: PrijavljeniIspitiComponent },
  { path: 'ocenjivanjeIspita', component: IspitiOcenjivanjeComponent },
  { path: 'istorijaPolaganja/:id', component: IstorijaPolaganjaComponent },


  { path: 'ispitniRokovi', component: IspitniRokComponent },
  { path: 'addIspitniRokovi', component: AddIspitniRokComponent },
  { path: 'editIspitniRokovi', component: EditIspitniRokComponent },

  { path: 'polaganjaIspita', component: PolaganjeIspitaComponent },
  { path: 'addPolaganjaIspita', component: AddPolaganjeIspitaComponent },

  { path: 'profesori/:id', component: EditProfesorComponent },
  { path: 'predmet/:id', component: ProfesorPredajeComponent },
  { path: 'polozeniIspitiZaStudenta/:id', component: PolozeniIspitiComponent },
  { path: 'NepolozeniIspitiZaStudenta/:id', component: NepolozeniIspitiComponent },

  { path: 'student', component: StudentComponent },
  { path: 'addStudent', component: AddStudentComponent },
  { path: 'editstudent', component: EditStudentComponent },
  { path: 'student/:id', component: EditStudentComponent },
  { path: 'profil', component: StudentProfilComponent },

  { path: 'deoIspita', component: DeoIspitaComponent },
  { path: 'addDeoIspita', component: AddDeoIspitaComponent },
  { path: 'editDeoIspita', component: EditDeoIspitaComponent },

  { path: 'studijskaGodina', component: StudijskaGodinaComponent },
  { path: 'addStudijskaGodina', component: AddStudijskaGodinaComponent },
  { path: 'editStudijskaGodina', component: EditStudijskaGodinaComponent },

  { path: 'finansijskaKartica/:id', component: FinansijskaKarticaComponent },
  { path: 'addFinansijskaKartica', component: AddFinansijskaKarticaComponent },
  { path: 'istorijaTransakcija/:id', component: IstorijaTransakcijaComponent },

  { path: 'transakcija', component: TransakcijaComponent },
  { path: 'addTransakcija', component: AddTransakcijaComponent },
  //{ path: 'editTransakcija', component: EditStudijskaGodinaComponent },

  { path: 'dokument', component: DokumentComponent },
  { path: 'addDokument', component: AddDokumentComponent },
  { path: 'editDokument', component: EditDokumentComponent },

  { path: 'pohadjanje', component: PohadjanjePredmetaComponent },
  { path: 'addPohadjanje', component: AddPohadanjePredmetaComponent },
  { path: 'editPohadjanje', component: EditPohadanjePredmetaComponent },

  { path: 'addProfesor', component: AddProfesorComponent },


  { path: 'login', component: LoginComponent }



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
