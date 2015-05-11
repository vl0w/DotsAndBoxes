package ch.hslu.prg2.dotsandboxes.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.geom.Rectangle2D;

import javafx.scene.input.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import ch.hslu.prg2.dotsandboxes.game.Dot;



public class DotsBoard extends JPanel {
	private int size;
	
	int boarder = 20;
	int distance = 100;
	int radius = 5;

	public DotsBoard(int size) {
		this.size = size;
		setBackground(Color.CYAN);
		setLayout(null);
		drawLines();
		setVisible(true);
	}

	
	private void drawLines(){
		int x,y;
		for (int i=0; i<=size;i++){
			for(int j = 0; j<=size;j++){
				x = boarder+i*distance;
				y = boarder+j*distance;//+scoringBoard.getHeight();
				//xl = xc+radius/2;
				//yl = yc-radius/2;
				LineButton but1 = new LineButton(new Dot(i,j),new Dot(i+1,j));
				LineButton but2 = new LineButton(new Dot(i,j),new Dot(i,j+1));

				if (i<size){
					but1.setBounds(x+radius,y-radius/2,distance-2*radius,radius);
					but1.setVisible(true);
					add(but1);
				}
				if (j<size){
					but2.setBounds(x-radius/2,y+radius,radius,distance-2*radius);
					but2.setVisible(true);
					add(but2);
				}
			}
		}
	}
	
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		int xc,yc,xl,yl;
		for (int i=0; i<=size;i++){
			for(int j = 0; j<=size;j++){
				xc = boarder+i*distance;
				yc = boarder+j*distance;//+scoringBoard.getHeight();
/*				xl = xc-radius/2;
				yl = yc-radius/2;
				if (i<size){
//					drawLines(g,xl,yl,distance,radius,Color.RED);
				}
				if (j<size){
//					drawLines(g,xl,yl,radius,distance,Color.BLUE);
				}
*/				drawCircle(g,xc,yc,radius);
			}
		}

	}
	
	public static void drawCircle(Graphics g, int x, int y, int radius) {
		  int diameter = radius * 2;
		  g.setColor(Color.BLACK);
		  //shift x and y by the radius of the circle in order to correctly center it
		  g.fillOval(x - radius, y - radius, diameter, diameter); 
	}
/*	
	public static void drawLines(Graphics g,int x,int y,int radius,int distance,Color color){
			Rectangle2D rect = new Rectangle2D.Double(x,y,radius,distance);
//			lines.add(rect);
			//g.fillRect(x,y,radius,distance);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(color);
			g2d.fill(rect);
			
	}
*/

}
