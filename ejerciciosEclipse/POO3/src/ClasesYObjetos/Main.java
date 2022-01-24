package ClasesYObjetos;

import java.util.Scanner;

public class Main {

	public static void main(String [] args) {
		//declarando el scanner para que sea posible leer los datos
		Scanner entrada = new Scanner(System.in); 
		
		int n1;
		int n2;
		
		//pide los numeros al usuario
		System.out.println("Ingrese un número: ");
		n1= entrada.nextInt();
		System.out.println("Ingrese otro número: ");
		n2= entrada.nextInt();
		
		//crea el objeto
		Operacion op = new Operacion();
		
		//atribui valores a los metodos
		op.sumar(n1, n2); 
		op.restar(n1, n2);
		op.multiplicar(n1, n2);
		op.division(n1, n2);
		
		op.resultados();
		
	}
	
}
