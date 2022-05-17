export class Dokument implements DokumentInterface {
   
    public id: number;
	public naziv: string;
	public uri : string;
	/*
    public student: Student;
	public tipDokumenta: TipDokumenta;
    
    */
	
		
	constructor(dokumentCfg:DokumentInterface)
	{	
		this.id = dokumentCfg.id;
		this.naziv = dokumentCfg.naziv;
		this.uri = dokumentCfg.uri;	
	}
}

interface DokumentInterface{
	id: number;
	naziv: string;
	uri: string;	
   /* 
   student: string;
    tipDokumenta: string;
   
    */
}