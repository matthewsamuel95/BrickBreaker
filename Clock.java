import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.applet.*;

public class Clock extends Applet implements ActionListener
{
	private Timer timer;
	private int timeIncr;  // in milliseconds
	private BrickBallFrame frame;

	/**
	 *	Creates a timer object with the given data
	 *	@param theBallonField the listener for the timer
	 *	@param dt the interval duration time in milliseconds that timer fires
	 */
	public Clock(BrickBallFrame theFrame, int dt)
	{
		frame = theFrame;
		timeIncr = dt;
		timer = new Timer(timeIncr, this);
	}

	/**
	 *	Starts the timer
	 */
	public void start()
	{
		timer.start();
	}

	/**
	 *	Stops the timer
	 */
	public void stop()
	{
		timer.stop();
	}

	/**
	 *	Called automatically when the timer fires.
	 *	@param e contains the action event
	 *	@post-condition Move the balloons every time the timer goes off
	 */
	public void actionPerformed(ActionEvent e)
	{
		// Tell the model to move the ball.
		frame.moveBall();
	}
}
