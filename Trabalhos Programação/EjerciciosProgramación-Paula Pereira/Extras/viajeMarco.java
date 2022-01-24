import java.util.Scanner;

public class viajeMarco{

	public static void main(String[] args){
	
	Scanner entrada = new Scanner(System.in);
	
	double velocidadMarco, tiempoMarco, probabilidadDeLluvia, monoSeEscapa, monoSeCansa, avanceMadre, distanciaMM, avanceMarco;
	int diasRecorridos;
	
	String pausaParaLeer;
	String descripcionDelClima;
	String monerias;
	
	distanciaMM = 350;
	diasRecorridos = 0;
	monerias = "";
	
		do{
			
			diasRecorridos = diasRecorridos + 1;
			tiempoMarco = (double)(Math.random()*(10-8)+8); // aleatorio entre 8 y 10
			velocidadMarco = (double)(Math.random()*(15-10)+10);
		
			
			probabilidadDeLluvia = Math.random();
			
			if(probabilidadDeLluvia<0.6){
				descripcionDelClima = "No llueve";
			} else if(probabilidadDeLluvia<0.9){
				descripcionDelClima = "Lluvia ligera";
				velocidadMarco = velocidadMarco * 0.75;
			} else {
				descripcionDelClima = "Lluvia fuerte";
				velocidadMarco = velocidadMarco * 0.25;
			}
			
			monoSeCansa = Math.random();
			monoSeEscapa = Math.random();
			
			if(monoSeCansa <= 0.25){
				monerias = "Se canso el mono";
				velocidadMarco = velocidadMarco * 0.9;
			}
			if(monoSeEscapa <= 0.15){
				monerias = "Se escapo el mono";
				tiempoMarco = tiempoMarco - 2;
			}
			
			avanceMarco = velocidadMarco * tiempoMarco;
			avanceMadre = 80;
			
			distanciaMM = distanciaMM - avanceMarco + avanceMadre;
			
			System.out.println("Dia :" + diasRecorridos);
			System.out.println("Velocidad de Marco :" + velocidadMarco);
			System.out.println("Tiempo de Marco :"+ tiempoMarco);
			System.out.println("Probabilidad de lluvia :" + probabilidadDeLluvia);
			System.out.println(descripcionDelClima);
			System.out.println(monerias);
			System.out.println("La distancia entre Marco y su madre es: " + distanciaMM);
			monerias = "";

			
			pausaParaLeer = entrada.nextLine();
			
		} while(distanciaMM>0); // repetir isso enquanto a distancia entre o marco e a mae seja maior que zero
		
		System.out.println("Marco ha encontrado su madre");
	}	
}