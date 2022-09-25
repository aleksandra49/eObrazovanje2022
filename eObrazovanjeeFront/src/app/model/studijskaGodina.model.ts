

export class StudijskaGodina implements StudijskaGodinaInterface{
	public id: number;
	// public pocetakStudija: Date;
	// public krajStudija: Date;
	public pocetakStudija: any;
	 public krajStudija: any;
	public nacinFinansiranja: any; //enum
    public godinaStudija: number;
	public skolskaGodina: number;
	/*public student: Student;*/
	
		
	constructor(studijskaGodinatCfg:StudijskaGodinaInterface)
	{	
		this.id = studijskaGodinatCfg.id;
		this.pocetakStudija = studijskaGodinatCfg.pocetakStudija;
		this.krajStudija = studijskaGodinatCfg.krajStudija;
		this.nacinFinansiranja = studijskaGodinatCfg.nacinFinansiranja;	
        this.godinaStudija = studijskaGodinatCfg.godinaStudija;
		this.skolskaGodina = studijskaGodinatCfg.skolskaGodina;	
	}
}

interface StudijskaGodinaInterface{
	id: number;
	// // pocetakStudija: Date;
	// // krajStudija: Date;
	pocetakStudija: any;
	 krajStudija: any;		
	nacinFinansiranja: string;
    godinaStudija: number;
    skolskaGodina: number;
   /* student: Student;;*/
}