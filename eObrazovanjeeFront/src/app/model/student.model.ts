import { Korisnik } from "./korisnik.model";

export class Student implements StudentInterface{
	public id: number;
	public ime: string;
	public prezime: string;
	public indeks: string;
    public email: string;
	public active: boolean;
	/*public studijskaGodina: StudijskaGodina;
	public dokumenti: Dokument;
    public finansijskaKartica: FinansijskaKartica;
	public pohadjanjePredmeta: PohadjanjePredmeta;
	public korisnik: Korisnik;*/
	
		
	constructor(studentCfg:StudentInterface)
	{	
		this.id = studentCfg.id;
		this.ime = studentCfg.ime;
		this.prezime = studentCfg.prezime;
		this.indeks = studentCfg.indeks;	
        this.email = studentCfg.email;
		this.active = studentCfg.active;	
	}
}

interface StudentInterface{
	id: number;
	ime: string;
	prezime: string;	
	indeks: string;
    email: string;
    active: boolean;
   /* studijskaGodina: string;
	dokumenti: string;
    finansijskaKartica: number;
	pohadjanjePredmeta: boolean;
	korisnik: string;*/
}