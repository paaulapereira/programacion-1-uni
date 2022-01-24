package ClasesYObjetos;


public class Operacion {
	//atributos
		int suma;
		int resta;
		int multiplicacion;
		double division;
		
		
		//Metodos
		
		
		//Método para sumar los numeros
		public void sumar(int numero1, int numero2) {
			suma = numero1+numero2;
		}
		
		//Método para restar los numeros
		public void restar(int numero1, int numero2) {
			resta = numero1-numero2;
		}
		
		//Método para multiplicar los numeros
		public void multiplicar(int numero1, int numero2) {
			multiplicacion = numero1*numero2;
		}
		
		//metodo para dividir los numeros
		public void division(int numero1, int numero2) {
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
