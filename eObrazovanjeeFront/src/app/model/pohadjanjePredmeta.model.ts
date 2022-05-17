

export class PohadjanjePredmeta implements PohadjanjePredmetaInterface{
	public id: number;
	public pocetak: Date;
	public kraj: Date;
	public polozen: boolean;
    
	/*public student: Student;
	public predmetInstanca: PredmetInstanca;*/
	
		
	constructor(pohadjenjeCfg:PohadjanjePredmetaInterface)
	{	
		this.id = pohadjenjeCfg.id;
		this.pocetak = pohadjenjeCfg.pocetak;
		this.kraj = pohadjenjeCfg.kraj;
		this.polozen = pohadjenjeCfg.polozen;	
       	
	}
}

interface PohadjanjePredmetaInterface{
	id: number;
	pocetak: Date;
	kraj: Date;	
	polozen: boolean;
   
   /* student: Student;
	predmetInstanca: PredmetInstanca;*/
}