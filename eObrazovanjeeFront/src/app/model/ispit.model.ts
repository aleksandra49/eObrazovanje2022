export class Ispit implements IspitInterface{
	public id: number;
	public naziv : string;
    public datumVreme: any;
	public brojBodova: number;
	public deoIspitaDTO: any;
    //public Korisnik : korisni:k;
    //public PredavanjePredmeta : predavanja;


    //moze sa tim interfejsom i bez ako je bez onda u zagradi pisemo da prima id, naziv i to sto stoji tuu
    //? je da moze da prima number i da moze da prima undefined
		
	constructor(objectCfg: IspitInterface)
	{	
		this.id = objectCfg.id;
		this.naziv = objectCfg.naziv;
        this.datumVreme = objectCfg.datumVreme;
		this.brojBodova = objectCfg.brojBodova;
	}
}

interface IspitInterface {
	id: number;
	naziv: string;
    datumVreme: any;
    brojBodova: number;
}