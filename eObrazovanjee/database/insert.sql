--set foreign_key_checks = 0;
-- delete sve podatke u bazii 
--TRUNCATE TABLE eobrazovanjee.korisnik;
--TRUNCATE TABLE eobrazovanjee.student;
--TRUNCATE TABLE eobrazovanjee.profesori;
--TRUNCATE TABLE eobrazovanjee.dokument;
--TRUNCATE TABLE eobrazovanjee.tip_dokumenta;
--TRUNCATE TABLE eobrazovanjee.predmet;
--TRUNCATE TABLE eobrazovanjee.predmetinstanca;
--TRUNCATE TABLE eobrazovanjee.studijska_godina;
--TRUNCATE TABLE eobrazovanjee.finansijska_kartica;
--TRUNCATE TABLE eobrazovanjee.ispitni_rok;
--TRUNCATE TABLE eobrazovanjee.ispit;
--TRUNCATE TABLE eobrazovanjee.deo_ispita;
--TRUNCATE TABLE eobrazovanjee.transakcije;
--set foreign_key_checks = 1;




use eobrazovanjee;

insert into korisnik (id, korisnicko_ime, lozinka,uloga, prof_id, stud_id) values (1,'admin', '123', 'ADMIN', null, null );
insert into korisnik (id, korisnicko_ime, lozinka,uloga, prof_id, stud_id) values (2,'profica', '123', 'PROFESOR', 1, null );
insert into korisnik (id, korisnicko_ime, lozinka,uloga, prof_id, stud_id) values (3,'student', '123', 'STUDENT', null, 1 );
insert into korisnik (id, korisnicko_ime, lozinka,uloga, prof_id, stud_id) values (5,'jana', '123', 'STUDENT', null, 2 );
insert into korisnik (id, korisnicko_ime, lozinka,uloga, prof_id, stud_id) values (6,'filip', '123', 'STUDENT', null, 3 );
insert into korisnik (id, korisnicko_ime, lozinka,uloga, prof_id, stud_id) values (7,'marko', '123', 'STUDENT', null, 4 );
insert into korisnik (id, korisnicko_ime, lozinka,uloga, prof_id, stud_id) values (8,'milan', '123', 'STUDENT', null, 5 );
insert into korisnik (id, korisnicko_ime, lozinka,uloga, prof_id, stud_id) values (9,'sara', '123', 'STUDENT', null, 6 );
insert into korisnik (id, korisnicko_ime, lozinka,uloga, prof_id, stud_id) values (10,'kosta', '123', 'STUDENT', null, 7 );
insert into korisnik (id, korisnicko_ime, lozinka,uloga, prof_id, stud_id) values (11,'visnja', '123', 'STUDENT', null, 8 );
insert into korisnik (id, korisnicko_ime, lozinka,uloga, prof_id, stud_id) values (12,'lazar', '123', 'STUDENT', null, 9 );
insert into korisnik (id, korisnicko_ime, lozinka,uloga, prof_id, stud_id) values (13,'tasa', '123', 'STUDENT', null, 10 );
insert into korisnik (id, korisnicko_ime, lozinka,uloga, prof_id, stud_id) values (14,'milanProfa', '123', 'PROFESOR', 2, null );
insert into korisnik (id, korisnicko_ime, lozinka,uloga, prof_id, stud_id) values (15,'draganProfa', '123', 'PROFESOR', 3, null );
insert into korisnik (id, korisnicko_ime, lozinka,uloga, prof_id, stud_id) values (16,'gabiProfa', '123', 'PROFESOR', 4, null );
insert into korisnik (id, korisnicko_ime, lozinka,uloga, prof_id, stud_id) values (17,'jasnaPorfa', '123', 'PROFESOR', 5, null );

