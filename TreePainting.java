 /**
 * This class is for tree painting
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
 import java.util.Random;





 public class TreePainting extends JComponent implements MouseListener {

	/** Number of branches **/
	public static final int NUM_BRANCHES = 8; 
 
	/** Diameter of the blossoms. **/
	public static final int BLOSSOM_DIAM = 25;
 
	/** Golden ratio makes the trunk length:branch length ratio aesthetically appealing **/
	public static final double GOLDEN_RATIO = 1.618;


	//set all our variables here
	public int firstX;
	public int secondX;
	public int firstY;
	public int secondY;
	public double x;
	public double y;
	public int angle;
	public boolean press;
	public boolean release;


	public TreePainting()                                                                                                                                                  
	{
	 	//for the mouse listener
		 addMouseListener(this);

	}
        public void paint( Graphics g )
	{
            //paint the background
            paintBackground (g);
            //set boolean to press and release so it doesn't paint until we click and release
            if (press == true && release == true){
            //call the draw trunk and drawbrunch method
            drawTrunk(g);
            drawBranches(g);
        }

        /**
        * These down here are my older attempts of starting to code here
        *
        */
			//g.FilledRect;
			//g.paintBackground(Color.BLACK);
 			//g.FilledRect(Color.BLACK);
 			//setBackground ( Color.BLACK);
            // if user has pressed and released mouse, paint tree
            // ...
            //g.setColor(Color.white);
            //g.drawLine( firstX, firstY, secondX, secondY);

    }
    	//our paintbackground method
		protected void paintBackground (Graphics g){

			//create the background and color it
			g.fillRect(0, 0, getWidth(), getHeight() );
			g.setColor(Color.black); 
			}

		//our draw trunk method	
		public void drawTrunk ( Graphics g) {
			//create our graphics object
			Graphics2D gTrunk = (Graphics2D ) g;
			//create a color and set it
			Color trunkColor = new Color(0, 153, 51);
			gTrunk.setColor(trunkColor);
            //change the thickness to 7
            gTrunk.setStroke(new BasicStroke(7));
            //then we draw our line with the coordinates that we got from our mouse listener methods below
            gTrunk.drawLine(firstX, firstY, secondX, secondY);

        }

        public void drawBranches ( Graphics g) {
        	/**
        	* Here, I tried to generate random angles but then I decided to 
        	* set a fixed constant for an angle 
        	*/
        	//angle = ((int)(2*3.14)Math.random());
        	//angle = (int)(Math.random()*(3.14));
        	//set a fixed angle 
        	angle = 15;
        	//Branch graphic object
			Graphics2D gBranch = (Graphics2D ) g;
			//create and set the color of the branch
			Color branchColor = new Color(0, 153, 51);
			gBranch.setColor(branchColor);
			//set the thickness
            gBranch.setStroke(new BasicStroke(7));

            //create a for loop to create 8 branches
            for (int i = 0; i <= NUM_BRANCHES; i++) {
           	//using pythagorus theorem to find out the trunk's length
            //and pretending that the branch in relevance to the trunk are a triangle
            double trunkLength = (int) (Math.sqrt(Math.pow( - firstX,2) + Math.pow(secondY - firstY,2)));
            /**
            * finding out the branch's length by dividing the trunk length/ golden ratio
            * and then using the method given to us in the assignment to compute the branch coordinates
            * (int) was added to convert them to int because I got a lot of lossy conversions errors
            */
           	double branchLength = trunkLength/GOLDEN_RATIO;
           	//multiply the angles by our i
           	int branchCoordX = (int)(secondX + branchLength*Math.cos(angle*i));
   			int branchCoordY = (int)(secondY + branchLength*Math.sin(angle*i));
   			//set the branch color  
   			gBranch.setColor(branchColor);
   			/**
   			* draw our branch using the endpoints of our trunk as the first coordinates
   			* and the points we computed for the angle ratio
   			*/
           	gBranch.drawLine(secondX, secondY, branchCoordX,branchCoordY);
           	//create a random color generator
           	Random rand = new Random();
			float r1 = rand.nextFloat();
			float g1 = rand.nextFloat();
			float b1 = rand.nextFloat();
			//set the branch color again so we can color the blossoms seperately
   			gBranch.setColor(branchColor);
   			//set the color of the blossoms
   			Color randomColor = new Color (r1,g1,b1);
           	gBranch.setColor (randomColor);
           	//Draw the blossoms
           	gBranch.fillOval ((int)(branchCoordX-BLOSSOM_DIAM/2), (int)(branchCoordY-BLOSSOM_DIAM/2), BLOSSOM_DIAM,BLOSSOM_DIAM );
           	/**
   			* Here are some more attempts of comput9ng the points and angles 
   			*/
            //Point2D p = new Point2D.Double( secondX, secondY );
            //Point2D p = new Point2D.Double( x, y );
            //Point2D d = computeEndpoint ( p, 15, angle);
            //g3d.drawLine(x, y, 15, angle);
            //System.out.println(d + "&"+ p);
			}
		


        }	

	 /**
	 * Invoked when the mouse is pressed down. Adds a circle at the current location.
	 * 
	 * @param e the current state of the mouse
	 */
		public void mousePressed(MouseEvent e)
		{		
		//get the coordinates of where the mouse is pressed
		  firstX=e.getX();
    	  firstY=e.getY();
    	 //to test where the mouse presses
    	 System.out.println("mouse pressed at (" + e.getX() + ", " + e.getY() + ")" );
    	 //set press as true
    	 press =true;
    }
    
	/**
	 * Invoked when the mouse is released.
	 * 
	 * @param e the current state of the mouse
	 */
		public void mouseReleased(MouseEvent e)
		{
	      //get the coordinates of where the mouse is releasd	
		  secondX=e.getX();
    	  secondY=e.getY();
    	  //test where the mouse is being released
    	 System.out.println("mouse released at (" + e.getX() + ", " + e.getY() + ")" );
    	 repaint();
    	 //set release as true
    	 release=true;
	}
	  /** 
	 * Compute the point that is length away from point p at the specified angle.
	 * Uses cosine to get the new x coordinate, sine to get the new y coordinate.
	 * I didn't end up using this method, I just used the lines of getting the coordinates
	 */
	public Point2D computeEndpoint( Point2D p, double length, double angle )

	{
		 x = p.getX()+ length*Math.cos(angle);
		 y = p.getY()+ length*Math.sin(angle);
		 //x is cos and y is sin
	    return new Point2D.Double( x , y ); // y is sin
	    //return Math.atan2(x, y);

	}
	
	/**
	 * Invoked when the mouse enters the component.
	 * 
	 * @param e the current state of the mouse
	 */
	 public void mouseEntered(MouseEvent e){}

	/**
	 * Invoked when the mouse leaves the component.
	 * 
	 * @param e the current state of the mouse
	 */
	 public void mouseExited(MouseEvent e){}

	/**
	 * Invoked when the mouse is clicked (pressed down and released).
	 * 
	 * @param e the current state of the mouse
	 */
	 public void mouseClicked(MouseEvent e)
	{
		/** 
		* when the mouse clicked, it increases in side
		*/

	}
	
	}

