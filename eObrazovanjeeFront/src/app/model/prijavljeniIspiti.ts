export class PrijavljeniIspiti implements PrijavljeniIspitiInterface{

    public prijavljenIspitId: number;
    public naziv: string;
    public datumIspita: any;



	constructor(PrijavljeniIspitCfg: PrijavljeniIspitiInterface)
	{	
		this.prijavljenIspitId = PrijavljeniIspitCfg.prijavljenIspitId;
		this.naziv = PrijavljeniIspitCfg.naziv;
        this.datumIspita = PrijavljeniIspitCfg.datumIspita;

	}


}

interface PrijavljeniIspitiInterface{
    prijavljenIspitId: number;
    naziv: string;
    datumIspita: any;

}