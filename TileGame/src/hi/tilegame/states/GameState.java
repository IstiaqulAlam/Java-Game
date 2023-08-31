package hi.tilegame.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import hi.tilegame.Game;
import hi.tilegame.entities.Block;
import hi.tilegame.entities.RandomBlock;
import hi.tilegame.entities.creatures.Player;
import hi.tilegame.gfx.Assets;

public class GameState extends State
{
	private Player player;
	private int[] spawnBoundsXMin, spawnBoundsXMax, spawnBoundsYMin, spawnBoundsYMax;
	private ArrayList<Block> block;
	private ArrayList<RandomBlock> apples;
	private int ticksoccured = 0;
	private int points = 0;
	private int health = 100;
	private int newSpeed = 30;
	
	public GameState(Game game)
	{
		super(game);
		player = new Player(game, 0, 686);
		block = new ArrayList<>();
		apples = new ArrayList<>();
		block.add(new Block(100, -40, 50, 50, 3, Assets.stone));
		block.add(new Block(250, -40, 50, 50, 3, Assets.stone));
		block.add(new Block(400, -40, 50, 50, 3, Assets.stone));
		block.add(new Block(550, -40, 50, 50, 3, Assets.stone));
		 
		//gets random rectangle areas to spawn the apples
		spawnBoundsXMax = new int[]{220, 370, 520};
		spawnBoundsXMin = new int[]{150, 300, 450};
		spawnBoundsYMax = new int[]{250, 250, 250};
		spawnBoundsYMin = new int[]{150, 150, 150};
		
		apples.add(new RandomBlock(150, 150, 50, 50, 3.0, Assets.apple, spawnBoundsXMax, spawnBoundsXMin, spawnBoundsYMax, spawnBoundsYMin));
		/*
		block.add(new RandomBlock(300, 150, 50, 50, 2.5, Assets.apple, 370, 300, 250, 150));
		block.add(new RandomBlock(450, 150, 50, 50, 2.5, Assets.apple, 520, 450, 250, 150));
		*/
	} 
	
	
	@Override
	public void tick() 
	{
		player.tick();
		
		if(player.getX() > 749)
		{
			player.setX(749);
		}
		else if(player.getX() < 0)
		{
			player.setX(0);
		}
		
		for(int i=0; i<block.size(); i++)
		{
			block.get(i).tick();
			//Respawns Blocks once they reach a certain point
			if (block.get(i).needsRespawn())
			{
				block.get(i).respawn(-40);
			}
			if(player.getBounds().intersects(block.get(i).getboundsBlock()))
			{
				System.out.println("Collision of Block Detected");
				for (int j=0; j<block.size(); j++)
				{
					block.get(j).respawn(-40);	
				}
				health -= 10;
				if (health == 0)
				{
					reinit();
				}
			}
		}
		for (int i=0; i<apples.size(); i++)
		{
			if (player.getBounds().intersects(apples.get(i).getBounds()))
			{
				apples.get(i).setRespawn(true);
				System.out.println("COLLISION DETECTED");
				points++;
			}
			else if (apples.get(i).getHitGround())
			{
				apples.get(i).setHitGround(false);
				points -= 1;
			}
			apples.get(i).tick();
		}
		if (ticksoccured/60 == 1)
		{
			newSpeed --;
			ticksoccured = 0;
		}
		if (newSpeed == 0)
		{
			newSpeed = 30;
		}
		ticksoccured ++;
	}
	
	public void reinit()
	{
		player = new Player(game, 0, 686);
		block = new ArrayList<>();
		apples = new ArrayList<>();
		points = 0;
		health = 100;
		newSpeed = 30;
		block.add(new Block(100, -40, 50, 50, 3, Assets.stone));
		block.add(new Block(250, -40, 50, 50, 3, Assets.stone));
		block.add(new Block(400, -40, 50, 50, 3, Assets.stone));
		block.add(new Block(550, -40, 50, 50, 3, Assets.stone));
		 
		//gets random rectangle areas to spawn the apples
		spawnBoundsXMax = new int[]{220, 370, 520};
		spawnBoundsXMin = new int[]{150, 300, 450};
		spawnBoundsYMax = new int[]{250, 250, 250};
		spawnBoundsYMin = new int[]{150, 150, 150};
		
		apples.add(new RandomBlock(150, 150, 50, 50, 3.0, Assets.apple, spawnBoundsXMax, spawnBoundsXMin, spawnBoundsYMax, spawnBoundsYMin));
		/*
		block.add(new RandomBlock(300, 150, 50, 50, 2.5, Assets.apple, 370, 300, 250, 150));
		block.add(new RandomBlock(450, 150, 50, 50, 2.5, Assets.apple, 520, 450, 250, 150));
		*/
	} 
	
	
	@Override
	public void render(Graphics g) 
	{
		
		g.drawImage(Assets.testImage, 0, 0, null);
		
		player.render(g);
		
		for(int i=0; i<block.size(); i++)
		{
			block.get(i).render(g);
		}
		for (int i=0; i<apples.size(); i++)
		{
			apples.get(i).render(g);
		}
		g.setFont(new Font("Times New Roman", Font.BOLD, 30));
		{
			g.setColor(Color.BLACK);
			{
				g.drawString("Points = " + points, 0, 30);
				g.drawString("Health = " + health , 0, 60);
				g.drawString("Time Till Speed Increment = " + newSpeed, 0, 90);
			}
		}
	}
	
}
