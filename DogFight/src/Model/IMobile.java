//********* this.PACKAGE *********//
package Model;

//********* BASIC PACKAGES *********//
import java.awt.Image;


/**************************************** INTERFACE IMobile ****************************************/
public interface IMobile 
{	
	//********* Attribute *********//
	Direction getDirection() ;
	void setDirection (Direction direction);
	
	Position getPosition();
	
	Dimension getDimension();
	void setDimension(Dimension dimension);
	
	int getSpeed() ;
	int getWidth();
	int getHeight();
	
	Image getImage();
	
	void move();
	void placeInArea(IArea area);
	
	boolean isPlayer(int Player);
	boolean hit();
	boolean isWeapon();
	void setDogfightModel(DogfightModel dogfightModel);

}