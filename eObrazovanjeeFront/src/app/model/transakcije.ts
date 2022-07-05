export class Transakcija implements TransakcijaInterface{
	public id: number;
	public datum : Date;
    public svrha: string;
	public promenaStanja : number;
    
    
  
	constructor(transakcijaCfg: TransakcijaInterface)
	{	
		this.id = transakcijaCfg.id;
		this.datum = transakcijaCfg.datum;
        this.svrha = transakcijaCfg.svrha;
        this.promenaStanja = transakcijaCfg.promenaStanja;
       
	}
}

interface TransakcijaInterface {
	id: number;
	datum: Date;
    svrha: string;
    promenaStanja : number;
    
}