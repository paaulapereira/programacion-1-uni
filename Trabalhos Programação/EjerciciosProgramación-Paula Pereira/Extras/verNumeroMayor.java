import java.util.Scanner;

public class verNumeroMayor {

	public static void main (String[] args) {

		int primerNumero, segundoNumero, numeroMayor;

		Scanner entrada = new Scanner(System.in);

		System.out.println("Ingrese el primer número: ");
		primerNumero = entrada.nextInt();

		System.out.println("Ingrese el segundo número: ");
		segundoNumero = entrada.nextInt();

		if (primerNumero > segundoNumero) {
					numeroMayor = primerNumero;
				} else {
					numeroMayor = segundoNumero;
				}

		System.out.println("El número mayor es: " + numeroMayor);
	}
}
