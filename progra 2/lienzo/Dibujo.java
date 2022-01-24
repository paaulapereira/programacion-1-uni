import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.util.*;

public class Dibujo extends Frame {
   // Para almacenar las diferentes figuras que se van mostrando
   private Vector figs = new Vector();
   
   // List para ofrecer diferentes figuras
   private List listaFiguras;

   // Checkbox para seleccionar figura rellena o no
   private Checkbox  relleno;

   // List para ofrecer diferentes colores
   private List listaColores;

   // Boton para deshacer (de forma indefinida)
   private Button deshacer;

   // HashMap para almacenar la informacion seleccionada por el usuario
   private HashMap informacion = new HashMap();

   // Lienzo es un Panel donde dibujar
   private Lienzo lienzo;
   

   // Clase Lienzo donde se mostraran las figuras
   class Lienzo extends Panel{
	   
	   public Lienzo(){
		   super();
	   }
      // Ocultamos paint(Graphics g) de la clase Panel
      public void paint(Graphics g){         
         // Si hay figuras en el Vector lo recorremos y las vamos pintando         
         if (figs.size()>0)
            for (int i=0; i<figs.size(); i++)
                  ((Figura)figs.get(i)).pinta(g);
      }      
      // Metodo que crea una nueva figura a partir de la información que 
      // contiene el HashMap y de las coordenadas que se pasan, 
      // almacena la figura en el Vector y repinta el Lienzo
      public void dibuja(int x1,int y1,int x2,int y2) {  
    	  Color color;
    	  String tf =(String)informacion.get("TipoFigura");
    	  String r = (String)informacion.get("Relleno");
    	  String c = (String)informacion.get("Color");
    	  if(tf!=null & r!=null & c!=null){    		  
    		  if(c.equals("Rojo"))
    			  color=new Color(255,0,0);
    		  else
    			  if(c.equals("Verde"))
    				  color=new Color(0,255,0);
    			  else
    				  color=new Color(0,0,255);
    		  
    		  if(tf.equals("Rectangulo"))
    			  figs.add(new Rectangulo(x1,y1,x2,y2,color,r.equals("si")));
    		  else
    			  figs.add(new Elipse(x1,y1,x2,y2,color,r.equals("si")));      		 
    	 }
    	 this.repaint();
      }
      
   }
   
   // Clase para tratar los eventos del tipo ItemEvent
   class TrataEventosItem implements ItemListener {
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() instanceof Checkbox){			
			informacion.remove("Relleno");
			if(e.getStateChange()== ItemEvent.SELECTED)
				informacion.put("Relleno","si");
			else
				informacion.put("Relleno","no");
		}
		else{
			List a =(List)e.getSource();
			String selec = a.getSelectedItem();
			if(a==listaColores){				
				informacion.remove("Color");
				informacion.put("Color", selec);				
			}
			else{				
				informacion.remove("TipoFigura");
				informacion.put("TipoFigura", selec);
			}
		}
		
	}
	   
   }

   // Clase para tratar los eventos del tipo MouseEvent sobre el boton
   class TrataEventosRatonBotonBoton extends MouseAdapter {
  		public void mouseClicked(MouseEvent e){
  			if(figs.size() >0){
  	  			figs.remove(figs.size()-1);
  	  			lienzo.repaint();
  	  		}
  		}	 

   }
  
   // Clase para tratar los eventos del tipo MouseEvent sobre el Lienzo
   // Se deben implementar mousePressed y mouseReleased
   class TrataEventosRatonBotonLienzo extends MouseAdapter { 
      //Atributos
	   private int x1,y1,x2,y2;	   
	   public void mousePressed(MouseEvent e){
		   x1=e.getX();
		   y1=e.getY();		   
	   }
	   public void 	mouseReleased(MouseEvent e){
		   x2=e.getX();
		   y2=e.getY();
		   lienzo.dibuja(x1, y1, x2, y2);
	   }
   } 
   
   class TrataEventosCierre extends WindowAdapter{
       public void windowClosing(WindowEvent e){
           System.exit(0);
        }
   }
   // Constructor 
   public Dibujo() { 
      
      informacion.put("TipoFigura","Elipse");
      informacion.put("Color","Rojo");
      informacion.put("Relleno","no");

   //Creacion del lienzo y de los paneles con los componentes
      //Gestor de organización de la ventana
      setLayout(new BorderLayout());
      
      //Paneles
      Panel panelOpciones = new Panel();
      Panel panelFiguras = new Panel();
      Panel panelColores = new Panel();
      //
      lienzo = new Lienzo();
      
      //Boton
      deshacer = new Button("Deshacer");
      //Listas
      listaFiguras = new List();
      listaFiguras.setMultipleMode(false);
      listaFiguras.add("Elipse");
      listaFiguras.add("Rectangulo");
      
      listaColores = new List();
      listaColores.setMultipleMode(false);
      listaColores.add("Rojo");
      listaColores.add("Verde");
      listaColores.add("Azul");
      
      //Checkbox
      relleno = new Checkbox("Relleno");
      
      //Gestor de organización de los paneles
      panelFiguras.setLayout(new FlowLayout());
      panelFiguras.add(new Label("Tipo Figura"));
      panelFiguras.add(listaFiguras);
      
      panelColores.setLayout(new FlowLayout());
      panelColores.add(new Label("Color"));
      panelColores.add(listaColores);
      
      panelOpciones.setLayout(new GridLayout(4,1));
      panelOpciones.add(panelFiguras);
      panelOpciones.add(relleno);
      panelOpciones.add(panelColores);
      panelOpciones.add(deshacer);
      
   //Registro de auditores de eventos
      TrataEventosItem tei = new TrataEventosItem();
      listaFiguras.addItemListener(tei);
      listaColores.addItemListener(tei);
      relleno.addItemListener(tei);
      deshacer.addMouseListener(new TrataEventosRatonBotonBoton());
      lienzo.addMouseListener(new TrataEventosRatonBotonLienzo());
      this.addWindowListener(new TrataEventosCierre());
      //Añadimos a la ventana el Lienzo y el panel de opciones 
      this.add(lienzo,BorderLayout.CENTER);
      this.add(panelOpciones,BorderLayout.EAST);
      setSize(800,500);      
      setVisible(true);      
   }
   
   public static void main(String[] args) {
      new Dibujo();
   }
}