use eobrazovanjee;
insert into student (id,active,email,ime,indeks,prezime,korisnik) values (1, false, 'student@gmail.com', 'Student', 'SF49/2018', 'Studentic',3);
insert into student (id,active,email,ime,indeks,prezime,korisnik) values (2, false, 'jana@gmail.com', 'Jana', 'SF02/2017', 'Jankovic',5);
insert into student (id,active,email,ime,indeks,prezime,korisnik) values (3, false, 'filip@gmail.com', 'Filip', 'SF03/2019', 'Simic',6);
insert into student (id,active,email,ime,indeks,prezime,korisnik) values (4, false, 'marko@gmail.com', 'Marko', 'SF44/2019', 'Lazic',7);
insert into student (id,active,email,ime,indeks,prezime,korisnik) values (5, false, 'milan@gmail.com', 'Milan', 'SF50/2018', 'Gibic',8);
insert into student (id,active,email,ime,indeks,prezime,korisnik) values (6, false, 'sara@gmail.com', 'Sara', 'SF61/2016', 'Laninic',9);
insert into student (id,active,email,ime,indeks,prezime,korisnik) values (7, false, 'kosta@gmail.com', 'Kostantin', 'SF07/2017', 'Jostic',10);
insert into student (id,active,email,ime,indeks,prezime,korisnik) values (8, false, 'visnja@gmail.com', 'Visnja', 'SF18/2017', 'Viskov',11);
insert into student (id,active,email,ime,indeks,prezime,korisnik) values (9, false, 'lazar@gmail.com', 'Lazar', 'SF09/2017', 'Lazic',12);
insert into student (id,active,email,ime,indeks,prezime,korisnik) values (10, false, 'tasa@gmail.com', 'Tanja', 'SF39/2017', 'Tanjic',13);

use eobrazovanjee;
insert into profesori (id,email,ime,prezime,korisnik) values (1, 'savic071@gmail.com', 'Goran', 'Savic', 2);
insert into profesori (id,email,ime,prezime,korisnik) values (2, 'milan@gmail.com', 'Milan', 'Segedinac', 14);
insert into profesori (id,email,ime,prezime,korisnik) values (3, 'dragan@gmail.com', 'Dragan', 'Ivanovic', 15);
insert into profesori (id,email,ime,prezime,korisnik) values (4, 'gabriela@gmail.com', 'Gabriela', 'Grujic', 16);
insert into profesori (id,email,ime,prezime,korisnik) values (5, 'jasna@gmail.com', 'Jasna', 'Englezac', 17);
use eobrazovanjee;
insert into dokument (id,naziv,uri,student_id) values (1, 'Overa semestra', 'uri1', 1);
insert into dokument (id,naziv,uri,student_id) values (2, 'Uverenje o studiranju', 'uri2', 1);
insert into dokument (id,naziv,uri,student_id) values (3, 'Uverenje o studiranju', 'uri3', 2);
insert into dokument (id,naziv,uri,student_id) values (4, 'Overa semestra', 'uri4', 3);
insert into dokument (id,naziv,uri,student_id) values (5, 'Overa semestra', 'uri5', 4);
insert into dokument (id,naziv,uri,student_id) values (6, 'Uverenje o studiranju', 'uri3', 5);
insert into dokument (id,naziv,uri,student_id) values (7, 'Overa semestra', 'uri4', 8);
insert into dokument (id,naziv,uri,student_id) values (8, 'Overa semestra', 'uri5', 9);
insert into dokument (id,naziv,uri,student_id) values (9, 'Potvrda', 'uri8', 5);
insert into dokument (id,naziv,uri,student_id) values (10, 'Potvrda o stipendiji', 'uri4', 8);

use eobrazovanjee;
insert into tip_dokumenta (id,naziv_dokumenta, dokument_id) values (1, 'Overa',1);
insert into tip_dokumenta (id,naziv_dokumenta, dokument_id) values (2, 'Uverenje',1);
insert into tip_dokumenta (id,naziv_dokumenta, dokument_id) values (3, 'Uverenje',2);
insert into tip_dokumenta (id,naziv_dokumenta, dokument_id) values (4, 'Overa ',3);
insert into tip_dokumenta (id,naziv_dokumenta, dokument_id) values (5, 'Overa ',4);
insert into tip_dokumenta (id,naziv_dokumenta, dokument_id) values (6, 'Uverenje ',5);
insert into tip_dokumenta (id,naziv_dokumenta, dokument_id) values (7, 'Overa ',6);
insert into tip_dokumenta (id,naziv_dokumenta, dokument_id) values (8, 'Overa ',7);
insert into tip_dokumenta (id,naziv_dokumenta, dokument_id) values (9, 'Uverenje ',8);
insert into tip_dokumenta (id,naziv_dokumenta, dokument_id) values (10, 'Uverenje ',9);

