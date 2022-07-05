import { Korisnik } from './korisnik.model';

export class FinansijskaKartica implements FinansijskaKarticaInterface{
	public id: number;
	public personalniBroj : string;
    public trenutnoStanje: number;
	public racunFakulteta: string;
    
	
  
	constructor(profesorCfg: FinansijskaKarticaInterface)
	{	
		this.id = profesorCfg.id;
		this.personalniBroj = profesorCfg.personalniBroj;
        this.trenutnoStanje = profesorCfg.trenutnoStanje;
		this.racunFakulteta = profesorCfg.racunFakulteta;
	}
}

interface FinansijskaKarticaInterface {
	id: number;
	personalniBroj: string;
    trenutnoStanje: number;
    racunFakulteta: string;
}