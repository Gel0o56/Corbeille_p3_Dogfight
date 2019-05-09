//********* BASIC PACKAGES *********//
import Controller.DogfightControler;
import Model.Dimension;
import Model.Direction;
import Model.DogfightModel;
import Model.Plane;
import Model.Position;
import View.DogfightView;


/**************************************** CLASS Dogfight ****************************************/
public class Dogfight 
{
	
	/********** main **********/
	public static void main(String[] args) 
	{
		final DogfightModel dogfightModel = new DogfightModel();
		dogfightModel.buildArea(new Dimension(1920, 1080));
		
		final DogfightControler dogfightControler = new DogfightControler(dogfightModel);

		final DogfightView dogfightView = new DogfightView(dogfightControler, dogfightModel, dogfightModel);
		dogfightControler.setViewSystem(dogfightView);
		
		Plane plane1 = new Plane(1, Direction.UP, new Position (640, 540, 1920, 1080), "file:///C:/Users/K%E9vin/eclipse-workspace/DogFight/res/textures/plane.png");		
		dogfightModel.addMobile(plane1);
		Plane plane2 = new Plane(2, Direction.UP, new Position (1280, 540, 1920, 1080), "file:///C:/Users/K%E9vin/eclipse-workspace/DogFight/res/textures/plane.png");		
		dogfightModel.addMobile(plane2);

		dogfightControler.play(); 	
		}
}