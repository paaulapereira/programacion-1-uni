import java.util.Scanner;

public class simulacionColas{

  public static void main(String[] args){

    Scanner entrada = new Scanner(System.in);

    int laCola;
    int elMinuto;
    int caja1, caja2, caja3, caja4;
    int i;

    String pausaParaLeer;

    laCola=0;
    caja1=0;
    caja2=0;
    caja3=0;
    caja4=0;

    //El for simula el tiempo
    for(elMinuto=1; elMinuto<=720; elMinuto=elMinuto + 1){


    System.out.println("Minuto "+elMinuto);

    //Analisis de llegada de gente a la cola
    if(Math.random()<=0.4){
    laCola=laCola+1;
    System.out.println("Llego una persona");
    }

    //Paso a cajas(si es que se puede)
    if((laCola>=1) && (caja1==0)){
    laCola = laCola - 1;        //Resto una persona de la cola
    caja1 = (int)(Math.random()*10)+5;   //Calculo los items que trae la persona a caja
    System.out.println("Entra una persona a la caja 1 con "+caja1+" items");
    }

    if((laCola>=1) && (caja2==0)){
    laCola = laCola - 1;        //Resto una persona de la cola
    caja2 = (int)(Math.random()*10)+5;   //Calculo los items que trae la persona a caja
    System.out.println("Entra una persona a la caja 2 con "+caja2+" items");
    }

    if((laCola>=1) && (caja3==0)){
    laCola = laCola - 1;        //Resto una persona de la cola
    caja3 = (int)(Math.random()*10)+5;   //Calculo los items que trae la persona a caja
    System.out.println("Entra una persona a la caja 3 con "+caja3+" items");
    }

    if((laCola>=1) && (caja4==0)){
    laCola = laCola - 1;        //Resto una persona de la cola
    caja4 = (int)(Math.random()*10)+5;   //Calculo los items que trae la persona a caja
    System.out.println("Entra una persona a la caja 4 con "+caja4+" items");
    }

    //Fin de paso a cajas

    //Simulacion de la atencion al cliente

    if(caja1>0) {
    caja1=caja1-1;
    System.out.println("Caja 1:");
    for(i=0;i<=caja1;i=i+1){System.out.println("[]");}
    }
    if(caja2>0) {caja2= caja2-1; System.out.println("Caja 2: "+caja2);}
    if(caja3>0) {caja3=caja3-1; System.out.println("Caja 3: "+caja3);}
    if(caja4>0) {caja4=caja4-1; System.out.println("Caja 4: "+caja4);}

    System.out.println("La cola es: " +laCola);
    pausaParaLeer = entrada.nextLine();
    }

  }

}
