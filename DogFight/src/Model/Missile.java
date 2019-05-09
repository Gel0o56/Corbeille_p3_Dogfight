//********* this.PACKAGE *********//
package Model;

//********* BASIC PACKAGES *********//
import Model.Position;


/**************************************** SUBCLASS Missile ****************************************/
public class Missile extends Mobile 
{
	//********* Attribute *********//
	private static int SPEED = 4;
	private static int WIDTH = 30;
	private static int HEIGHT = 10; 
	private static int MAX_DISTANCE_TRAVELED = 1400; 
	private static String IMAGE = "missile";
	private int distanceTraveled = 0; 


	/********** CONSTRUCTOR MISSILE **********/
	public Missile(Direction direction, Position position) 
	{
		super(direction, position, new Dimension (WIDTH, HEIGHT), SPEED, IMAGE);

	}


	/********** METHOD getWidthWithADirection **********/
	public int getWidthWithADirection (Direction direction) 
	{
		//TODO	
		return WIDTH;

	}

	
	/********** METHOD getHeightWithADirection **********/
	public int getHeightWithADirection (Direction direction) 
	{
		//TODO	
		return HEIGHT;
		
	}


	/********** METHOD Move **********/
	public void move() 
	{
		super.move();
		distanceTraveled += SPEED ;
		if (distanceTraveled > MAX_DISTANCE_TRAVELED) {
			getDogfightModel().removeMobile(this);
		}
	}


	/********** METHOD isWeapon **********/
	public boolean isWeapon() 
	{
		return true ;
	}
	
	
}