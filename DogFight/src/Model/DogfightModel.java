//********* this.PACKAGE *********//
package Model;

//********* BASIC PACKAGES *********//
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;


/**************************************** CLASS DogfightModel ****************************************/
public class DogfightModel extends Observable implements IDogfightModel 
{
	//********* Aggregation *********//
	private ArrayList<IMobile> mobiles;
	
	//********* Composition *********//
	private Sky sky;
	
	
	/********** CONSTRUCTOR DogfightModel **********/
	public DogfightModel() 
	{
		mobiles = new ArrayList<IMobile>();
		
	}
	
	
	//********** GETTER METHOD IArea **********//
	public IArea getArea() 
	{
		return sky;
	}
	
	
	/********** METHOD buildArea **********/
	public void buildArea(Dimension dimension) 
	{
		sky = new Sky(dimension);
		
	}
	
	
	/********** METHOD addMobile **********/
	public void addMobile(IMobile mobile) 
	{
		mobiles.add(mobile);
		mobile.setDogfightModel(this);
	}
	
	
	/********** METHOD removeMobile **********/
	public void removeMobile(IMobile mobile) 
	{
		mobiles.remove(mobile);
		
	}
	
	
	/********** METHOD ArrayList **********/
	public ArrayList<IMobile> getMobiles() 
	{
		return mobiles;
		
	}


	/********** METHOD getMobileByPlayer **********/
	public IMobile getMobileByPlayer(int player) 
	{
		Iterator<IMobile> mobileIterator = mobiles.iterator();
		
		while(mobileIterator.hasNext()) 
		{
			IMobile imobile = mobileIterator.next();
			if (imobile.isPlayer(player)) return imobile;
		}
		return null;
		
	}


	/********** METHOD setMobilesHaveMoved **********/
	public void setMobilesHaveMoved() 
	{
		setChanged();
		notifyObservers();
		
	}


}