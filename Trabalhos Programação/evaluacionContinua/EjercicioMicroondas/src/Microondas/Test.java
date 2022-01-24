package Microondas;

public class Test {
	
	public static void main (String[] args) {
		MxRoc mi_microondas;
		mi_microondas = new MxRoc1();
		System.out.println("Microondas 1");
		manipular (mi_microondas);
		mi_microondas = new MxRoc2 ();
		System.out.println("Microondas 2");
		manipular (mi_microondas);
		mi_microondas = new MxRoc3 ();
		System.out.println("Microondas 3");
		manipular (mi_microondas);
	}
	
	private static void manipular (MxRoc mx) {
        mx.infoPrograma();
        mx.ponerEnFuncion();
        mx.infoPrograma();
        mx.ponerEnMarcha();
	}
}
