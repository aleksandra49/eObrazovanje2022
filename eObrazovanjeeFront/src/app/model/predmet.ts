import { PredmetInstanca } from "./predmetInstanca";

export class Predmet implements PredmetInterface{
	public id: number;
	public naziv : string;
    public espb: number;
	public oznaka: String;
	public predmetInstancaDTO: PredmetInstanca

   
		
	constructor(objectCfg: PredmetInterface)
	{	
		this.id = objectCfg.id;
		this.naziv = objectCfg.naziv;
        this.espb = objectCfg.espb;
		this.oznaka = objectCfg.oznaka;
		this.predmetInstancaDTO=objectCfg.predmetInstancaDTO;
		
	}
}

interface PredmetInterface {
	id: number;
	naziv: string;
    espb: number;
    oznaka: String;
    predmetInstancaDTO : PredmetInstanca;
     
}