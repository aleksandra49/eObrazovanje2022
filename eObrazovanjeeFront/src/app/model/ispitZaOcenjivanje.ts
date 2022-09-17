export class IspitiZaOcenjivanje implements IspitiZaOcenjivanjeInterface{

    public studentIme: string;
    public studentPrezime: string;
    public polozenIspitId: number;
    public nazivPredmeta:string;
    public datumIspita:any;
    public broj_bodova:number;


	constructor(IspitiZaOcenjivanjeCfg: IspitiZaOcenjivanjeInterface)
	{	
		this.studentIme = IspitiZaOcenjivanjeCfg.studentIme;
		this.studentPrezime = IspitiZaOcenjivanjeCfg.studentPrezime;
        this.polozenIspitId = IspitiZaOcenjivanjeCfg.polozenIspitId;
		this.nazivPredmeta = IspitiZaOcenjivanjeCfg.nazivPredmeta;
        this.datumIspita = IspitiZaOcenjivanjeCfg.datumIspita;
        this.broj_bodova = IspitiZaOcenjivanjeCfg.broj_bodova;
	}


}

interface IspitiZaOcenjivanjeInterface{
    studentIme: string;
    studentPrezime: string;
    polozenIspitId: number;
    nazivPredmeta:string;
    datumIspita:any;
    broj_bodova:number;
}