package dodge.scenes;

import java.awt.Color;
import java.awt.Graphics2D;

import dodge.common.Scene;
import dodge.entity.entities.Player;

public class SceneLevel extends Scene {
	public SceneLevel() {
		super("Level");
	}

	public void load() {
		Player entity = new Player();
		entity.setPosition(10, 10);
		entity.setSize(16, 16);

		handle.world.add(entity);

		handle.controller.setEntity(entity);

		handle.level.start();
	}

	public void update() {
		handle.controller.update();
		handle.world.processCollision(handle.controller.getEntity());
		handle.world.update();
		handle.level.update();
	}

	public void render(Graphics2D graphics) {
		graphics.setColor( Color.black );
		graphics.fillRect(0, 0, this.handle.window.getWidth(), this.handle.window.getHeight());

		handle.world.render(graphics);

		if (handle.level.finished) {
			graphics.setColor(Color.WHITE);
			graphics.fillRect(10, 100, 32, 32);
		}
	}
}
