package dodge.scenes;

import java.awt.Color;
import java.awt.Graphics2D;

import dodge.common.Scene;
import dodge.core.Input;

public class MainMenu extends Scene {
	public MainMenu() {
		super("MainMenu");
	}

	public void load() {}

	public void update() {
		boolean keySpace = Input.isKeyDown("Space");

		if (keySpace) {
			this.handle.loadScene("Level");
		}
	}

	public void render(Graphics2D graphics) {
		graphics.setColor( Color.black );
		graphics.fillRect(0, 0, this.handle.window.getWidth(), this.handle.window.getHeight());

		graphics.setColor( Color.white );
		graphics.drawString("Press Space to start", this.handle.window.getWidth() / 2, this.handle.window.getHeight() / 2);
	}
}
