/**
 *	Location class keeps track of a x-y coordinate location
 */
 
public class Location
{
	private int x;
	private int y;
	
	/**
	 *	Creates a location object at (0,0)
	 */
	public Location()
	{
		x = 0;
		y = 0;
	}
	
	/**
	 *	Creates a location object at (x,y)
	 *	@param x the x coordinate
	 *	@param y the y coordinate
	 */
	public Location(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 *	Returns the x-coordinate
	 *	@return returns the x-coordinate
	 */
	public int getX()
	{
		return x;
	}
	
	/**
	 *	Returns the y-coordinate
	 *	@return returns the y-coordinate
	 */
	public int getY()
	{
		return y;
	}
	
	/**
	 *	Changes the x-coordinate
	 *	@param x the new x-coordinate
	 */
	public void setX(int x)
	{
		this.x = x;
	}
	
	/**
	 *	Changes the y-coordinate
	 *	@param y the new y-coordinate
	 */
	public void setY(int y)
	{
		this.y = y;
	}
	
	/**
	 *	Returns true if two Location objects are the same
	 *	@param obj the other Location object to compare this to
	 *	@return returns true if obj and this have the same x-y values
	 */
	public boolean equals(Object obj)
	{
		Location other = (Location) obj;
		return other.x == x && other.y == y;
	}
	
	/**
	 *	Returns a string containing the x-y coordinate
	 *	@return returns a string containing the x-y coordinate
	 */
	public String toString()
	{
		return "(" + x + ", "+ y + ")";
	}
}
