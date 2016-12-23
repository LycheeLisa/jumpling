package jumpling;

import java.awt.Graphics;

public class GameState extends State{
	private int x = 0;
	private Player player;
	
	public GameState(Game game){
		super(game);
		player = new Player(game, 0, 700);
		
	}
	@Override
	public void tick() {
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.background, 0, 0, null);
		player.render(g);

	}

}
