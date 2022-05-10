export class Profesor implements ProfesorInterface{
	public id: number;
	public ime : string;
    public prezime: string;
	public email: string;
    //public Korisnik : korisnik;
    //public PredavanjePredmeta : predavanja;


    //moze sa tim interfejsom i bez ako je bez onda u zagradi pisemo da prima id, naziv i to sto stoji tuu
    //? je da moze da prima number i da moze da prima undefined
		
	constructor(profesorCfg: ProfesorInterface)
	{	
		this.id = profesorCfg.id;
		this.ime = profesorCfg.ime;
        this.prezime = profesorCfg.prezime;
		this.email = profesorCfg.email;
	}
}

interface ProfesorInterface {
	id: number;
	ime: string;
    prezime: string;
    email: string;
}