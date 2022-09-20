export class PredmetInstanca implements PredmetInstancaInterface{
	public id: number;
	public pocetak : Date;
    public kraj: Date;

   
		
	constructor(objectCfg: PredmetInstancaInterface)
	{	
		this.id = objectCfg.id;
		this.pocetak = objectCfg.pocetak;
        this.kraj = objectCfg.kraj;
	}
}

interface PredmetInstancaInterface {
	id: number;
	pocetak: Date;
    kraj: Date;
    
}