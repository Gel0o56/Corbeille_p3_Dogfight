//********* this.PACKAGE *********//
package Gameframe;

//********* BASIC PACKAGES *********//
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import javax.swing.JFrame;


/**************************************** CLASS GameFrame ****************************************/
public final class GameFrame extends JFrame implements KeyListener
{	
	private static final long serialVersionUID = 1L;
	private boolean[] keys;
	
	//********* Aggregation *********//
//	private IEventPerformer eventPerformer;


	/********** CONSTRUCTOR GameFrame **********/
	public GameFrame(String title, IEventPerformer eventPerformer, IGraphicsBuilder graphicsBuilder, Observable observable) 
	{
		super(title);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setVisible(true);
//		this.eventPerformer = eventPerformer;
		this.add(new GamePanel(graphicsBuilder));
		keys = new boolean[256];
	}
	
	
	/********** METHOD keyPressed **********/
	public void keyPressed(KeyEvent keyEvent) 
	{
		keys[keyEvent.getKeyCode()] = true;
		System.out.println("Pressed!");
		
	}


	/********** METHOD keyReleased **********/
	public void keyReleased(KeyEvent keyEvent) 
	{
		keys[keyEvent.getKeyCode()] = false;
		System.out.println("Released!");
		
	}


	/********** METHOD keyTyped **********/
	public void keyTyped(KeyEvent keyEvent) 
	{
		keyEvent.getKeyChar();
		System.out.println("Typed!" + keyEvent.getKeyChar());

	}


}