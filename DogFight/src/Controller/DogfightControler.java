//********* this.PACKAGE *********//
package Controller;

//********* BASIC PACKAGES *********//
import java.util.ArrayList;
import java.util.Iterator;
import Model.Direction;
import Model.IDogfightModel;
import Model.IMobile;
import Model.Missile;
import Model.Position;
import View.IViewSystem;


/**************************************** CLASS DogfightControler ****************************************/
public class DogfightControler implements IOrderPerformer
{
	//********* Attribute *********//
	private static int TIME_SLEEP = 30 ;

	//********* Aggregation *********//
	private IViewSystem viewSystem ;
	private IDogfightModel dogfightModel ;


	/********** CONSTRUCTOR DogfightControler **********/
	public DogfightControler(IDogfightModel dogfightModel) 
	{
		this.dogfightModel = dogfightModel ;
	}


	/********** METHOD orderPerform **********/

	public void orderPerform(UserOrder userOrder)
	{
		Order order = userOrder.getOrder() ;
		IMobile plane = dogfightModel.getMobileByPlayer(userOrder.getPlayer());

		switch (order) 
		{
		case DOWN:
			plane.setDirection(Direction.DOWN);
			break ;
		case UP:
			plane.setDirection(Direction.UP);
			break ;
		case LEFT:
			plane.setDirection(Direction.LEFT);
			break ;
		case RIGHT:
			plane.setDirection(Direction.RIGHT);
			break ;
		case SHOOT:
			launchMissile(userOrder.getPlayer());
			break;
		case NOP:
			break;
		}
	}


	//********** SETTER METHOD ViewSystem **********//
	public void setViewSystem(IViewSystem viewSystem) 
	{
		this.viewSystem = viewSystem ;

	}


	/********** METHOD play **********/
	public void play()
	{
		viewSystem.start();
		gameLoop() ;
		viewSystem.displayMessage("Fin de Partie") ;
		viewSystem.closeAll();
	}


	/********** METHOD launchMissile **********/
	private void launchMissile (int player) 
	{
		IMobile plane = dogfightModel.getMobileByPlayer(player) ;
		Position positionMissile = new Position(plane.getPosition()) ;
		positionMissile.setX(plane.getPosition().getX()+50) ;
		Missile missile = new Missile(plane.getDirection(), positionMissile) ;
		dogfightModel.addMobile(missile) ;
	}


	/********** METHOD isWeaponOnMobile **********/
	private boolean isWeaponOnMobile(final IMobile mobile, final IMobile weapon) 
	{
		if ( 
				(( weapon.getPosition().getX() / weapon.getWidth() ) >= ( mobile.getPosition().getX() / weapon.getWidth() )) 
				&& (( weapon.getPosition().getX() / weapon.getWidth() ) <= ( ( mobile.getPosition().getX() + mobile.getWidth() ) / weapon.getWidth() )))
		{

			if (((weapon.getPosition().getY() / weapon.getHeight()) >= (mobile.getPosition().getY() / weapon.getHeight() ) )
					&& ((weapon.getPosition().getY() / weapon.getHeight()) <= ((mobile.getPosition().getY() + mobile.getHeight()) / weapon.getHeight()))) 
			{
				return true;
			}
		}
		return false;
	}


	/********** METHOD manageCollision **********/
	private boolean manageCollision(IMobile mobile) 
	{
		ArrayList<IMobile> mobiles = dogfightModel.getMobiles();
		if (mobiles != null) 
		{
			Iterator<IMobile> iterator = mobiles.iterator();
			while (iterator.hasNext()) 
			{
				IMobile weapon = iterator.next();
				if (weapon.isWeapon() && isWeaponOnMobile(mobile, weapon) ) 
				{
					return true;
				}
			}
		}

		return false;
	}


	/********** METHOD gameLoop **********/
	private void gameLoop() 
	{
		while (true) 
		{
			try {
				Thread.sleep(TIME_SLEEP);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			ArrayList<IMobile> mobiles = dogfightModel.getMobiles();
			if (mobiles != null) 
			{
				Iterator<IMobile> iterator = mobiles.iterator();
				while (iterator.hasNext()) 
				{
					IMobile mobile = iterator.next();
					mobile.move() ;
					if (manageCollision(mobile)) 
					{
						viewSystem.displayMessage("Collision détectée");
						return ;
					}
				}
				dogfightModel.setMobilesHaveMoved();
			}

		}
	}
	
	
}