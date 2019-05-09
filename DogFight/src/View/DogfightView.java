//********* this.PACKAGE *********//
package View;

//********* BASIC PACKAGES *********//
import java.util.Observable;
import Controller.IOrderPerformer;
import Gameframe.GameFrame;
import Model.IDogfightModel;


/**************************************** CLASS DogfightView ****************************************/
public class DogfightView implements IViewSystem, Runnable
{
	//********* Attribute *********//
	private boolean running =false;
	private Thread thread ;
	
	//********* Composition *********//
	private GraphicsBuilder graphicsBuilder;
	private EventPerformer eventPerformer;
	private GameFrame gameFrame;
	
	
	/********** CONSTRUCTOR DogfightView **********/
	public DogfightView(IOrderPerformer orderPerformer, IDogfightModel dogfightModel, Observable observable) 
	{
		graphicsBuilder = new GraphicsBuilder(dogfightModel);
		eventPerformer = new EventPerformer(orderPerformer);
		gameFrame = new GameFrame("Dogfight", eventPerformer, graphicsBuilder, observable);
		gameFrame.setSize(dogfightModel.getArea().getDimension().getWidth(), dogfightModel.getArea().getDimension().getHeight());
		gameFrame.setVisible(true);
		
	}
	
	
	/********** METHOD run **********/
	public void run() 
	{
		System.out.println("Thread is running...");  
		
		while (running) {
		}
		
		closeAll();
	}
	
	
	/********** METHOD displayMessage **********/
	public void displayMessage(String message) 
	{
		System.out.println(message);
		
	}
	
	
	/********** METHOD start **********/
	public synchronized void start() 
	{
		if (running) return ;
		running = true ;
		thread = new Thread(this);
		thread.start();
		
	}
	
	/********** METHOD closeAll **********/
	public synchronized void closeAll() 
	{
		if (running == false) return ;
		running = false ;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
