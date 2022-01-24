package ClasesYObjetos;

import javax.swing.JOptionPane;

public class Operacion {
	//atributos
	int numero1;
	int numero2;
	int suma;
	int resta;
	int multiplicacion;
	int division;
	
	
	//Metodos
	
	//metodo para pedir al usuario que nos digite dos números
	
	public void leerNumeros() {
		numero1 = Integer.parseInt(JOptionPane.showInputDialog("Digite un número:"));
		numero2 = Integer.parseInt(JOptionPane.showInputDialog("Digite otro número:"));
	}
	
	//metodo para sumar los numeros
	public void sumar() {
		suma = numero1+numero2;
	}
	
	//metodo para restar los numeros
	public void restar() {
		resta = numero1-numero2;
	}
	
	//metodo para multiplicar los numeros
	public void multiplicar() {
		multiplicacion = numero1*numero2;
	}
	
	//metodo para dividir los numeros
	public void division() {
		division = numero1/numero2;
	}
	
	//metodo para mostrar resultados
	public void resultados() {
		System.out.println("La suma es: "+suma);
		System.out.println("La resta es: "+resta);
		System.out.println("La multiplicacion es: "+multiplicacion);
		System.out.println("La division es: "+division);
	}
	
	
}
