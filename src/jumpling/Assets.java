package jumpling;

import java.awt.image.BufferedImage;

public class Assets {
	public static BufferedImage player, playerl, jumpr, jumpl, ltile, ctile, c2tile, rtile, background;
	private static final int width = 75, height = 75;
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sprites.png"));
		background = ImageLoader.loadImage("/textures/background1.gif");
		player = (sheet.crop(0, 0, width, height));
		playerl = (sheet.crop(width, 0, width, height));
		jumpr = (sheet.crop(2 * width, 0, width, height));
		jumpl = (sheet.crop(3 * width, 0, width, height));
		ltile = (sheet.crop(0, height, width, height));
		ctile = (sheet.crop(width, height, width, height));
		c2tile = (sheet.crop(width * 2, height, width, height));
		rtile = (sheet.crop(width * 3, height, width, height));
	}
}
