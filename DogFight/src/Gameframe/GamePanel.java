//********* this.PACKAGE *********//
package Gameframe;

//********* BASIC PACKAGES *********//
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

import Model.DogfightModel;


/**************************************** CLASS GamePanel ****************************************/
public class GamePanel extends JPanel implements Observer
{
	private static final long serialVersionUID = 1L;

	//********* Association bidirectional *********//
	private Observable observable;
	
	//********* Aggregation *********//
	private IGraphicsBuilder graphicBuilder;
	
	
	/********** CONSTRUCTOR GamePanel **********/
	public GamePanel (IGraphicsBuilder graphicBuilder) 
	{
		this.observable = (DogfightModel) graphicBuilder.getDogfightModel();
		this.graphicBuilder = graphicBuilder ;
		observable.addObserver(this);
		
	}
	
	
	/********** METHOD update **********/
	public void update(Observable observable, Object DogfightModel) 
	{
		System.out.println("model updated");
		revalidate();
		repaint();
	}
	
	
	/********** METHOD paintComponent **********/
	public void paintComponent (Graphics graphic) 
	{
		super.paintComponent(graphic);
		System.out.println("paintComponent");
		graphicBuilder.applyModelToGaphic(this, graphic);
	}
	
	
}
