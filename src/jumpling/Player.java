package jumpling;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player extends Creature {

	private Game game;
	public static float y;
	public static BufferedImage image = Assets.player;

	public Player(Game game, float x, float y) {
		super(x, y);
		Player.y = y;
		this.game = game;
	}

	@Override
	public void tick() {

		if (y >= 700) {
			y = 700;
		}
		// if (y <= 100){
		// if (GameState.screen <= 0){
		// GameState.screen += 400;
		// }
		// }
		if (game.getKeyManager().left) {
			image = Assets.playerl;
			x -= 3;
		}
		if (game.getKeyManager().right) {
			image = Assets.player;
			x += 3;
		}
		if (game.getKeyManager().jump) {
			;
			y = y + (int) ((Math.sin(game.getKeyManager().getCounter())
					+ Math.cos(game.getKeyManager().getCounter()) * 5));
			if (image == Assets.player) {
				image = Assets.jumpr;
			}
			if (image == Assets.playerl) {
				image = Assets.jumpl;
			}
			if (y <= 100 && GameState.screen < 0) {
				GameState.screen += 4;
			}
		}
		if (Player.y >= 600 && GameState.screen >= -600){
			GameState.screen -= 4;
		}

		if (y <= 700 && !game.getKeyManager().jump) {
			y += 2;
		}

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image, (int) x, (int) y, null);
	}
}
