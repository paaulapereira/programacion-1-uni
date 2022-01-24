import java.util.Scanner;

public class heroeVsVampiresa{

  public static void main(String[] args){

    Scanner entrada = new Scanner(System.in);

    double energiaHeroina=100;
    double energiaVampiresa=65;
    boolean alguienMuere=false;
    double probabilidadAciertoHeroina=0.4;
    int ataqueVampiresa=10;
    int ataqueHeroina=15;
    double probabilidadAciertoVampiresa=0.7;
    int pocimaSalud=3;
    boolean modoBerseker=false;
    int comboHeroina=0;
    int queHacerVampiresa, queHacerHeroina, dadoAtaqueVampiresa, dadoAtaqueHeroina, dadoEsquivarHeroina, dadoEsquivarVampiresa;
    double nuevaProbabilidadAciertoVampiresa=0.2;
    double nuevaProbabilidadAciertoHeroina=0.15;

    System.out.println("Empieza una batalla épica entre las fuerzas del bien y del mal...");

    do {

      System.out.println("La vampiresa tiene "+energiaVampiresa +"de energia");
      System.out.println("La heroina tiene "+energiaHeroina +"de energia");
      System.out.println("TURNO DE LA VAMPIRESA");
      System.out.println("Quieres:");
      System.out.println("1.Atacar");
      System.out.println("2.Defender");
      System.out.println("3.Esquivar");
      queHacerVampiresa= entrada.nextInt();
      System.out.println("TURNO DE LA HEROINA");
      System.out.println("Quieres:");
      System.out.println("1.Atacar");
      System.out.println("2.Defender");
      System.out.println("3.Esquivar");
      queHacerHeroina= entrada.nextInt();
      //turno de la vampiresa
      if (energiaVampiresa>0) {
        //activando el modo berseker
        if ((energiaVampiresa <=16.25) && (modoBerseker == false)) {
          probabilidadAciertoVampiresa=0.35;
          ataqueVampiresa=20;
          modoBerseker=true;
          System.out.println("Se ha activado el modo berseker");
        }
        if (queHacerVampiresa ==1) {
          dadoAtaqueVampiresa= (int)(Math.random()*(10-1)+1);
          dadoEsquivarHeroina= (int)(Math.random()*(10-1)+1);
          if ((queHacerHeroina==3) && (dadoEsquivarHeroina>5)) {
            System.out.println("La heroina ha esquivado el ataque!");
          }else {
            if (queHacerHeroina ==2) {
              if (dadoAtaqueVampiresa >=6) {
                energiaHeroina = energiaHeroina - (ataqueVampiresa*probabilidadAciertoVampiresa)/2;
                System.out.println("La vampiresa ataca la heroina con alta efectividad, pero la heroina se defiende :)");
              }else if (dadoAtaqueVampiresa==5) {
                energiaHeroina = energiaHeroina - (ataqueVampiresa*nuevaProbabilidadAciertoVampiresa)/2;
                System.out.println("La vampiresa ataca la heroina, pero fue muy debil y ella defendio");
              }else{
                System.out.println("La vampiresa falla el ataque");
              }
            }else {
              if (dadoAtaqueVampiresa >=6) {
                energiaHeroina = energiaHeroina - (ataqueVampiresa*probabilidadAciertoVampiresa);
                System.out.println("La vampiresa ataca la heroina con alta efectividad :(");
              }else if (dadoAtaqueVampiresa==5) {
                energiaHeroina = energiaHeroina - (ataqueVampiresa*nuevaProbabilidadAciertoVampiresa);
                System.out.println("La vampiresa ataca la heroina, pero fue muy debil");
              }else{
                System.out.println("La vampiresa falla el ataque");
              }
            }
          }
        }
      }
      // turno de la heroina
      if (energiaHeroina>0) {
        if ((energiaHeroina <= 30) && (pocimaSalud>0)) {
          energiaHeroina = energiaHeroina+ (energiaHeroina*0.3);
          pocimaSalud = pocimaSalud-1;
          System.out.println("La heroina ha utilizado una pocion de salud y gano mas energia :)");
        }else{
          if (queHacerHeroina == 1) {
            dadoEsquivarVampiresa = (int)(Math.random()*(10-1)+1);
            dadoAtaqueHeroina = (int)(Math.random()*(15-1)+1);
            if ((queHacerVampiresa == 3) && (dadoEsquivarVampiresa > 5)) {
              System.out.println("La vampiresa ha esquivado el ataque!");
              comboHeroina =0;
            }else{
              if (queHacerVampiresa == 2) {
                if (dadoAtaqueHeroina >= 10) {
                  energiaVampiresa = energiaVampiresa - (ataqueHeroina*probabilidadAciertoHeroina)/2;
                  System.out.println("La heroina ataca la vampiresa con alta efectividad, pero la vampiresa se defiende!");
                  comboHeroina = comboHeroina+1;
                  if (comboHeroina >= 3) {
                    energiaVampiresa = energiaVampiresa - (ataqueHeroina*probabilidadAciertoHeroina)/2;
                    System.out.println("Despues de 3 ataques seguidos el combo fue activado- EL ATAQUE SE HA DUPLICADO!");
                    comboHeroina=0;
                  }
                }else if (dadoAtaqueHeroina == 9) {
                  energiaVampiresa = energiaVampiresa - (ataqueHeroina*nuevaProbabilidadAciertoHeroina)/2;
                  System.out.println("La heroina ataca la vampiresa, pero fue muy debil y la vampiresa se defendio");
                  comboHeroina = comboHeroina+1;
                  if (comboHeroina >= 3) {
                    energiaVampiresa = energiaVampiresa - (ataqueHeroina*nuevaProbabilidadAciertoHeroina)/2;
                    System.out.println("Despues de 3 ataques seguidos el combo fue activado- EL ATAQUE SE HA DUPLICADO!");
                    comboHeroina=0;
                }
              }else {
                System.out.println("La heroina falla el ataque");
                comboHeroina=0;
              }
            }else {
              if (dadoAtaqueHeroina >=10) {
                energiaVampiresa= energiaVampiresa- (ataqueHeroina*probabilidadAciertoHeroina);
                System.out.println("La heroina ataca la vampiresa con alta efectividad");
                comboHeroina= comboHeroina+1;
                if (comboHeroina >= 3) {
                  energiaVampiresa = energiaVampiresa - (ataqueHeroina*probabilidadAciertoHeroina);
                  System.out.println("Despues de 3 ataques sequidos el combo fue activado- EL ATAQUE SE HA DUPLICADO!");
                  comboHeroina =0;
                }
              }else if (dadoAtaqueHeroina >=0) {
                energiaVampiresa= energiaVampiresa - (ataqueHeroina*nuevaProbabilidadAciertoHeroina);
                System.out.println("La heroina ataca la vampiresa, pero fue muy debil");
                comboHeroina = comboHeroina + 1;
                if (comboHeroina >=3) {
                  energiaVampiresa = energiaVampiresa - (ataqueHeroina*nuevaProbabilidadAciertoHeroina);
                  System.out.println("Despues de 3 ataques sequidos el combo fue activado- EL ATAQUE SE HA DUPLICADO!");
                  comboHeroina=0;
                }
              }else {
                System.out.println("La heroina falla el ataque");
                comboHeroina= 0;
              }
            }
          }
        }
      }
    }

    if ((energiaHeroina <= 0) || (energiaVampiresa <= 0) ) {
      alguienMuere= true;

      if (energiaHeroina <= 0) {
        System.out.println("The Evil has won :(");
        break;
      }
      if (energiaVampiresa <=0) {
        System.out.println("Muertos no pueden moverse y el mundo esta a salvo!");
        break;
      }
    }

  }while (alguienMuere==false);
  System.out.println("La batalla se ha terminado");
}
}
