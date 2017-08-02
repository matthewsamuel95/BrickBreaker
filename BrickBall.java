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

public class BrickBall extends Observable
{
	private JPanel parent;
	private Color color;
	private Location loc;
	private int radius;
	private int speedX;
	private int speedY;
	public static final int INCREMENT = 2;
	

	/**
	 *	Creates a balloon with values passed
	 *	@param col the color of the balloon
	 *	@param x the x coordinate of the balloon
	 *	@param y the y coordinate of the balloon
	 *	@theRadius the radius of the balloon
	 */
	public BrickBall(JPanel theParent, Color col, int x, int y, int theRadius,int theSpeedX,int theSpeedY)
	{
		parent = theParent;
		color = col;
		loc = new Location(x, y);
		radius = theRadius;
		speedX=theSpeedX;
		speedY=theSpeedY;
	}
	
	/**
	 *	Returns the location of the balloon
	 *	@return returns the location of the balloon
	 */
	public Location getLocation()
	{
		return loc;
	}
	
	/**
	 *	Returns the x-coordinate of the balloon
	 *	@return returns the x-coordinate of the balloon
	 */
	public int getX()
	{
		return loc.getX();
	}
	
	/**
	 *	Returns the y-coordinate of the balloon
	 *	@return returns the y-coordinate of the balloon
	 */
	public int getY()
	{
		return loc.getY();
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
	 *	Returns the radius of the balloon
	 *	@return returns the radius  of the balloon
	 */
	public int getRadius()
	{
		return radius;
	}
	
	/**
	 *	Returns the diameter of the balloon
	 *	@return returns the diameter  of the balloon
	 */
	public int getDiameter()
	{
		return 2 * radius;
	}
	
	/**
	 *	Changes the location of the balloon
	 *	@param x the new x-coordinate of the balloon
	 *	@param y the new y-coordinate of the balloon
	 */
	public void setLocation(int x, int y)	
	{
		loc.setX(x);
		loc.setY(y);
	}
	
	/**
	 *	Changes the x-coordinate of the balloon
	 *	@param x the new x-coordinate of the balloon
	 */
	public void setX(int x)
	{
		loc.setX(x);
	}
	
	/**
	 *	Changes the y-coordinate of the balloon
	 *	@param y the new y-coordinate of the balloon
	 */
	public void setY(int y)
	{
		loc.setY(y);
	}
	
	/**
	 *	Draws the ball in the given graphics context
	 */
	public void draw(Graphics g)
	{
		g.setColor(color);
		g.fillOval(getX(), getY(), getDiameter(), getDiameter());
	}
	
	public void move()
	{
		int width = parent.getWidth();
		setX(getX()+speedX);
		if(width<getX()+getDiameter())
		{
			setX(width-getDiameter());
			speedX=-(Math.abs(speedX));
		}
		else if(getX()<0)
		{
			setX(0);
			speedX=Math.abs(speedX);
		}
		
		int height = parent.getHeight();
		setY(getY()+speedY);
		
		if(getY()<0)
		{
			setY(0);
			speedY=Math.abs(speedY);
		}
				
		setChanged();
		notifyObservers();
	}
	
	public void incSpeed()
	{
		if (speedX == 0)
			speedX = 5;
		else
			speedX += 5 * Integer.signum(speedX);
	}
	
	public void decSpeed()
	{
		if (Math.abs(speedX) > 0)
			speedX -= 5 * Integer.signum(speedX);
	}

	public void incSpeedY()
	{
		speedY += 2 * Integer.signum(speedY);		
	}
	
	public void setSpeedX(int x)
	{
		speedX=x;
	}
	
	public void setSpeedY(int y)
	{
		speedY=y;
	}
	
	public void setSpeedXSign(int x)
	{
		if(x<0)
			speedX=-(Math.abs(speedX));
		else if(x>0)
			speedX=Math.abs(speedX);
	}
	
	public void setSpeedYSign(int y)
	{
		if(y<0)
			speedY=-(Math.abs(speedY));
		else if(y>0)
			speedY=Math.abs(speedY);
	}
	
	public void deflect(double deflection)
	{
		speedX += deflection * (speedX + 1);
	}
	
	public void stop()
	{
		speedX=0;
		speedY=0;
	}
	/**
	 *	Returns all the information about the balloon
	 *	@return returns a string containing the balloon's color,
	 *			x & y coordinate and radius
	 */
	public String toString()
	{
		return "Color: "+ color + " Location: " + loc + " Radius: " + radius;
	}
}
