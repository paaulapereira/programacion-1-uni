package Microondas;

public class SelectorGrill {
	
	private int grill;
	private int grillMax = 4;
	private int grillMin = 1;
	
	public SelectorGrill () { grill=0; }
	public int grilling(){ return grill; }
	public int maxGrill() { return grillMax; }
	public int minGrill() { return grillMin; }
	
	public void Mensaje(String g, String o) {
		g= "Seleccione el nivel del grill";
		o= "Observaciones: Máx(3) y Min(0)";
		System.out.println(g);
		System.out.println(o);
	}
	
	public void fijarGrill (int fg) {
		if(fg>=grillMin && fg<=grillMax) {
			grill=fg;
		} else {
			System.out.println("Seleccione una opción válida");
		}
	}
	
}
