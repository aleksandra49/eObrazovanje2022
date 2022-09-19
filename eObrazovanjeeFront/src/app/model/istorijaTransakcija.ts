export class IstorijaTransakcija implements IstorijaTransakcijaInteface{
	
	public idTransakcije : number;
    public datum : Date;
    public promenaStanja : number;
    public svrha: String;
    public personalniBroj: String;
	public racunFakulteta: String;
    public trenutnoStanje: number;

    
		
	constructor(objectCfg: IstorijaTransakcijaInteface)
	{	
		
		this.idTransakcije = objectCfg.idTransakcije;
        this.datum = objectCfg.datum;
		this.promenaStanja = objectCfg.promenaStanja;
        this.svrha = objectCfg.svrha;
        this.personalniBroj = objectCfg.personalniBroj;
		this.racunFakulteta = objectCfg.racunFakulteta;
        this.trenutnoStanje = objectCfg.trenutnoStanje;
	}
}

interface IstorijaTransakcijaInteface {
    idTransakcije : number;
    datum : Date;
    promenaStanja : number;
    svrha: String;
    personalniBroj: String;
	racunFakulteta: String;
    trenutnoStanje: number;
}

