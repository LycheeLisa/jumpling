package jumpling;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Sprite {
	private Image character;
	private int dx;
	private int dy;
	private int x;
	private int y;
	
	
	public void setCharacter(Image image) throws IOException{
		ImageIcon characterImage = new ImageIcon("C:\\Users\\IBM_ADMIN\\Documents\\Projects\\Jumpling\\bin\\jumpling\\char1.png");
		image = characterImage.getImage();
		x = 40;
		y = 60;
	}
	public void move(){
		x += dx;
		y += dy;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public Image getImage(){
		return character;
	}
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT){
			dx = -1;
		}
		if (key == KeyEvent.VK_RIGHT){
			dx = +1;
		}
		if (key == KeyEvent.VK_UP){
			dy = +1;
		}
		if (key == KeyEvent.VK_DOWN){
			dy = -1;
		}
	}
public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
//public static void main(String[] args){
//	JFrame j = new JFrame();
//	JPanel newJ = new JPanel();
//	Sprite s = new Sprite();
////	newJ.drawImage(s.getImage());;
//	
//			
//}
}
