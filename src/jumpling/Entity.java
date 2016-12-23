package jumpling;

import java.awt.Graphics;

public abstract class Entity {
	//Protected will allow classes that extend this class to also use the variable
	protected float x, y;
	public Entity(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
}
