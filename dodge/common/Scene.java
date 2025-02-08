package dodge.common;

import java.awt.Graphics2D;

import dodge.Dodge;

public abstract class Scene {
	public String name;
	protected Dodge handle;

	public Scene(String name) {
		this.name = name;
		this.handle = null;
	}

	public void bindHandle(Dodge handle) {
		this.handle = handle;
	}

	public abstract void load();
	public abstract void update();
	public abstract void render(Graphics2D graphics);
}
