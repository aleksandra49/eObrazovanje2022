import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProfesorComponent } from './profesor/profesor.component';
import { ProfesorService } from './profesor/profesor.service';
import { KorisnikComponent } from './korisnik/korisnik.component';
import { KorisnikService } from './korisnik/korisnik.service';
import { StudentComponent } from './student/student.component';
import { AddStudentComponent } from './student/add-student/add-student.component';
import { EditStudentComponent } from './student/edit-student/edit-student.component';
import { StudentProfilComponent } from './student/student-profil/student-profil.component';
import { IspitComponent } from './ispit/ispit.component';
import { IspitService } from './ispit/ispit.service';
import { IspitniRokComponent } from './ispitni-rok/ispitni-rok.component';
import { IspitniRokService } from './ispitni-rok/ispitni-rok.service';
import { StudentService } from './student/student.service';
import { DokumentComponent } from './dokument/dokument.component';
import { DokumentService } from './dokument/dokument.service';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AddProfesorComponent } from './profesor/add-profesor/add-profesor/add-profesor.component';
import { PolaganjeIspitaComponent } from './polaganje-ispita/polaganje-ispita.component';
import { PolaganjeService } from './polaganje-ispita/polaganje-ispita.service';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { AddIspitComponent } from './ispit/add-ispit/add-ispit.component';
import { AddKorisnikComponent } from './korisnik/add-korisnik/add-korisnik.component';
import { DeoIspitaComponent } from './deo-ispita/deo-ispita.component';
import { AddDeoIspitaComponent } from './deo-ispita/add-deo-ispita/add-deo-ispita.component';
import { EditDeoIspitaComponent } from './deo-ispita/edit-deo-ispita/edit-deo-ispita.component';
import { StudijskaGodinaComponent } from './studijska-godina/studijska-godina.component';
import { EditStudijskaGodinaComponent } from './studijska-godina/edit-studijska-godina/edit-studijska-godina.component';
import { AddStudijskaGodinaComponent } from './studijska-godina/add-studijska-godina/add-studijska-godina.component';
import { DeoIspitaService } from './deo-ispita/deoIspita.service';
import { AddDokumentComponent } from './dokument/add-dokument/add-dokument.component';
import { FinansijskaKarticaComponent } from './finansijska-kartica/finansijska-kartica.component';
import { TipDokumentaComponent } from './tip-dokumenta/tip-dokumenta.component';
import { AddFinansijskaKarticaComponent } from './finansijska-kartica/add-finansijska-kartica/add-finansijska-kartica.component';
import { AddTipDokumentaComponent } from './tip-dokumenta/add-tip-dokumenta/add-tip-dokumenta.component';
import { TransakcijaComponent } from './transakcija/transakcija.component';
import { AddTransakcijaComponent } from './transakcija/add-transakcija/add-transakcija.component';
import { AddIspitniRokComponent } from './ispitni-rok/add-ispitni-rok/add-ispitni-rok.component';
import { TransakcijaService } from './transakcija/transakcija.service';
import { AddPolaganjeIspitaComponent } from './polaganje-ispita/add-polaganje-ispita/add-polaganje-ispita.component';
import { PohadjanjePredmetaComponent } from './pohadjanje-predmeta/pohadjanje-predmeta.component';
import { AddPohadanjePredmetaComponent } from './pohadjanje-predmeta/add-pohadanje-predmeta/add-pohadanje-predmeta.component';
import { EditPohadanjePredmetaComponent } from './pohadjanje-predmeta/edit-pohadanje-predmeta/edit-pohadanje-predmeta.component';
import { EditProfesorComponent } from './profesor/edit-profesor/edit-profesor.component';
import { EditIspitComponent } from './ispit/edit-ispit/edit-ispit.component';
import { EditIspitniRokComponent } from './ispitni-rok/edit-ispitni-rok/edit-ispitni-rok.component';
import { EditKorisnikComponent } from './korisnik/edit-korisnik/edit-korisnik.component';
import { EditPolaganjeIspitaComponent } from './polaganje-ispita/edit-polaganje-ispita/edit-polaganje-ispita.component';
import { StudijskaGodinaService } from './studijska-godina/studijska-godina.service';
import { PohadjanjePredmetaService } from './pohadjanje-predmeta/pohadjanje-predmeta.service';
import { authInterceptorProviders } from './auth.interceptor';
// import {NgbPaginationModule, NgbAlertModule} from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    ProfesorComponent,
    KorisnikComponent,
    StudentComponent,
    AddStudentComponent,
    EditStudentComponent,
    StudentProfilComponent,
    IspitComponent,
    IspitniRokComponent,
    DokumentComponent,
    AddProfesorComponent,
    PolaganjeIspitaComponent,
    LoginComponent,
    AddIspitComponent,
    AddKorisnikComponent,
    DeoIspitaComponent,
    AddDeoIspitaComponent,
    EditDeoIspitaComponent,
    StudijskaGodinaComponent,
    EditStudijskaGodinaComponent,
    AddStudijskaGodinaComponent,
    AddDokumentComponent,
    FinansijskaKarticaComponent,
    TipDokumentaComponent,
    AddFinansijskaKarticaComponent,
    AddTipDokumentaComponent,
    TransakcijaComponent,
    AddTransakcijaComponent,
    AddIspitniRokComponent,
    AddPolaganjeIspitaComponent,
    PohadjanjePredmetaComponent,
    AddPohadanjePredmetaComponent,
    EditPohadanjePredmetaComponent,
    EditProfesorComponent,
    EditIspitComponent,
    EditIspitniRokComponent,
    EditKorisnikComponent,
    EditPolaganjeIspitaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule
  ],
  providers: [ProfesorService, 
              KorisnikService, IspitService, IspitniRokService, PolaganjeService, 
              StudentService, DeoIspitaService, StudijskaGodinaService, PohadjanjePredmetaService,
              DokumentService, authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
