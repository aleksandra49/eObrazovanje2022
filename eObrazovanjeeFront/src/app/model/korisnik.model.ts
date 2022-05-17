export class Korisnik implements KorisnikInterface{
	public id: number;
	public korisnickoIme : string;
    public lozinka: string;
	public uloga: string;
    //public Korisnik : korisnik;
    //public PredavanjePredmeta : predavanja;


    //moze sa tim interfejsom i bez ako je bez onda u zagradi pisemo da prima id, naziv i to sto stoji tuu
    //? je da moze da prima number i da moze da prima undefined
		
	constructor(objectCfg: KorisnikInterface)
	{	
		this.id = objectCfg.id;
		this.korisnickoIme = objectCfg.korisnickoIme;
        this.lozinka = objectCfg.lozinka;
		this.uloga = objectCfg.uloga;
	}
}

interface KorisnikInterface {
	id: number;
	korisnickoIme: string;
    lozinka: string;
    uloga: string;
}