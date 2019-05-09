//********* this.PACKAGE *********//
package Gameframe;

import java.awt.Graphics;
//********* BASIC PACKAGES *********//
import java.awt.image.ImageObserver;

import Model.IDogfightModel;


/**************************************** INTERFACE IGraphicsBuilder ****************************************/
public interface IGraphicsBuilder 
{
	void applyModelToGaphic (ImageObserver observer, Graphics graphic);
	int getGlobalWitdh();
	int getGlobalHeight();
	IDogfightModel getDogfightModel();
	
}
