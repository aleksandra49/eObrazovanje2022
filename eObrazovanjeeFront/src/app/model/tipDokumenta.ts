

export class TipDokumenta implements TipDokumentaInterface{
	public id: number;
	public nazivDokumenta : string;
    
    
	
  
	constructor(profesorCfg: TipDokumentaInterface)
	{	
		this.id = profesorCfg.id;
		this.nazivDokumenta = profesorCfg.nazivDokumenta;
       
	}
}

interface TipDokumentaInterface {
	id: number;
	nazivDokumenta: string;
    
}