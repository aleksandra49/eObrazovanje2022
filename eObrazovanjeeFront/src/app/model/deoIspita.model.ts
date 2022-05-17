

export class DeoIspita implements DeoIspitaInterface{
	public id: number;
	public naziv: string;
	public brojOsvojenihBodova: number; //double
	public minBodova: number; //int
    public polozio: boolean;
	/*public ispit: Ispit;*/
	
		
	constructor(deoIspitaCfg:DeoIspitaInterface)
	{	
		this.id = deoIspitaCfg.id;
		this.naziv = deoIspitaCfg.naziv;
		this.brojOsvojenihBodova = deoIspitaCfg.brojOsvojenihBodova;
		this.minBodova = deoIspitaCfg.minBodova;	
        this.polozio = deoIspitaCfg.polozio;
	}
}

interface DeoIspitaInterface{
	id: number;
	naziv: string;
	brojOsvojenihBodova: number;	
	minBodova: number;
    polozio: boolean;
   /* ispit: Ispit;*/
}