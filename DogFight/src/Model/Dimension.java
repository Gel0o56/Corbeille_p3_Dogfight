//********* this.PACKAGE *********//
package Model;


/**************************************** CLASS Dimension ****************************************/
public class Dimension 
{
	//********* ATTRIBUTE *********//
	private int width ;
	private int height ;

	
	/********** CONSTRUCTOR DIMENSION **********/
	public Dimension(int width, int height) 
	{
		this.width = width ;
		this.height = height ;
		
	}
	
	
	/********** CONSTRUCTOR COPY DIMENSION **********/
	public Dimension(Dimension dimension) 
	{
		this.width = dimension.width ;
		this.height = dimension.height ;
		
	}
	
	
	//********** GETTER METHOD Width **********//
	public int getWidth() 
	{
		return width ;
		
	}
	
	
	//********** SETTER METHOD Width **********//
	public void setWidth(int width) 
	{
		this.width = width ;
		
	}
	
	
	//********** GETTER METHOD Height **********//
	public int getHeight() 
	{
		return height ;

	}
	
	
	//********** SETTER METHOD Height **********//
	public void setHeight(int height) 
	{
		this.height = height ;
		
	}
	
	
}