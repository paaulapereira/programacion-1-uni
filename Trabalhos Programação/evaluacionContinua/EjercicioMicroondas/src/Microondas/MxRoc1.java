package Microondas;

public class MxRoc1 extends MxRoc {
	
	public MxRoc1(){
		super();
		_SelectorTiempo=new SelectorTiempo();
		_SelectorPotencia = new SelectorPotencia();
		_pr_disponibles = new ProgramaMicroondas[3];
		_pr_disponibles [0]= new ProgramaMicroondas
							("Calentar",true , true, 0.5, 0, 0 ); 
		_pr_disponibles	[1] = new ProgramaMicroondas
							("Calentar leche", true, true, 1.5, 900, 0);
		_pr_disponibles[2] = new ProgramaMicroondas
							("Descongelar Manual", true, true, 0.5, 100, 0);
	} //esos son los programas del microondas 1
}
