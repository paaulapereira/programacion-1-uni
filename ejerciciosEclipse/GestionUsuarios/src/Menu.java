
public class Menu {
	
	String opciones[];
	int nOpciones;
    int opcionLibre;
   
    //constructores
    public Menu(String[] opciones, int nOpciones, int opcionLibre) {
		super();
		this.opciones = opciones;
		this.nOpciones = nOpciones;
		this.opcionLibre = opcionLibre;
	}
    
    
    public String[] getOpciones() {
		return opciones;
	}
	public void setOpciones(String[] opciones) {
		this.opciones = opciones;
	}
	public int getnOpciones() {
		return nOpciones;
	}
	public void setnOpciones(int nOpciones) {
		this.nOpciones = nOpciones;
	}
	public int getOpcionLibre() {
		return opcionLibre;
	}
	public void setOpcionLibre(int opcionLibre) {
		this.opcionLibre = opcionLibre;
	}
	

   
}
