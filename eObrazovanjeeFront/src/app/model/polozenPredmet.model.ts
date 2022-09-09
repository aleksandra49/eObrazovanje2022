export class PolozenPredmet implements PolozenPredmetInterface{

    public nazivPredmeta: string;
    public brojOsvojenihBodova: number;
    public ispit_id: number;
    public student_id:number;


	constructor(PolozenPredmetCfg: PolozenPredmetInterface)
	{	
		this.nazivPredmeta = PolozenPredmetCfg.nazivPredmeta;
		this.brojOsvojenihBodova = PolozenPredmetCfg.brojOsvojenihBodova;
        this.ispit_id = PolozenPredmetCfg.ispit_id;
		this.student_id = PolozenPredmetCfg.student_id;

	}


}

interface PolozenPredmetInterface{
     nazivPredmeta: string;
     brojOsvojenihBodova: number;
     ispit_id: number;
     student_id:number;
}