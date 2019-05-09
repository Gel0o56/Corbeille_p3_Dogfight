//********* this.PACKAGE *********//
package Controller;


/**************************************** CLASS MOBILE ****************************************/
public class UserOrder implements IUserOrder
{
	//********* Attribute *********//
	private int player;
	
	//********* Aggregation *********//
	private Order order;

	
	/********** CONSTRUCTOR UserOrder **********/
	public UserOrder(Order order, int player) 
	{
		this.order = order;
		this.player = player;
		
	}
	
	
	//********** GETTER METHOD Order **********//
	public Order getOrder() 
	{
		return order;
	}
	
	
	//********** GETTER METHOD Player **********//
	public int getPlayer() 
	{
		return player;
		
	}
	
	
}