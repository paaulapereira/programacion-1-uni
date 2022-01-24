package Microondas;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MxRoc {
	
	protected ProgramaMicroondas[] _pr_disponibles ;
	private ProgramaMicroondas _pr_activo = new ProgramaMicroondas();
	protected SelectorTiempo _SelectorTiempo = new SelectorTiempo(); //selcionar el tiempo
	protected SelectorPotencia _SelectorPotencia = new SelectorPotencia(); //selcionar la potencia
	protected SelectorGrill _SelectorGrill; //selecionar el grill

	public MxRoc () {
		_pr_disponibles = null;
		_pr_activo = null;
		_SelectorTiempo = null;
		_SelectorPotencia = null;
		_SelectorGrill = null;
	}

	public void ponerEnMarcha () {
		if(_pr_activo!=null) {
			_pr_activo.Activar();
		}
	}


	public void ponerEnFuncion() {
		if(_pr_activo != null) {
			_pr_activo.Activar();
		}
		BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
		String line;
		int opcion=0;
		double tiemp=0;
		int ptw = 0;
		int fg = 0;
		
		//empieza a preguntar que la persona quiere hacer 
		System.out.println("MxRoc");
		System.out.println("Modo de programacion");
		System.out.println("Que quieres hacer?");
		System.out.println("0 - Apagado");
		for(int i=0; i < _pr_disponibles.length; i++) {  //las opciones de cada microondas son impresas
			System.out.println(i+1 + " - " + _pr_disponibles[i].nombre());
		}
		
		System.out.println("");
		
		System.out.println("Seleccion: ");
		do {
			try {
				line = in.readLine();
				opcion = Integer.parseInt (line);
			}
			catch (Exception e){
				System.err.println(e);
			}
		} 
		while( (opcion<0) || (opcion > _pr_disponibles.length) ); 
		
		if(opcion==0) {
			_pr_activo = null;
		} else {
			_pr_activo = _pr_disponibles[opcion -1];
		}
		if (_SelectorTiempo!=null && _SelectorTiempo.tiempo()==0) { 
		
			do {
				try {
					System.out.println("Seleccione el tiempo: ");
						System.out.println("Obs: Mínimo(0.5), Máximo(90)");
						System.out.println("Seleccionar en intervalos de 0.5 minutos");
					
					line = in.readLine();
					tiemp = Double.parseDouble (line);
				}
				catch (Exception e) {
				System.err.println(e);	
				}
			} 
			while ( (tiemp<0.5) || (tiemp > _SelectorTiempo.tiempoMaximo() ) ); //mientras algunas de esas opciones no se cumple, eso pasa.
			
			_SelectorTiempo.fijarTiempo(tiemp);
		}

		if(_SelectorPotencia != null && _SelectorPotencia.potencias()==0 ) {
			do {
				try {
					System.out.println("Potencia: ");
					System.out.println("Selecione una potencia en intervalos de 100W (min=100, max=900)");
					line = in.readLine();
					ptw = Integer.parseInt(line);
				}
				catch(Exception e) {
					System.err.println(e);
				}
			}
			while((ptw<_SelectorPotencia.minimaPotencia()) || (ptw>_SelectorPotencia.maximaPotencia()));
			_SelectorPotencia.fijarPotencia(ptw);
		}
		if(_SelectorGrill !=null) {
			do {
				try {
					System.out.println("Grill: ");
					System.out.println("Opcciones: 0, 1, 2, 3");
					line = in.readLine();
					fg = Integer.parseInt(line);
				}
				catch(Exception e) {
					System.err.println(e);
				}
			}
			while((fg<_SelectorGrill.minGrill()) || (fg>_SelectorGrill.maxGrill()));
			_SelectorGrill.fijarGrill(fg);
		}
	}

	public void infoPrograma() {
		if(_pr_activo == null) {
			System.out.println("Seleccione un programa válido");
		} else {
			System.out.println("Programa: " + _pr_activo.nombre() + " ");
			System.out.print("Tiempo: ");
			if(_SelectorTiempo!=null) {
				System.out.println(_SelectorTiempo.tiempo() + " " + "min");
			} else {
				System.out.println("0");
			}
			System.out.print("Potencia: ");
			if(_SelectorPotencia != null) {
				System.out.println(_SelectorPotencia.potencias() + " " + "W");
			} else {
				System.out.println("0");
			}
			System.out.print("Grill: ");
			if(_SelectorGrill!= null) {
				System.out.println(_SelectorGrill.grilling() + " ");
			} else {
				System.out.println("0");
			}
			//imprime el los datos de duración y tiempo, cuanto queda.
			System.out.println();
			System.out.println("Duracion: " + _pr_activo.duracion() + " , ");
			System.out.println("Potencia: " + _pr_activo.potencia() + "W.");
		}
		
	}

}
