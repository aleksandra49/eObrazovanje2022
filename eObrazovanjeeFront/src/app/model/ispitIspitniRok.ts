export class IspitIspitniRok implements IspitIspitniRokInterface{
	public ispitId: number;
	public nazivPredmeta : string;
    public datumIVremeRoka: any;
	public nazivRoka : string;
    //public Korisnik : korisnik;
    //public PredavanjePredmeta : predavanja;


    //moze sa tim interfejsom i bez ako je bez onda u zagradi pisemo da prima id, naziv i to sto stoji tuu
    //? je da moze da prima number i da moze da prima undefined
		
	constructor(objectCfg: IspitIspitniRokInterface)
	{	
		this.ispitId = objectCfg.ispitId;
		this.nazivPredmeta = objectCfg.nazivPredmeta;
        this.datumIVremeRoka = objectCfg.datumIVremeRoka;
		this.nazivRoka = objectCfg.nazivRoka;
	}
}

interface IspitIspitniRokInterface {
	ispitId: number;
	nazivPredmeta: string;
    datumIVremeRoka: any;
    nazivRoka: string;
}