/**
 *	Class to create a bouncing ball object.
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Observer;
import java.util.Observable;
import java.util.List;
import java.awt.*;

public class Paddle extends Observable
{
	private JPanel parent;
	private Color color;
	private int xPos;
	private int height;
	private int width;
	
	/**
	 *	Creates a balloon with values passed
	 *	@param col the color of the balloon
	 *	@param x the x coordinate of the balloon
	 *	@param y the y coordinate of the balloon
	 *	@theRadius the radius of the balloon
	 */
	public Paddle(JPanel theParent, Color col, int x, int theWidth, int theHeight)
	{
		parent = theParent;
		color = col;
		xPos=x;
		height=theHeight;
		width=theWidth;
		
	}
	
	/**
	 *	Returns the location of the balloon
	 *	@return returns the location of the balloon
	 */
	public int getX()
	{
		return xPos;
	}
	
	public int getHeight()
	{
		return height;
	}
	/**
	 *	Returns the color of the balloon
	 *	@return returns the color of the balloon
	 */
	public Color getColor()
	{
		return color;
	}
	
	public void setColor(Color theColor)
	{
		color=theColor;
	}
	

	/**
	 *	Changes the location of the balloon
	 *	@param x the new x-coordinate of the balloon
	 *	@param y the new y-coordinate of the balloon
	 */
	public void setX(int x)	
	{
		if(x<width/2)
			xPos=width/2;
		else if(x>parent.getWidth()-(width/2))
			xPos=parent.getWidth()-(width/2);
		else
			xPos=x;
	}
	
	public boolean isInside(int x, int y)
	{
		if(xPos-width/2>x)
			return false;
		if(xPos+width/2<x)
			return false;
		if(parent.getHeight()-height>y)
			return false;
		else
			return true;
	}
	
	public double getDeflection(int x)
	{
		return 1.0 * (x - xPos) * (2.0/width);
	}
	
	/**
	 *	Draws the ball in the given graphics context
	 */
	public void draw(Graphics g)
	{
		int panelHeight = parent.getHeight();
		
		g.setColor(color);
		g.fillRect(xPos-(width/2), panelHeight-height, width, height);
	}
	
	public void move()
	{
		
		setChanged();
		notifyObservers();
	}
	
	/**
	 *	Returns all the information about the balloon
	 *	@return returns a string containing the balloon's color,
	 *			x & y coordinate and radius
	 */
	public String toString()
	{
		return "Color: "+ color + " Location: " + xPos + " Width: " + width+" Height: "+height;
	}
}
