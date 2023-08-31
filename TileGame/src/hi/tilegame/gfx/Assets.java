package hi.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets
{
	public static final int width = 32, height = 32;
			
	
	public static BufferedImage player, dirt, grass, stone, tree, apple, black, testImage;
	
	public static void init()
	{
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));

		testImage = ImageLoader.loadImage("/textures/test.png");
		player = sheet.crop(0, 0, width, height);
		dirt = sheet.crop(width, 0, width, height);
		grass = sheet.crop(width*2, 0, width, height);
		stone = sheet.crop(width*3, 0, width, height);
		tree = sheet.crop(0, height, width, height);
		apple = sheet.crop(width, height, width, height);
		black = sheet.crop(width*2, height, width, height);
	}
}
