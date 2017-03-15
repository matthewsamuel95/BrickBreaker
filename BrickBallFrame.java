// Using class MouseMotionAdapter.
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Observer;
import java.util.Observable;
import java.util.List;

public class BrickBallFrame extends JFrame implements ActionListener, MouseListener
{	
	public enum GameState {
		STARTING, PLAYING, ENDED
	}
	
	final int TIME_INC=30;
	
	private BrickBallPanel drawingPanel;
	private ScorePanel scorePanel;
	private BrickBall ball;
	private Paddle paddle;
	private Clock clock;
	private GameState state;
	private JMenuItem playMenuItem;
	
	private int score;
	
	// set up GUI and register mouse event handler
	public BrickBallFrame()
	{	
		super( "Brick Ball" );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		setSize( 800, 600 );
		setResizable(false);
		
		score = 0;
		
		JMenu menu = new JMenu("Game");
        JMenuItem m; 

        playMenuItem = new JMenuItem("Play Again"); 
        playMenuItem.addActionListener(this);
        menu.add(playMenuItem); 

        m = new JMenuItem("Exit"); 
        m.addActionListener(this);
        menu.add(m);
        
        JMenuBar mBar = new JMenuBar();
        mBar.add(menu);
        setJMenuBar(mBar);
        
		// create a label and place it in SOUTH of BorderLayout
		//getContentPane().add(new Label( "Drag the mouse to draw" ),BorderLayout.SOUTH );
        scorePanel = new ScorePanel();
        scorePanel.setPreferredSize(new Dimension(800, 30));
        scorePanel.update(null, null);
        getContentPane().add(scorePanel, BorderLayout.NORTH);
        
		drawingPanel = new BrickBallPanel();
		ball = new BrickBall(drawingPanel, Color.BLACK, 20, 20, 5, 5, 10);
		ball.addObserver(drawingPanel);
		paddle=new Paddle(drawingPanel,Color.BLACK,400,100,10);
		drawingPanel.setObjects(ball,paddle);
		drawingPanel.update(null, null);
      
     

		
		drawingPanel.update(null, null);

		getContentPane().add(drawingPanel,BorderLayout.CENTER);
		
		addMouseListener(this);
		
		state = GameState.STARTING;
		startGame();
		
		clock= new Clock(this,TIME_INC);
		clock.start();
	}
		
	// execute application
	public static void main( String args[] )
	{
		BrickBallFrame application = new BrickBallFrame();
		application.setVisible( true );
	}
	
    public void actionPerformed(ActionEvent e) 
    {
        String actionCommand = e.getActionCommand();
        //System.out.println(actionCommand);
        if (actionCommand.equals("Play Again"))
        {
        	startGame();
        }
        else if (actionCommand.equals("Exit"))
            System.exit(0);
    }
    
    public void ballLost()
    {
    	state = GameState.ENDED;
    	ball.stop();
    	//System.out.println("You Lost");
    	scorePanel.setPrompt("Game Over");
    	playMenuItem.setEnabled(true);
    }
    
    public void moveBall()
    {
    	if (state != GameState.PLAYING) return;
       	ball.move();
    	if(paddle.isInside(ball.getX(),ball.getY()+ball.getRadius()))
    	{
    		ball.setY(drawingPanel.getHeight()-paddle.getHeight()-ball.getRadius());
    		ball.setSpeedYSign(-1);
    		
    		double deflection = paddle.getDeflection(ball.getX());
    		//System.out.println(deflection);
    		
    		ball.deflect(deflection);
    		
    		score++;
    		scorePanel.setScore(score);
    	  while(state!=GameState.PLAYING)
        {
         ball.incSpeedY();
        }
    	}

    	if(drawingPanel.getHeight()<ball.getY()+ball.getRadius())
    		ballLost();
    }
    
    public void startGame()
    {
    	if(state==GameState.PLAYING)
    		return;
    	
    	playMenuItem.setEnabled(false);
    	score = 0;
    	scorePanel.setScore(0);
    	scorePanel.clearPrompt();
    	ball.setX(10);
    	ball.setY(10);
    	ball.setSpeedX(10);
    	ball.setSpeedY(5);
    	state=GameState.PLAYING;
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
    
    
} // end class Painter