use eobrazovanjee;
insert into predmet (id, espb, naziv,oznaka) values (1,8, 'Platforme za objektno programiranje', 'POP01');
insert into predmet (id, espb, naziv,oznaka) values (2,8, 'Osnove programiranja', 'OP02');
insert into predmet (id, espb, naziv,oznaka) values (3,6, 'Osnove softverskih arhitektura', 'OSA22');
insert into predmet (id, espb, naziv,oznaka) values (4,6, 'Matematika', 'M04');
insert into predmet (id, espb, naziv,oznaka) values (5,4, 'Engleski jezik', 'E5');
use eobrazovanjee;
insert into predmetinstanca (id, kraj, pocetak,predmet_id) values (1,'2022-01-14', '2022-06-24', 1);
insert into predmetinstanca (id, kraj, pocetak,predmet_id) values (2,'2022-01-14', '2022-06-24', 2);
insert into predmetinstanca (id, kraj, pocetak,predmet_id) values (3,'2022-01-14', '2022-06-24', 3);
insert into predmetinstanca (id, kraj, pocetak,predmet_id) values (4,'2022-01-14', '2022-06-24', 4);
insert into predmetinstanca (id, kraj, pocetak,predmet_id) values (5,'2022-01-14', '2022-06-24', 5);
use eobrazovanjee;
insert into studijska_godina (id,godina_studija,kraj_studija,nacin_finansiranja,pocetak_studija,skolska_godina,student) values (1, 2017, '2023-08-08', 1, '2020-08-09', 2021, 1);
insert into studijska_godina (id,godina_studija,kraj_studija,nacin_finansiranja,pocetak_studija,skolska_godina,student) values (2, 2017, '2023-08-08', 1, '2020-08-09', 2021, 1);
insert into studijska_godina (id,godina_studija,kraj_studija,nacin_finansiranja,pocetak_studija,skolska_godina,student) values (3, 2018, '2023-08-08', 2, '2020-08-09', 2021, 1);
insert into studijska_godina (id,godina_studija,kraj_studija,nacin_finansiranja,pocetak_studija,skolska_godina,student) values (4, 2019, '2023-08-08', 1, '2020-08-09', 2021, 1);
insert into studijska_godina (id,godina_studija,kraj_studija,nacin_finansiranja,pocetak_studija,skolska_godina,student) values (5, 2018, '2023-08-08', 2, '2020-08-09', 2021, 1);
insert into studijska_godina (id,godina_studija,kraj_studija,nacin_finansiranja,pocetak_studija,skolska_godina,student) values (6, 2017, '2023-08-08', 2, '2020-08-09', 2021, 1);

insert into finansijska_kartica (id,personalni_broj,racun_fakulteta,trenutno_stanje) values (1, '26-99211-1-1234-1849 ', '840-1710666-12', 100);
insert into finansijska_kartica (id,personalni_broj,racun_fakulteta,trenutno_stanje) values (2, '26-99211-1-1234-1702 ', '840-1710666-12', 1200 );
insert into finansijska_kartica (id,personalni_broj,racun_fakulteta,trenutno_stanje) values (3, '26-99211-1-1234-1903 ', '840-1710666-12', 1000);
insert into finansijska_kartica (id,personalni_broj,racun_fakulteta,trenutno_stanje) values (4, '26-99211-1-1234-1944 ', '840-1710666-12', 0);
insert into finansijska_kartica (id,personalni_broj,racun_fakulteta,trenutno_stanje) values (5, '26-99211-1-1234-1850 ', '840-1710666-12', 2000);
insert into finansijska_kartica (id,personalni_broj,racun_fakulteta,trenutno_stanje) values (6, '26-99211-1-1234-1661 ', '840-1710666-12', 600);
insert into finansijska_kartica (id,personalni_broj,racun_fakulteta,trenutno_stanje) values (7, '26-99211-1-1234-1707 ', '840-1710666-12', 800);
insert into finansijska_kartica (id,personalni_broj,racun_fakulteta,trenutno_stanje) values (8, '26-99211-1-1234-1718 ', '840-1710666-12', 1500);
insert into finansijska_kartica (id,personalni_broj,racun_fakulteta,trenutno_stanje) values (9, '26-99211-1-1234-1709 ', '840-1710666-12', 200);
insert into finansijska_kartica (id,personalni_broj,racun_fakulteta,trenutno_stanje) values (10, '26-99211-1-1234-1739 ', '840-1710666-12', 500);

