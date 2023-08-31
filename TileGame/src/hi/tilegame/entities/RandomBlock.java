package hi.tilegame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class RandomBlock extends Block
{
	private int randomArray;
	private int[] xMin, yMin, xMax, yMax;
	private Rectangle bounds;
	
	public RandomBlock(float x, float y, int width, int height, double spd, BufferedImage blockimage, int[] xxmax, int[] xxmin, int[] yymax, int[] yymin)
	{
		super(x,y,width,height, spd, blockimage);
		xMin = xxmin;
		yMin = yymin;
		xMax = xxmax;
		yMax = yymax;
		
		randomArray = (int) findRandom(0, xMin.length);
		super.x = findRandom(xMin[randomArray], xMax[randomArray]);
		super.y = findRandom(yMin[randomArray], yMax[randomArray]);
		
		bounds = new Rectangle(xMin[randomArray], yMin[randomArray], (int) (width/1.8), (int) (height/1.25));
	}
	
	//Finds a random value in between the minimum and maximum value.
	private float findRandom(int min, int max) 
	{
		return new Random().nextInt(max - min) + min;
	}
	
	public void tick()
	{
		super.tick();
		if (needRespawn)
		{
			randomArray = (int) findRandom(0, xMin.length);
			respawn((int) findRandom(yMin[randomArray], yMax[randomArray]));
			super.x = findRandom(xMin[randomArray], xMax[randomArray]);
		}
		bounds = new Rectangle((int) x, (int) y, (int) (width/1.8), (int) (height/1.25));
	}
	
	public void render(Graphics g)
	{
		super.render(g);
		
		//g.drawRect((int) x, (int) y, (int) (width/1.8), (int) (height/1.25));
	}
	
	public Rectangle getBounds()
	{
		return bounds;
	}
}
