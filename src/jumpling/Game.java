package jumpling;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import jumpling.Display;

public class Game implements Runnable {
	private Display display;
	public int width, height;
	private Thread thread;
	public String title;
	private boolean running = false;
	private BufferStrategy bs;
	private BufferedImage background;
	private Graphics g;
	
	//States
	
	private State gameState;
	private State menuState;
	
	//Input
	private KeyManager keyManager;

	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();

	}

	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		gameState = new GameState(this);
		menuState = new MenuState(this);
		State.setState(gameState);
	}

	private void tick() {
		keyManager.tick();
		if (State.getState() != null){
			State.getState().tick();
		}
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// Clear screen
		g.clearRect(0, 0, width, height);
		
		if (State.getState() != null){
			State.getState().render(g);
		}
		// Start drawing
		// Stop drawing
		bs.show();
		g.dispose();
	}

	@Override
	public void run() {
		init();
		int fps = 60;
		// 1B nanoseconds in 1 second, divide 1 second by how many frames per
		// second wanted
		// Maximum amount of time to run ticks to achieve fps of 60
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long timer = 0;
		int ticks = 0;
		// Amount of time our computer is running at
		long lastTime = System.nanoTime();

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			// If we have to tick and render again to achieve 60 fps
			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			if (timer>= 1000000000){
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();
		// TODO Auto-generated method stub

	}
	public KeyManager getKeyManager(){
		return keyManager;
	}
	/**
	 * Calls run method
	 */
	public synchronized void start() {
		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
