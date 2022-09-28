

export class addStudijskaGodina implements addStudijskaGodinaInterface{
	
	public nacinFinansiranja: any; //enum
    public godinaStudija: number;
	public studentId: number;
	
	
		
	constructor(studijskaGodinatCfg:addStudijskaGodinaInterface)
	{	
		
		this.nacinFinansiranja = studijskaGodinatCfg.nacinFinansiranja;	
        this.godinaStudija = studijskaGodinatCfg.godinaStudija;
		this.studentId = studijskaGodinatCfg.studentId;
	}
}

interface addStudijskaGodinaInterface{
	
	nacinFinansiranja: string;
    godinaStudija: number;
  
	studentId: number;
  
}