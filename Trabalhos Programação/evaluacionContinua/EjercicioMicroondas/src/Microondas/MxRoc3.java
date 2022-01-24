package Microondas;

public class MxRoc3 extends MxRoc2{

	public MxRoc3() {
		super();
	
		_SelectorTiempo=new SelectorTiempo();
		_SelectorPotencia = new SelectorPotencia();
		_SelectorGrill = new SelectorGrill();
		_pr_disponibles = new ProgramaMicroondas[6];
		_pr_disponibles [0]= new ProgramaMicroondas
							("Calentar",true , true, 0, 0, 0 ); 
		_pr_disponibles[1] = new ProgramaMicroondas
							("Calentar leche", true, true, 1.5, 900, 0);
		_pr_disponibles[2] = new ProgramaMicroondas
							("Descongelar Automático", true, true, 3, 100, 0);	
		_pr_disponibles[2] = new ProgramaMicroondas
							("Descongelar Manual", true, true, 0.5, 100, 0);
		_pr_disponibles[3] = new ProgramaMicroondas
							("Solo Grill", true, true, 3, 0, 1);
		_pr_disponibles[4] = new ProgramaMicroondas
							("Grill + Calentar", true, true, 5, 900,1);
	} //esos son los programas del microondas 3
}
