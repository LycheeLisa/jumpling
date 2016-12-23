package jumpling;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player extends Creature {
	
	private Game game;
	public static BufferedImage image = Assets.player;

	public Player(Game game, float x, float y) {
		super(x, y);
		this.game = game;
	}

	@Override
	public void tick() {

		if (y >= 700){
			y = 700;
		}
		if(game.getKeyManager().left){
			image = Assets.playerl;
			x -= 3;
		}
		if(game.getKeyManager().right){
			image = Assets.player;
			x += 3;
		}
		if(game.getKeyManager().jump){
			y = y + (int) ((Math.sin(game.getKeyManager().getCounter()) + Math.cos(game.getKeyManager().getCounter()) * 5));
			if (image == Assets.player){
				image = Assets.jumpr;
			}
			if (image == Assets.playerl){
				image = Assets.jumpl;
			}
		}
		
		if (y <= 700 && !game.getKeyManager().jump){
			y+=10;
		}
		
		
	}
	public void keyReleased(KeyEvent e) {
		if (e.getKeyChar() == KeyEvent.VK_SPACE){
			if (image == Assets.jumpl){
				image = Assets.playerl;
			}
			if (image == Assets.jumpr){
				image = Assets.player;
			}
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image, (int)x, (int)y, null);
	}
}
