package hi.tilegame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Block extends Entity 
{
	private BufferedImage drawImage;
	private double speed;
	private Rectangle boundsBlock;
	//needRespawn sees if the block needs to be moved
	protected boolean needRespawn = false, hitGround = false;
	private int ticksoccured = 0;
	
	public Block(float x, float y, int width, int height, double spd, BufferedImage blockimage)
	{
		super(x, y, width, height);
		drawImage = blockimage;
		speed = spd;
		
		hitGround = false;
		
		boundsBlock = new Rectangle((int) x, (int) y, width, height);
	}
	
	@Override
	public void tick() 
	{
		boundsBlock = new Rectangle((int) x, (int) y, width, height);
		gravityDown();
		
	}
	
	//Moves the block down and sees if the block needs to respawn
	public void gravityDown()
	{
		if (y<=690)
		{
			y += speed;
			if (ticksoccured > 1800)
			{
				speed++;
				ticksoccured = 0;
			}
		}
		else
		{
			needRespawn = true;
			hitGround = true;
		}
		ticksoccured ++;
	}
	
	public void respawn(int respawnY)
	{
		y = respawnY;
		needRespawn = false;
	}
	
	@Override
	public void render(Graphics g) 
	{
		g.drawImage(drawImage, (int) x, (int) y, width, height, null);
		//g.drawRect((int) x, (int) y, width*2, height*2);
	}
	
	
	public boolean needsRespawn()
	{
		return needRespawn;
	}
	
	public Rectangle getboundsBlock()
	{
		return boundsBlock;
	}
	
	public void setRespawn(boolean val)
	{
		needRespawn = val;
	}
	
	public void setHitGround(boolean val)
	{
		hitGround = val;
	}
	
	public boolean getHitGround()
	{
		return hitGround;
	}
}

