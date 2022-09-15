export class IspitniRok implements IspitniRokInterface{
	public id: number;
	public nazivRoka : string;
    public pocetakRoka: any;
	public krajRoka: any;
    //public Korisnik : korisnik;
    //public PredavanjePredmeta : predavanja;


    //moze sa tim interfejsom i bez ako je bez onda u zagradi pisemo da prima id, naziv i to sto stoji tuu
    //? je da moze da prima number i da moze da prima undefined
		
	constructor(objectCfg: IspitniRokInterface)
	{	
		this.id = objectCfg.id;
		this.nazivRoka = objectCfg.nazivRoka;
        this.pocetakRoka = objectCfg.pocetakRoka;
		this.krajRoka = objectCfg.krajRoka;
	}
}

interface IspitniRokInterface {
	id: number;
	nazivRoka: string;
    pocetakRoka: any;
    krajRoka: any;
}