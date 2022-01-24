package Microondas;

public class MxRoc2 extends MxRoc1{
	
	public MxRoc2() {
		super();
		_SelectorTiempo=new SelectorTiempo();
		_SelectorPotencia = new SelectorPotencia();
		_SelectorGrill = new SelectorGrill();
		_pr_disponibles = new ProgramaMicroondas[4];
		_pr_disponibles [0]= new ProgramaMicroondas
							("Calentar",true , true, 0.5, 0, 0 ); 
							
		_pr_disponibles[1] = new ProgramaMicroondas
							("Calentar leche", true, true, 1.5, 900, 0);
		_pr_disponibles[2] = new ProgramaMicroondas
							("Descongelar Manual", true, true, 0.5, 100, 0);	
		_pr_disponibles[3] = new ProgramaMicroondas
							("Solo Grill", true, true, 3, 0, 1);
	}//esos son los programas del microondas 2
}
