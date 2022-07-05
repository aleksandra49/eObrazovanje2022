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
    AddKorisnikComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule
  ],
  providers: [ProfesorService, KorisnikService, IspitService, IspitniRokService, StudentService, DokumentService, PolaganjeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
