//********* this.PACKAGE *********//
package Model;

//********* BASIC PACKAGES *********//
import java.util.ArrayList;


/**************************************** INTERFACE IDogfightModel ****************************************/
public interface IDogfightModel 
{  
	//********* Attribute *********//
	IArea getArea();
	
	void buildArea(Dimension dimension);
	void addMobile(IMobile mobile);
	void removeMobile(IMobile mobile);
	
	ArrayList<IMobile> getMobiles();
	IMobile getMobileByPlayer(int player);
	
	void setMobilesHaveMoved();
	
}
