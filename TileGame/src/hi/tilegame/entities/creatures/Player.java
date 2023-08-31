package hi.tilegame.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;

import hi.tilegame.Game;
import hi.tilegame.gfx.Assets;

public class Player extends Creature
{
	private Game game;
	private Rectangle bounds;
	
	public Player(Game game, float x, float y) 
	{
		super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		this.game = game;
		bounds = new Rectangle((int) x, (int) y, width, height);
	}

	@Override
	public void tick() 
	{
		getInput();
		move();
	}
	
	private void getInput()
	{
		xMove = 0;
		
		if(game.getKeyManager().right)
			xMove = speed;
		if(game.getKeyManager().left)
			xMove = -speed;
		bounds = new Rectangle((int) x, (int) y, width, height);
	}

	@Override
	public void render(Graphics g) 
	{
		g.drawImage(Assets.player, (int) x, (int) y, width, height, null);
		g.drawImage(Assets.dirt, 0, 736, 800, 70, null);
		g.drawImage(Assets.stone, 0, 736, 800, 5, null);
		
		g.drawImage(Assets.apple, 150, 130, 50, 50, null);
		g.drawImage(Assets.apple, 220, 130, 50, 50, null);
		g.drawImage(Assets.apple, 300, 130, 50, 50, null);
		g.drawImage(Assets.apple, 370, 130, 50, 50, null);
		g.drawImage(Assets.apple, 450, 130, 50, 50, null);
		g.drawImage(Assets.apple, 520, 130, 50, 50, null);
		
		g.drawImage(Assets.apple, 185, 130, 50, 50, null);
		g.drawImage(Assets.apple, 335, 130, 50, 50, null);
		g.drawImage(Assets.apple, 485, 130, 50, 50, null);
		
		g.drawImage(Assets.apple, 150, 165, 50, 50, null);
		g.drawImage(Assets.apple, 220, 165, 50, 50, null);
		g.drawImage(Assets.apple, 300, 165, 50, 50, null);
		g.drawImage(Assets.apple, 370, 165, 50, 50, null);
		g.drawImage(Assets.apple, 450, 165, 50, 50, null);
		g.drawImage(Assets.apple, 520, 165, 50, 50, null);
		
		g.drawImage(Assets.apple, 185, 165, 50, 50, null);
		g.drawImage(Assets.apple, 335, 165, 50, 50, null);
		g.drawImage(Assets.apple, 485, 165, 50, 50, null);
		
		//g.drawRect((int) x, (int) y, width, height);
	}
	
	public Rectangle getBounds()
	{
		return bounds;
	}
}
