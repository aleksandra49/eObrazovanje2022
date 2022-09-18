export class IstorijaPolaganja implements IstorijaPolaganjaInteface{
	
	public studentIme : string;
    public studentPrezime : string;
    public nazivPredmeta : string;
    public brojBodova: number;
    public datumVreme: any;
	public ispitId: number;
    public studentId: number;
    
		
	constructor(objectCfg: IstorijaPolaganjaInteface)
	{	
		
		this.studentIme = objectCfg.studentIme;
        this.studentPrezime = objectCfg.studentPrezime;
		this.nazivPredmeta = objectCfg.nazivPredmeta;
        this.brojBodova = objectCfg.brojBodova;
        this.datumVreme = objectCfg.datumVreme;
		this.ispitId = objectCfg.ispitId;
        this.studentId = objectCfg.studentId;
	}
}

interface IstorijaPolaganjaInteface {
	 studentIme : string;
     studentPrezime : string;
     nazivPredmeta : string;
     brojBodova: number;
     datumVreme: any;
	 ispitId: number;
     studentId: number;
}