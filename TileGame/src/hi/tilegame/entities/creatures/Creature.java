package hi.tilegame.entities.creatures;

import hi.tilegame.entities.Entity;

public abstract class Creature extends Entity
{
	public static final float DEFAULT_SPEED = 4.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 50,
							DEFAULT_CREATURE_HEIGHT = 50;
								
	protected float speed;
	protected float xMove;
	
	public Creature(float x, float y, int width, int height)
	{
		super(x, y, width, height);
		speed = DEFAULT_SPEED;
		xMove = 0;
		
	}
	
	public void move()
	{
		x += xMove;
	}
	//Getters Setters

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	 
}
