import java.util.Scanner;

public class ejemploPromedio {

  public static void main (String[] args){

    Scanner entrada = new Scanner(System.in);

    double miNumero1;
    double miNumero2;
    double elPromedio;

    System.out.println ("Ingresa el primer numero");
    miNumero1 = entrada.nextDouble();

    System.out.println("Ingresa el segundo numero:");
    miNumero2 = entrada.nextDouble();


    elPromedio = (miNumero1 + miNumero2)/2;
    System.out.println("El promedio de ambos es: " + elPromedio);


  }
}
