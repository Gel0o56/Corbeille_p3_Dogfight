//********* this.PACKAGE *********//
package Model;


/**************************************** CLASS Position ****************************************/
public class Position 
{
	//********* Attribute *********//
	private int x;
	private int y;
	private int maxX;
	private int maxY;
	
	
	/********** CONSTRUCTEUR POSITION **********/
	public Position(int x, int y, int maxX, int maxY) 
	{
		this.x = x;
		this.y = y;
		this.maxX = maxX;
		this.maxY = maxY;
		
	}
	
	
	/********** CONSTRUCTEUR COPY POSITION **********/
	public Position(Position position) 
	{
		this.x = position.x;
		this.y = position.y;
		this.maxX = position.maxX;
		this.maxY = position.maxY;	
		
	}
	
	
	//********** GETTER METHOD X **********//
	public int getX() 
	{
		return x;	
	}
	
	
	//********** SETTER METHOD X **********//
	public void setX(int x) 
	{
		if (x < 0)
			x += maxX;
		if (x > maxX)
			x -= maxX;
		this.x = x;
	}
	
	
	//********** GETTER METHOD Y **********//
	public int getY() 
	{
		return y;
		
	}
	
	
	//********** SETTER METHOD Y **********//
	public void setY(int y) 
	{
		if (y < 0)
			y += maxY;
		if (y > maxY)
			y -= maxY;
		this.y = y;
				
	}
	
	
	//********** SETTER METHOD MaxX **********//
	protected void setMaxX(int maxX) 
	{
		this.maxX = maxX;
		
	}
	
	
	//********** SETTER METHOD MaxY **********//
	protected void setMaxY(int maxY) 
	{
		this.maxY = maxY;
		
	}
	
	
}