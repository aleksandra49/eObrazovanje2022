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

@NgModule({
  declarations: [
    AppComponent,
    ProfesorComponent,
    KorisnikComponent,
    StudentComponent,
    AddStudentComponent,
    EditStudentComponent,
    StudentProfilComponent,
    IspitComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [ProfesorService, KorisnikService, IspitService],
  bootstrap: [AppComponent]
})
export class AppModule { }
