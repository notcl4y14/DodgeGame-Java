package dodge.scenes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import dodge.common.Scene;

public class Boot extends Scene {
	private ArrayList<String> log;
	private int timer;

	public Boot() {
		super("boot");
		this.log = new ArrayList<String>();
		this.timer = 100;
	}

	public void load() {
		this.log.add("Loading Assets...");
		this.log.add("Starting the game...");
	}

	public void update() {
		this.timer--;

		if (this.timer == 0) {
			boolean result = this.handle.loadScene("MainMenu");
			
			if (result == false) {
				this.log.add("Couldn't load scene MainMenu");
			}
		}
	}

	public void render(Graphics2D graphics) {
		int windowWidth = this.handle.window.getWidth(),
		    windowHeight = this.handle.window.getHeight();
		
		// Clear screen
		graphics.setColor( Color.black );
		graphics.fillRect(0, 0, windowWidth, windowHeight);

		graphics.setColor( Color.white );
		graphics.drawString("Loading...", 0, windowHeight - 40);

		for (int i = 0; i < this.log.size(); i++) {
			int y = windowHeight - 50 - (i * 10);
			graphics.drawString(this.log.get(i), 0, y);
		}
	}
}
