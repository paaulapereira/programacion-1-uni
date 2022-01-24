package Microondas;

public class SelectorPotencia {
	
	private int potencia;
	private int potenciaMax = 900;
	private int potenciaMin = 100;
	
	public SelectorPotencia () { potencia = 0; }
	
	public int potencias(){
		return potencia;
	}
	public int maximaPotencia() {
		return potenciaMax;
	}
	public int minimaPotencia() {
		return potenciaMin;
	}
	
	public void Mensaje(String p, String h) {
		p= "Seleccione la potencia (en intervalos de 100W)";
		h= "Potencia máxima: 900, Potencia mínima: 100";
		System.out.println(p);
		System.out.println(h);
	}
	
	public void fijarPotencia (int ptw) {
		if(ptw>=potenciaMin && ptw<=potenciaMax) {
			potencia=ptw;
		} else {
			System.out.println("Seleccione una potencia válida");
		}
	}
	
}
