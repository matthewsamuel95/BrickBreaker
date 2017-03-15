import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Observer;
import java.util.Observable;
import java.util.List;

public class ScorePanel extends JPanel implements Observer
{
	private int score;
	private String prompt;
	
	// set up GUI and register mouse event handler
	public ScorePanel()
	{
		setBackground(Color.WHITE);
		score = 0;
		clearPrompt();
	}
	
	// draw oval in a 4-by-4 bounding box at the specified
	// location on the window
	public void paintComponent( Graphics g )
	{
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawString(Integer.toString(score), 100, 20);
		
		g.drawString(prompt, 400, 20);
	}
	
	public void setPrompt(String thePrompt)
	{
		prompt = thePrompt;
		repaint();
	}
	
	public void clearPrompt()
	{
		prompt = "";
	}
	
	public void setScore(int theScore)
	{
		score = theScore;
		repaint();
	}
	
	public void update(Observable o, Object arg)
	{
		repaint();
	}
} // end class ScorePanel
