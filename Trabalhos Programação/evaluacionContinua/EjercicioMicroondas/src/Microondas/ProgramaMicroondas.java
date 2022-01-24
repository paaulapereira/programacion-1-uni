package Microondas;

public class ProgramaMicroondas {

	private String nombre;
	private boolean apagado;
	private boolean finalizado;
	private double duracion;
	private int potencia;
	private int grill;
	
	
	public ProgramaMicroondas (){}
	
	public ProgramaMicroondas (String nomb, boolean off, boolean fin, double tiempo, int ptw, int fg){
		nombre = nomb;
		apagado= off;
		finalizado = fin;
		duracion = tiempo;
		potencia = ptw;
		grill = fg;
	}
	public int grill() {
		return grill;
	}
	public int potencia() {
		return potencia;
	}
	
	public double duracion(){ return duracion; }
	
	public String nombre() {
		return nombre;
	}
	
	public void Activar() {
		if(apagado) {
			System.out.println("Microondas apagado");
		}
		for(double i=duracion; i>0;i-=0.5) {
			System.out.println("Tiempo actual:" + i);
		}
		if(finalizado) {
			System.out.println("Su comida está lista.");
		}
	}

	
}
