/**
 * This class is for painting trees in the winter collage
 * It extends JComponent and implements MouseListener
 *
 * @author Nada Al-Thawr
 * @date 09/21/16
 *
 */
 import java.awt.Color;
 import java.awt.Graphics;
 import java.awt.Graphics2D; // optional, for drawing lines with varying thickness
 import java.awt.BasicStroke; // optional, for drawing lines with varying thickness
 import java.awt.event.MouseEvent;
 import java.awt.event.MouseListener;
 import java.awt.geom.Point2D;
 import javax.swing.JComponent;
 import java.awt.Stroke;
 import java.awt.geom.Line2D;
 import java.awt.geom.*;
 import javax.swing.*;
 import java.awt.*;





 public class SummerTreePainting extends TreePainting {

 	public SummerTreePainting(){
 		//inherits all the mothods, functions..etc
 		super();
 	}

	
	public void paintBackground (Graphics g){
			//create colors
			Color summerColor = new Color (102, 153, 255);
			Color grassColor = new Color (0, 255, 0);
			//set the summer color
			g.setColor(summerColor); 
			g.fillRect(0, 0, getWidth(), getHeight() );
			//create a sun and set the color
			g.setColor(Color.yellow);
			g.fillOval (20, 20, 40, 40);
			//create the grass and set the color
			g.setColor (grassColor);
			g.fillRect (0, 320, getWidth(), 350);

			
			}






 }
