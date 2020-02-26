import java.awt.Color;
import java.awt.Graphics;
import java.awt.color.*;

import javax.swing.JFrame; 

public class  ColorSquares {
	 private static final int WIDTH = 600;
	 private static final int HEIGHT = 600;
	public static final String BLUE = null;
	
	 
	 public void paint(Graphics g) {
	 for(int i = 0 ; i < WIDTH; i++) {
		 for(int j = 0; j< HEIGHT; j ++) {
	
		 g.setColor(randomColor());}
		 g.drawLine(i, j, i, j);
	 }
		}
	 private Color randomColor() {
		// TODO Auto-generated method stub
		return null;
	}
	private void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	 

}
