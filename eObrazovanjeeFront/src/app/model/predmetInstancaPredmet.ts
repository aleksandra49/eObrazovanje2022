export class PredmetInstancaPredmet implements PredmetInstancaPredmetInterface{
	public id: number;
	public naziv : string;
    public espb: number;
	public oznaka: String;
	public pocetak : any;
    public kraj: any;

   
		
	constructor(objectCfg: PredmetInstancaPredmetInterface)
	{	
		this.id = objectCfg.id;
		this.naziv = objectCfg.naziv;
        this.espb = objectCfg.espb;
		this.oznaka = objectCfg.oznaka;
		this.pocetak=objectCfg.pocetak;
		this.kraj= objectCfg.kraj;
	}
}

interface PredmetInstancaPredmetInterface {
	id: number;
	naziv: string;
    espb: number;
    oznaka: String;
	 pocetak : any;
     kraj: any;
}