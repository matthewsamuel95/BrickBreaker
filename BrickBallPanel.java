// Using class MouseMotionAdapter.
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Observer;
import java.util.Observable;
import java.util.List;

public class BrickBallPanel extends JPanel implements Observer, MouseMotionListener
{
	
	private BrickBall ball;
	private Paddle paddle;
	
	// set up GUI and register mouse event handler
	public BrickBallPanel()
	{
		addMouseMotionListener(this);
	}
	
	public void setObjects(BrickBall theBall,Paddle thePaddle)
	{
		ball=theBall;
		paddle=thePaddle;
	}
	
	// draw oval in a 4-by-4 bounding box at the specified
	// location on the window
	public void paintComponent( Graphics g )
	{
		super.paintComponent(g);
		ball.draw(g);
		paddle.draw(g);
	}
	
	public void update(Observable o, Object arg)
	{
		repaint();
	}
	
	public void mousePressed(MouseEvent e)
	{
	}
	
	public void mouseReleased(MouseEvent e)
	{
    }
     
    public void mouseEntered(MouseEvent e)
    {
    }
     
    public void mouseExited(MouseEvent e)
    {
    }
     
    public void mouseClicked(MouseEvent e)
    {
    }
    
    public void mouseDragged(MouseEvent e)
    {
    }
    
    public void mouseMoved(MouseEvent e)
    {
    	paddle.setX(e.getX());
    	repaint();
    }
	
} // end class BrickBallPanel
