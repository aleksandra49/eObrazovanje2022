export class PolaganjeIspita implements PolaganjeInterface{
	public id: number;




		
	constructor(polaganjeCfg: PolaganjeInterface)
	{	
		this.id = polaganjeCfg.id;

	}
}

interface PolaganjeInterface {
	id: number;

}