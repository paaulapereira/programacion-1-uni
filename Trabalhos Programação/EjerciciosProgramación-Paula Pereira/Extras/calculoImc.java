import java.util.Scanner;

public class calculoImc {

	public static void main (String[] args){

		double miTalla, miPeso, miIMC;
		String miEstado = "";

		Scanner entrada = new Scanner(System.in);

		System.out.println("Ingrese su talla: ");
		miTalla = entrada.nextDouble();

		System.out.println("Ingrese su peso (en Kg): ");
		miPeso = entrada.nextDouble();

		miIMC = miPeso / (Math.pow(miTalla,2));
		System.out.println("Su IMC es: " + miIMC);

		if( miIMC < 18.5){ miEstado = "Peso Insuficiente";}


		if ((miIMC >= 18.5) && (miIMC <= 24.9)){ miEstado = "Nomopeso";}


		if ((miIMC >= 25) && (miIMC <= 26.9)){ miEstado = "Sobrepeso grado I";}


		if (( miIMC >= 27) && (miIMC <= 29.9)) { miEstado = "Sobrepeso grado II(preobesidad)";}


		if (( miIMC >= 30) && (miIMC <= 34.9)) { miEstado ="Obesidad de tipo I";}


		if (( miIMC >= 35) && (miIMC <= 39.9)) { miEstado = "Obesidad de tipo II";}


		if (( miIMC >= 40) && (miIMC <=49.9)) { miEstado = "Obesidad de tipo III(mórbida)";}


		if ( miIMC > 50) { miEstado = "Obesidad de tipo IV(extrema)";}


		System.out.println("Su estado es: " + miEstado);
	}
}
