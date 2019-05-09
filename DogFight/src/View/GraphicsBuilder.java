//********* this.PACKAGE *********//
package View;

import java.awt.Color;
//********* BASIC PACKAGES *********//
import java.awt.Graphics;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Iterator;

import Gameframe.IGraphicsBuilder;
import Model.IDogfightModel;
import Model.IMobile;


/**************************************** CLASS GraphicsBuilder ****************************************/
public class GraphicsBuilder implements IGraphicsBuilder
{
	//********* Composition *********//
	private final IDogfightModel dogfightModel;
//	private BufferedImage emptySky;
	
	
	/********** CONSTRUCTOR GraphicsBuilder **********/
	public GraphicsBuilder(IDogfightModel dogfightModel) 
	{
		this.dogfightModel = dogfightModel;
		buildEmptySky();
		
	}


	public IDogfightModel getDogfightModel() {
		return dogfightModel;
	}


	private void buildEmptySky() {
//			emptySky = new BufferedImage(dogfightModel.getArea().getDimension().getWidth(), dogfightModel.getArea().getDimension().getHeight(), BufferedImage.TYPE_INT_RGB) ;
	}
	
	/********** METHOD applyModelToGaphic **********/
	
	public void applyModelToGaphic(ImageObserver observer, Graphics graphic) 
	{
		ArrayList<IMobile> mobiles = dogfightModel.getMobiles() ;
		Iterator<IMobile> iterator = mobiles.iterator() ;
		while (iterator.hasNext()) {
			IMobile mobile = iterator.next() ;
			drawMobile(mobile, graphic, observer);
		}
	}
	
	
	/********** METHOD drawMobile **********/

	private void drawMobile(IMobile mobile, Graphics graphic, ImageObserver observer) 
	{

		
		
		graphic.setColor(Color.BLUE);
		
		final BufferedImage imageMobile = new BufferedImage(mobile.getWidth(), mobile.getHeight(), Transparency.TRANSLUCENT);

		System.out.print("Coord:"+mobile.getWidth()+"y="+ mobile.getHeight());
		final Graphics graphicsMobile = imageMobile.getGraphics(); 
		
		graphicsMobile.drawImage(mobile.getImage(), 0, 0, mobile.getWidth(), mobile.getHeight(), observer); 
		graphic.drawImage(imageMobile, mobile.getPosition().getX(), mobile.getPosition().getY(), observer);

		final boolean isHorizontalOut = (mobile.getPosition().getX() + mobile.getWidth()) > this.dogfightModel.getArea().getDimension().getWidth();
		final boolean isVerticalOut = (mobile.getPosition().getY() + mobile.getHeight()) > this.dogfightModel.getArea().getDimension().getHeight();

		if (isHorizontalOut) 
		{
			final BufferedImage imageMobileH = imageMobile.getSubimage(
					(int)(this.dogfightModel.getArea().getDimension().getWidth() - mobile.getPosition().getX()), 0, (int)((mobile.getWidth() - 
							this.dogfightModel.getArea().getDimension().getWidth()) + mobile.getPosition().getX()), (int)mobile.getHeight()); 
			graphic.drawImage(imageMobileH, 0, mobile.getPosition().getY(), observer);
		}

		if (isVerticalOut) 
		{ 
			final BufferedImage imageMobileV = imageMobile.getSubimage(0,
					(this.dogfightModel.getArea().getDimension().getHeight() - mobile.getPosition().getY()), 
					(mobile.getWidth()), 
					((mobile.getHeight() -
							this.dogfightModel.getArea().getDimension().getHeight()) + mobile.getPosition().getY())); 
			graphic.drawImage(imageMobileV, mobile.getPosition().getX(), 0, observer);
		}

		if (isHorizontalOut && isVerticalOut) 
		{
			final BufferedImage imageMobileHV = imageMobile.getSubimage(
					(this.dogfightModel.getArea().getDimension().getWidth() - mobile.getPosition().getX()),
					(this.dogfightModel.getArea().getDimension().getHeight() - mobile.getPosition().getY()), 
					((mobile.getWidth() - this.dogfightModel.getArea().getDimension().getWidth()) + mobile.getPosition().getX()),  
					((mobile.getHeight() -
							this.dogfightModel.getArea().getDimension().getHeight()) + mobile.getPosition().getY())); 
			graphic.drawImage(imageMobileHV, 0, 0, observer);
		}
	}
	
	
	//********** GETTTER METHOD GlobalWitdh **********//
	public int getGlobalWitdh()
	{
		return 1920;
		
	}


	//********** GETTTER METHOD GlobalHeight **********//

	public int getGlobalHeight()
	{
		return 1080;
		
	}



}