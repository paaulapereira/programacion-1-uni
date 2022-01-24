import java.util.Scanner;
import java.math.BigDecimal;

public class CajaChica{

  public static void main(String[] args) {

    Scanner entrada = new Scanner(System.in);

    double precio =0, valorPago =0;
    int billete500 = 0, billete200 = 0, billete100 = 0, billete50 = 0, billete20 = 0, billete10 = 0, billete5 = 0, moneda2 = 0, moneda1 = 0, moneda50c = 0, moneda20c = 0, moneda10c =0, moneda5c = 0, moneda2c = 0, moneda1c = 0;

     System.out.println("Ingrese el precio a pagar:");
     precio= entrada.nextDouble();
     System.out.println("Ingrese el valor pago:");
     valorPago= entrada.nextDouble();
     valorPago=valorPago-precio;
     System.out.printf("El cambio a devolver es: %.2f",valorPago);
     System.out.println();


     if (valorPago >= 500) {
       billete500 = (int)(valorPago/500);
       valorPago = valorPago%500;
     }
     if (valorPago >= 200) {
       billete200 = (int)(valorPago/200);
       valorPago = valorPago%200;
     }
     if (valorPago >= 100) {
       billete100 = (int)(valorPago/100);
       valorPago = valorPago%100;
     }
     if (valorPago >= 50) {
       billete50 = (int)(valorPago/50);
       valorPago = valorPago%50;
     }
     if (valorPago >= 20) {
       billete20 = (int)(valorPago/20);
       valorPago = valorPago%20;
     }
     if (valorPago >= 10) {
       billete10 = (int)(valorPago/10);
       valorPago = valorPago%10;
     }
     if (valorPago >= 5) {
       billete5 = (int)(valorPago/5);
       valorPago = valorPago%5;
     }
     if (valorPago >= 2) {
       moneda2 = (int)(valorPago/2);
       valorPago = valorPago%2;
     }
     if (valorPago >= 1) {
       moneda1 = (int)(valorPago/1);
       valorPago = valorPago%1;
     }
     if (valorPago >= 0.5) {
       moneda50c = (int)(valorPago/0.5);
       valorPago = valorPago%0.5;
     }
     if (valorPago >= 0.2) {
       moneda20c = (int)(valorPago/0.2);
       valorPago = valorPago%0.2;
     }
     if (valorPago >= 0.1) {
       moneda10c = (int)(valorPago/0.1);
       valorPago = valorPago%0.1;
     }
     BigDecimal valorPago2 = new BigDecimal(valorPago);
     valorPago = (valorPago2.setScale(2,BigDecimal.ROUND_HALF_UP)).doubleValue();
     if (valorPago >= 0.05) {
       moneda5c = (int)(valorPago/0.05);
       valorPago = valorPago%0.05;
     }
     if (valorPago >= 0.02) {
       moneda2c = (int)(valorPago/0.02);
       valorPago = valorPago%0.02;
     }
     if (valorPago >= 0.01) {
       moneda1c = (int)(valorPago/0.01);
       valorPago = valorPago%0.01;
     }

     System.out.println(billete500+" Billete(s) de 500");
     System.out.println(billete200+" Billete(s) de 200");
     System.out.println(billete100+" Billete(s) de 100");
     System.out.println(billete50+" Billete(s) de 50");
     System.out.println(billete20+" Billete(s) de 20");
     System.out.println(billete10+" Billete(s) de 10");
     System.out.println(billete5+" Billete(s) de 5");
     System.out.println(moneda2+" Moneda(s) de 2");
     System.out.println(moneda1+" Moneda(s) de 1");
     System.out.println(moneda50c+" Moneda(s) de 50 centimos");
     System.out.println(moneda2c+" Moneda(s) de 20 centimos");
     System.out.println(moneda10c+" Moneda(s) de 10 centimos");
     System.out.println(moneda5c+" Moneda(s) de 5 centimos");
     System.out.println(moneda2c+" Moneda(s) de 2 centimos");
     System.out.println(moneda1c+" Moneda(s) de 1 centimos");


  }
}
