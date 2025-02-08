package dodge.scenes;

import java.awt.Color;
import java.awt.Graphics2D;

import dodge.common.Scene;
// import dodge.entity.Box;
// import dodge.entity.EntityID;
import dodge.entity.entities.Enemy;
import dodge.entity.entities.Player;

public class Level extends Scene {
	public Level() {
		super("Level");
	}

	public void load() {
		Player entity = new Player();
		entity.setPosition(10, 10);
		entity.setSize(16, 16);

		Enemy enemy = new Enemy();
		enemy.setPosition(100, 10);
		enemy.setSize(16, 16);
		enemy.color = Color.RED;

		handle.world.add(entity);
		handle.world.add(enemy);

		handle.controller.setEntity(entity);
	}

	public void update() {
		handle.controller.update();
		handle.world.processCollision(handle.controller.getEntity());
		handle.world.update();
	}

	public void render(Graphics2D graphics) {
		graphics.setColor( Color.black );
		graphics.fillRect(0, 0, this.handle.window.getWidth(), this.handle.window.getHeight());

		handle.world.render(graphics);
	}
}
