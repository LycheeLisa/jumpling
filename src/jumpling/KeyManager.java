package jumpling;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	private boolean[] keys;
	public boolean up, down, left, right, jump;
	private double counter = 4;
	
	public KeyManager(){
		keys = new boolean[256];
	}
	
	public void tick(){
//		up = keys[KeyEvent.VK_UP];
//		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		jump = keys[KeyEvent.VK_SPACE];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		if (e.getKeyCode() == KeyEvent.VK_SPACE){
			counter += 0.1;
			if (counter >= 7){
				counter = 4;
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		if (e.getKeyChar() == KeyEvent.VK_SPACE){
			if (Player.image == Assets.jumpl){
				Player.image = Assets.playerl;
			}
			if (Player.image == Assets.jumpr){
				Player.image = Assets.player;
			}
			System.out.println("Reached this loop");
			counter = 4;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public double getCounter(){
		return this.counter;
	}

}
