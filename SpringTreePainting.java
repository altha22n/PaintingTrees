/**
 * This class is for painting trees in the spring collage
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





 public class SpringTreePainting extends TreePainting {

 	public SpringTreePainting(){
 		//inherits all the methods, functions, etc
 		super();
 	}

 	//we override this method		
	public void paintBackground (Graphics g){
			//set and change the color 
			Color springColor = new Color(102, 204, 255);
			g.setColor(springColor); 
			g.fillRect(0, 0, getWidth(), getHeight() );
			}






 }
