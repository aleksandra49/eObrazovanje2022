export class PredajePredmet implements PredajePredmetInterface{

    public oznaka: string;
    public naziv: string;
    public espb: number;



	constructor(PredajePredmetCfg: PredajePredmetInterface)
	{	
		this.oznaka = PredajePredmetCfg.oznaka;
		this.naziv = PredajePredmetCfg.naziv;
        this.espb = PredajePredmetCfg.espb;


	}


}

interface PredajePredmetInterface{
    oznaka: string;
    naziv: string;
    espb: number;

}