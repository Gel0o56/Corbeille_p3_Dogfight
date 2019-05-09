//********* this.PACKAGE *********//
package Model;

//********* BASIC PACKAGES *********//
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;


/**************************************** CLASS Mobile ****************************************/
public class Mobile implements IMobile 
{
	//********* Attribute *********//
	private int speed;

	//********* Aggregation *********//
	private Dimension dimension;
	private Position position;
	private Direction direction;
	private DogfightModel dogfightModel;

	//********* Composition *********//
	private Image image;
	private Color color ;



	/********** CONSTRUCTOR Mobile **********/
	public Mobile(Direction direction, Position position, Dimension dimension, int speed, String image) 
	{
		this.speed = speed;
		this.dimension = dimension;
		this.position = position;
		this.direction = direction;
		this.color = new Color(10, 100, 200) ;
		this.image = new BufferedImage(dimension.getWidth(), dimension.getHeight(), BufferedImage.TYPE_INT_RGB);
		this.image.getGraphics().drawRect(1, 1, dimension.getWidth()-2, dimension.getHeight()-2);
		this.image.getGraphics().setColor(getColor());
		this.dogfightModel = null ;
	}


	//********** GETTER METHOD Direction **********//
	public Direction getDirection() 
	{
		return direction;

	}


	//********** SETTER METHOD Direction **********//
	public void setDirection(Direction direction) 
	{
		this.direction = direction;

	}


	//********** GETTER METHOD Position **********//
	public Position getPosition() 
	{
		return position;

	}


	//********** GETTER METHOD Dimension **********//
	public Dimension getDimension() 
	{
		return dimension;

	}


	//********** SETTER METHOD Dimension **********//
	public void setDimension(Dimension dimension) 
	{
		this.dimension = dimension;

	}


	//********** GETTER METHOD Speed **********//
	public int getSpeed() 
	{
		return speed;

	}


	//********** GETTER METHOD Width **********//
	public int getWidth() 
	{
		return dimension.getWidth();

	}


	//********** GETTER METHOD Height **********//
	public int getHeight() 
	{
		return dimension.getHeight();

	}


	/********** METHOD isWeapon **********/
	public boolean isWeapon() 
	{
		return false;

	}


	/********** METHOD placeInArea **********/
	public void placeInArea(IArea area) 
	{
		//TODO
	}


	/********** METHOD isPlayer **********/
	public boolean isPlayer(int player) 
	{
			return false;
			
	}


	/********** METHOD moveUp **********/
	private void moveUp() 
	{
		int newPosition = position.getY() + speed;
		position.setY(newPosition );
	}


	/********** METHOD moveRight **********/
	private void moveRight() 
	{
		int newPosition = position.getX() + speed;
		position.setX(newPosition );
	}


	/********** METHOD moveDown **********/
	private void moveDown() 
	{
		int newPosition = position.getY() - speed;
		position.setY(newPosition );
	}


	/********** METHOD moveLeft **********/
	private void moveLeft() 
	{
		int newPosition = position.getX() - speed;
		position.setX(newPosition );
	}


	/********** METHOD hit **********/
	public boolean hit() 
	{
		return false;

	}


	//********** GETTER METHOD DogFightModel **********//
	public DogfightModel getDogfightModel() 
	{
		return dogfightModel;

	}


	//********** SETTER METHOD DogFightModel **********//
	public void setDogfightModel(DogfightModel dogfightModel) 
	{
		this.dogfightModel = dogfightModel;
		this.getPosition().setMaxX(dogfightModel.getArea().getDimension().getWidth());
		this.getPosition().setMaxY(dogfightModel.getArea().getDimension().getHeight());
	}

	//********** GETTER METHOD Color **********//
	public Color getColor() 
	{
		return color;

	}


	/********** METHOD move **********/
	public void move() 
	{
		switch (direction) 
		{
		case RIGHT :
			moveRight();
			break;
		case LEFT:
			moveLeft();
			break;
		case UP :
			moveUp();
			break;
		case DOWN :
			moveDown();
			break;
		}
	}


	//********** GETTER METHOD Images **********//
	public Image getImage() 
	{
		return image;

	}	
}