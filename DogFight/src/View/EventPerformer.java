//********* this.PACKAGE *********//
package View;

//********* BASIC PACKAGES *********//
import java.awt.event.KeyEvent;

import Controller.IOrderPerformer;
import Controller.UserOrder;
import Gameframe.IEventPerformer;


/**************************************** CLASS EventPerformer ****************************************/

public class EventPerformer implements IEventPerformer
{
	//********* Aggregation *********//
//	private IOrderPerformer orderPerformer;


	
	/********** CONSTRUCTOR EventPerformer **********/
	public EventPerformer(IOrderPerformer orderPerformer) {
//		this.orderPerformer = orderPerformer;
	}
	
	
	/********** METHOD eventPerform **********/
	public void eventPerform(KeyEvent keyCode) 
	{
//TODO

	}
	
	
	/********** METHOD keyCodeToUserOrder **********/
	public UserOrder keyCodeToUserOrder(int keyCode) 
	{
//TODO
		UserOrder order = new UserOrder(null, keyCode);
		return order;
	}


}
