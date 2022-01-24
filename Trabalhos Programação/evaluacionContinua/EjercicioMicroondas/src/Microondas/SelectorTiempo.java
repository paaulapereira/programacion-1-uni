package Microondas;

public class SelectorTiempo {

	private double tiempo;
	private double tiempoMax = 90;
	private double tiempoMin = 0.5;
	
	public SelectorTiempo () { tiempo=0; }
	
	public double tiempo () { return tiempo; }
	
	public double tiempoMaximo () { return tiempoMax; }
	
	public double tiempoMinimo () { return tiempoMin; }
	
	//pregunta el tiempo
	public void Mensaje(String t, String m) {
		t = "Seleccionar el tiempo: ( Min=0.5 minutos y Max=90 minutos )";
		m = "En intervalos de 0.5 minutos";
		System.out.println(t);
		System.out.println(m);
	}
	
	public void fijarTiempo(double tiemp) {
		if (tiemp !=0.5) {
			if (tiemp>=tiempoMin && tiemp<=tiempoMax) {
				tiempo = tiemp;
			}else {
				System.out.println("Por favor, selecccione un tiempo válido");
			}
		}else {
			System.out.println("El tiempo es predeterminado");
			System.out.println(tiempo +  "min");
		}
	}
	
}
