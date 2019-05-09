//********* this.PACKAGE *********//
package Model;

//********* BASIC PACKAGES *********//
import java.awt.Image;
import java.awt.image.BufferedImage;


/**************************************** CLASS Sky ****************************************/
public class Sky implements IArea 
{
	//********* Aggregation *********//
	private Dimension dimension;
	
	//********* Composition *********//
	private Image image;
	
	
	/********** CONSTRUCTOR Sky **********/
	public Sky(Dimension dimension) 
	{
		this.dimension = dimension;
		image = new BufferedImage(dimension.getWidth(), dimension.getHeight(), BufferedImage.TYPE_INT_RGB);
		
	}


	//********** GETTER METHOD Direction **********//
	public Dimension getDimension() 
	{
		return dimension;
		
	}
	
	
	//********** GETTER METHOD Image **********//
	public Image getImage() 
	{
		return image;

	}
	
	
}
