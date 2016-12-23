package jumpling;

public abstract class Creature extends Entity {
	protected int health;
	protected double gravity;
	
	public Creature(float x, float y) {
		super(x, y);
		health = 10;
	}	

}
