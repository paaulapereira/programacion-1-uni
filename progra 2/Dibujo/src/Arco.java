import java.awt.Color;
import java.awt.Graphics;

public class Arco implements Figura{
	Color color;
	boolean relleno;
	int x1,y1,x2,y2;
	int anchura, altura;
	int angle1, angle2;
	Arco(int x1,int y1,int x2,int y2,Color c,boolean fill){
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
		color = c;
		relleno = fill;	
		

	}
	public void pinta(Graphics g){
		g.setColor(color);
				
		if(!relleno)
			g.drawArc(x1,y1,x2,y2, 45, 60);		
		else
			g.fillArc(x1,y1,x2,y2, 45, 60);		
	}
	
	
}
