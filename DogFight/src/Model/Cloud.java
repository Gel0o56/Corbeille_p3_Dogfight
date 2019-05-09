//********* this.PACKAGE *********//
package Model;


/**************************************** SUBCLASS Cloud ****************************************/
public class Cloud extends Mobile 
{
	//********* ATTRIBUTE *********//
	private static int SPEED = 1 ;
	private static int WIDTH = 300 ;
	private static int HEIGHT = 150 ;
	private static String IMAGE = "Cloud" ;
	
	
	/********** CONSTRUCTOR Cloud **********/
	public Cloud(Direction direction, Position position, Dimension dimension) 
	{
		super(direction, position, new Dimension (WIDTH, HEIGHT), SPEED, IMAGE) ;
		
	}
	
	
}