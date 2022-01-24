import java.util.Scanner;
public class UnLaberinto {
	public static void main(String[] args){
		Scanner entrada = new Scanner(System.in);
		int y,x;
		int posX, posY;

//		int[] eneX, eneY; //	Variables del enemigo
		int[] eneX = {5,8,12,14,5,1,1,1};
		int[] eneY = {1,3,5,7,9,1,1,1};

		int numEnemigos = eneX.length;
		int numEnemigo=0;

		boolean hayVampiro = false;

		int minX, minY;
		int maxX, maxY;

		int alcanceAntorcha;

		boolean sinobstaculo=false;
		int mundo=0;

		String orden;
		int terminar=0;	//	Cuando valga 1, terminamos

		posX=2;
		posY=3;


		int eneMov=0;

		x=0;
		y=0;
		alcanceAntorcha = 100;

		int[][]elMundo={
			{0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,2,2},
			{0,1,0,0,0,0,2,2,2,2,2,0,1,0,0,0,0,0,1,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
			{0,1,0,2,2,2,0,0,0,0,2,0,1,0,2,2,2,0,1,0,2,2,2,0,0,0,0,2,0,0,0,0,2,0},
			{0,1,0,0,0,0,0,0,0,0,2,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,2,0,0,0,0,2,0},
			{0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,1,0,1,1,1,1,1,0,0,0,0,1,0,1,1,1,0,1,0,1,1,1,1,1,0,0,0,1,1,0,0,0,0},
			{0,1,0,1,0,0,0,0,0,0,1,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,0,1,0,0,0,0,1,0},
			{0,1,0,1,0,1,1,1,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,1,0,1,1,1,1,0,1,0},
			{0,1,0,1,0,0,0,0,0,0,1,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,0,1,0,0,0,0,1,0},
			{0,1,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0},
			{0,1,0,1,0,0,1,1,0,0,0,0,1,0,1,0,0,0,1,0,1,0,0,1,1,0,0,0,1,1,0,0,0,0},
			{0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,1,0,1,1,1,0,1,0,0,0,0,1,0,1,0,0,0,1,0,1,1,1,0,1,0,1,1,0,1,0,0},
			{0,1,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0},
			{0,1,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0},
			{0,1,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0},
			{0,1,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0},
			{0,1,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1,1,1,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
		};
		int[][]elSegundoMundo={
			{0,0,0,0,0,0,0,0,0,0,2,0,0,0,1,1,1,0,1,1,0,0,0,1,0,0,0,2,0,0,0,0,2,2},
			{0,1,0,0,0,0,2,2,3,2,2,0,1,0,0,0,0,0,1,0,0,0,0,2,2,2,2,2,1,1,1,1,2,2},
			{0,1,0,2,0,2,0,0,0,0,2,0,1,0,2,2,2,0,1,0,2,2,2,0,0,0,0,2,0,0,0,0,2,0},
			{0,1,0,0,0,0,2,3,0,0,2,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,2,0,0,0,2,2,0},
			{0,1,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0},
			{0,1,0,1,0,1,1,1,0,0,0,0,1,0,1,1,1,0,4,0,1,1,1,1,1,0,0,0,1,1,0,0,0,0},
			{0,1,0,1,0,0,0,0,0,0,1,0,3,0,1,0,0,0,4,0,1,0,0,0,0,0,0,1,0,0,2,0,1,0},
			{0,1,0,4,0,1,2,2,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,1,0,1,1,1,1,0,1,0},
			{0,1,0,1,0,0,3,0,0,0,1,0,1,0,3,0,0,0,3,3,1,0,0,0,0,0,0,1,0,0,0,0,1,0},
			{0,1,0,0,0,0,0,0,0,0,1,0,1,0,0,0,3,0,1,0,0,2,0,0,1,0,0,3,0,0,0,0,1,0},
			{0,1,0,1,0,0,1,4,0,0,0,0,1,0,1,0,0,0,4,0,1,0,0,1,1,0,0,0,1,1,0,0,0,0},
			{0,0,0,4,0,1,0,0,0,0,0,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,2,0,0,0,0,0,0,0},
			{0,0,0,1,0,1,3,1,0,1,0,0,0,0,1,0,0,0,0,0,1,0,1,1,1,0,1,0,1,1,0,1,0,0},
			{0,1,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0},
			{0,1,0,0,0,0,0,0,0,2,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0},
			{0,1,0,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0},
			{0,1,0,4,0,0,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0},
			{0,0,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1,1,1,1,0},
			{0,4,4,4,0,0,0,0,0,0,0,0,0,3,0,3,4,4,0,0,4,4,4,2,2,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,4,4,0,0,0,0,0,0,3,3,3,3,3,3,0,0,0,0,0,0,0,0,0,3,3,3,3,0,3,0},
			{0,0,0,0,0,0,2,2,2,0,2,2,0,0,0,0,0,2,0,0,0,0,0,0,0,1,0,0,1,0,1,0,0,0}
		};

		int[][]elPrimerMundo= elMundo;

		minX = 0;										//	Límite mínimo de X
		minY = 0; 									//	Límite mínimo de Y
		maxY = elMundo.length-1;		//	Límite máximo de Y
		maxX = elMundo[0].length-1;	//	Límite máximo de X

			do{
				// Ingreso de orden
				System.out.println("Ingrese comando (w/a/s/d/f/m (muro)/ p (monte)/ g (gema)/ t (teletransporte)/ nm (nuevo mapa)):");
				orden=entrada.nextLine();

				// Cálculo (completo) de nueva posicion (o acción)
				if(orden.equalsIgnoreCase("w"))		{
						if ((posY>minY)&&(elMundo[posY-1][posX]==0)){ posY=posY-1;}
						else if ((posY==minY)&&(elMundo[maxY][posX]==0)) {
							posY=maxY;
						}
					} else
				if(orden.equalsIgnoreCase("s"))		{
						if ((posY<maxY)&&(elMundo[posY+1][posX]==0)){ posY=posY+1;}
						else if ((posY==maxY)&&(elMundo[minY][posX]==0)) {
							posY=minY;
						}
					} else
				if(orden.equalsIgnoreCase("d"))		{
						if ((posX<maxX)&&(elMundo[posY][posX+1]==0)){ posX=posX+1;}
						else if ((posX==maxX)&&(elMundo[posY][minX]==0)) {
							posX=minX;
						}
					} else
				if(orden.equalsIgnoreCase("a"))		{
					if ((posX>minX)&&(elMundo[posY][posX-1]==0)) {posX=posX-1;}
					else if ((posX==minX)&&(elMundo[posY][maxX]==0)) {
						posX=maxX;
					}
				} else

				if(orden.equalsIgnoreCase("f"))		{terminar=1;} else
				if(orden.equalsIgnoreCase("m")) {elMundo[posY][posX]=1;} else 	// Creacion de Muro
				if(orden.equalsIgnoreCase("p")) {elMundo[posY][posX]=2;} else		// Creacion de Monte
				if(orden.equalsIgnoreCase("g")) {alcanceAntorcha=100;}
				else if (orden.equalsIgnoreCase("t")) {
					while(!sinobstaculo){
						posY=(int)(Math.random()* elMundo.length-1);
						posX=(int)(Math.random()* elMundo[posY].length-1);
						if (elMundo[posY][posX]==0) {
							sinobstaculo=true;
						}else {
							posY=(int)(Math.random()* elMundo.length-1);
							posX=(int)(Math.random()* elMundo[posY].length-1);
						}
					} sinobstaculo=false;
				}else if (orden.equalsIgnoreCase("nm")) {
					mundo=mundo+1;
					if (mundo%2==0) {
						elMundo=elPrimerMundo;
					}else {
						elMundo=elSegundoMundo;
					}

				}
				else

				{ System.out.println("Dice Pablo que no te entiende");}
				// Fin del cálculo de nueva posicion

				// INICIO DEL CALCULO DE MOVIMIENTO DEL ENEMIGO

					for (numEnemigo=0;numEnemigo<numEnemigos;numEnemigo=numEnemigo+1) {
						eneMov = (int)(Math.random()*3+1);
						if (eneMov==1 && eneX[numEnemigo]<maxX) {eneX[numEnemigo]=eneX[numEnemigo]+1;} else
						if (eneMov==2 && eneX[numEnemigo]>minX) {eneX[numEnemigo]=eneX[numEnemigo]-1;} else
						if (eneMov==3 && eneY[numEnemigo]<maxY) {eneY[numEnemigo]=eneY[numEnemigo]+1;} else
						if (eneMov==4 && eneY[numEnemigo]>minY) {eneY[numEnemigo]=eneY[numEnemigo]-1;}
					}

				// FIN DEL CALCULO DE MOVIMIENTO


				// Impresion del mapa
				// INICIO DE IMPRESION DEL MAPA
				//	Impresion del borde superior
				for(x=0;x<elMundo[0].length+1;x=x+1){System.out.print("==");}System.out.println("");
				// Impresion del mapa
				for (y = 0; y < elMundo.length; y = y+1){
					System.out.print("|");	// Borde izquierdo
					for (x=0; x<elMundo[y].length; x = x+1){

						if (((x>=posX-alcanceAntorcha)&&(x<=posX+alcanceAntorcha)) && ((y>=posY-alcanceAntorcha)&&(y<=posY+alcanceAntorcha))) {
							// Ve
							// Validar la impresión del vampiro
							hayVampiro=false;
							for (numEnemigo=0;numEnemigo<numEnemigos;numEnemigo=numEnemigo+1) {
								if ((eneX[numEnemigo]==x) && (eneY[numEnemigo]==y)) {
									System.out.print("^^");
									hayVampiro=true;
								}
								if (hayVampiro){break;}
							}

							if (hayVampiro==false) {

							// Si no se imprimio un vampiro, imprimir el resto
								if ((x==posX)&&(y==posY)){
									// Imprimir el personaje
									System.out.print("HM");

								}
								else {
									// Parsear e imprimir el mundo
									if (elMundo[y][x]==0) {System.out.print("  ");} else
									if (elMundo[y][x]==1) {System.out.print("[]");} else
									if (elMundo[y][x]==2) {System.out.print("/\\");} else
									if (elMundo[y][x]==3) {System.out.print("~~");} else
									if (elMundo[y][x]==4) {System.out.print("oO");}
								}

							}

						} else {
							// No ve
							System.out.print("  ");
						}

					}
					System.out.println("|");	// Borde derecho y salto de linea
				}
				// Impresion del borde inferior
				for(x=0;x<elMundo[0].length+1;x=x+1){System.out.print("==");}System.out.println("");
				// FINAL DE IMPRESION DEL MAPA



					//alcanceAntorcha = 3;

			} while (terminar!=1);

	}
}
