import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProfesorComponent } from './profesor/profesor.component';
import { ProfesorService } from './profesor/profesor.service';
import { KorisnikComponent } from './korisnik/korisnik.component';
import { KorisnikService } from './korisnik/korisnik.service';

@NgModule({
  declarations: [
    AppComponent,
    ProfesorComponent,
    KorisnikComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [ProfesorService, KorisnikService],
  bootstrap: [AppComponent]
})
export class AppModule { }
