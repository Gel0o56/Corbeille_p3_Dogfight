//********* this.PACKAGE *********//
package Model;


/**************************************** SUBCLASS Plane ****************************************/
public class Plane extends Mobile 
{
	//********* Attribute *********//
	private static int SPEED = 2;
	private static int WIDTH = 100;
	private static int HEIGHT = 30;
	private int player;
	
	
	/********** CONSTRUCTOR Plane **********/
	public Plane(int player, Direction direction, Position position, String image) 
	{
		super(direction, position, new Dimension (WIDTH, HEIGHT), SPEED, image);
		this.player = player;
		
	}
	
	
	/********** METHOD isPalyer **********/
	public boolean isPlayer (int player) 
	{
		if (this.player == player)
			return true;
		else 
			return false;
		
	}
	
	
	/********** METHOD hit **********/
	public boolean hit ()
	{
		return true;
		
	}
}