use eobrazovanjee;

insert into ispitni_rok (id, kraj_roka, naziv_roka, pocetak_roka) values (1, '2022-01-10', 'Januarski rok', '2022-01-20');
insert into ispitni_rok (id, kraj_roka, naziv_roka, pocetak_roka) values (2, '2022-02-10', 'Februarski rok', '2022-02-25');
insert into ispitni_rok (id, kraj_roka, naziv_roka, pocetak_roka) values (3, '2022-04-10', 'Aprilski rok', '2022-04-15');
insert into ispitni_rok (id, kraj_roka, naziv_roka, pocetak_roka) values (4, '2022-06-21', 'Junski rok', '2022-06-30');
insert into ispitni_rok (id, kraj_roka, naziv_roka, pocetak_roka) values (5, '2022-07-02', 'Julski rok', '2022-07-28');
insert into ispitni_rok (id, kraj_roka, naziv_roka, pocetak_roka) values (6, '2022-08-25', 'Avgustovski rok', '2022-08-30');
insert into ispitni_rok (id, kraj_roka, naziv_roka, pocetak_roka) values (7, '2022-09-10', 'Septembarski rok', '2022-09-28');
insert into ispitni_rok (id, kraj_roka, naziv_roka, pocetak_roka) values (8, '2022-10-04', 'Oktobarski rok', '2022-10-30');


use eobrazovanjee;
insert into ispit (id,broj_osvojenih_bodova, datum_vreme, naziv,ispitni_rok_id,predmet_instanca_id) values (1,15,'2022-01-20','POP01', 1, 1);
insert into ispit (id,broj_osvojenih_bodova, datum_vreme, naziv,ispitni_rok_id,predmet_instanca_id) values (2,50,'2022-01-20','Osnove programiranja', 2, 1);
insert into ispit (id,broj_osvojenih_bodova, datum_vreme, naziv,ispitni_rok_id,predmet_instanca_id) values (3,20,'2022-01-20','OSA', 5, 3);
insert into ispit (id,broj_osvojenih_bodova, datum_vreme, naziv,ispitni_rok_id,predmet_instanca_id) values (4,19,'2022-01-20','Matematika', 5, 4);
insert into ispit (id,broj_osvojenih_bodova, datum_vreme, naziv,ispitni_rok_id,predmet_instanca_id) values (5,80,'2022-01-20','Engleski', 6, 5);

use eobrazovanjee;
insert into deo_ispita (id,naziv, broj_osvojenih_bodova, min_bodova,polozio,ispit) values (1,'Matematika trigonometrija', 19, 20, false,4);
insert into deo_ispita (id,naziv, broj_osvojenih_bodova, min_bodova,polozio,ispit) values (2,'Engleski jezik Verbs', 80, 20, true,5);
insert into deo_ispita (id,naziv, broj_osvojenih_bodova, min_bodova,polozio,ispit) values (3,'Engleski jezik Vremena', 70, 20, true,5);
insert into deo_ispita (id,naziv, broj_osvojenih_bodova, min_bodova,polozio,ispit) values (4,'Osnove programiranja zadatak', 50, 20, true,2);
insert into deo_ispita (id,naziv, broj_osvojenih_bodova, min_bodova,polozio,ispit) values (5,'POP01 Kontrolna tacka', 15, 10, true,1);
insert into deo_ispita (id,naziv, broj_osvojenih_bodova, min_bodova,polozio,ispit) values (6,'Matematika kolokvijum 2', 38, 40, false,4);