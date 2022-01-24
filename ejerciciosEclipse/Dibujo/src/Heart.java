import java.awt.Color;
import java.awt.Graphics;

public class Heart implements Figura{
	Color color;
	boolean relleno;
	int x1,y1,x2,y2;
	int anchura, altura;
	Heart(int x1,int y1,int x2,int y2,Color c,boolean fill){
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
		color = c;
		relleno = fill;
		procesaPuntos();		
	}
	public void pinta(Graphics g){
		g.setColor(color);	

		int[] triangleX = {
	            x1 - 2*anchura/18,
	            x1 + anchura + 2*anchura/18,
	            (x1 - 2*anchura/18 + x1 + anchura + 2*anchura/18)/2};
	    int[] triangleY = { 
	            y2 + altura - 2*altura/3, 
	            y2 + altura - 2*altura/3, 
	            y2 + altura };
	    
		if(!relleno) {
			g.drawOval(
		            x1 - anchura/12,
		            y2, 
		            anchura/2 + anchura/6, 
		            altura/2); 
		    g.drawOval(
		            x1 + anchura/2 - anchura/12,
		            y2,
		            anchura/2 + anchura/6,
		            altura/2);
		    g.drawPolygon(triangleX, triangleY, triangleX.length);
		}
				
		else {
			g.fillOval(
		            x1 - anchura/12,
		            y2, 
		            anchura/2 + anchura/6, 
		            altura/2); 
		    g.fillOval(
		            x1 + anchura/2 - anchura/12,
		            y2,
		            anchura/2 + anchura/6,
		            altura/2);
		    g.fillPolygon(triangleX, triangleY, triangleX.length);	
		}
	}
	
	private void procesaPuntos(){
		if(x1<x2 & y1<y2){
			anchura = x2-x1;
			altura = y2-y1;
		}
		else{
			if(x1<x2 & y1>y2){
				anchura = x2 - x1;
				altura = y1-y2;
				this.y1 = y1-altura;
			}
			else
				if(x1>x2 & y1<y2){
					anchura =x1-x2;
					altura = y2-y1;
					this.x1=x1-anchura;
				}
				else{
					anchura=x1-x2;
					altura=y1-y2;
					this.x1=x1-anchura;	
					this.y1=y1-altura;
				}
		}
		
	}
}
