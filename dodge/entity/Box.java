package dodge.entity;

import java.awt.Color;
import java.awt.Graphics2D;

public class Box extends Entity {
	public Color color;

	public Box (EntityID ID) {
		super(ID);
		this.color = Color.WHITE;
	}

	public void render (Graphics2D graphics) {
		graphics.setColor(this.color);
		graphics.fillRect(this.x, this.y, this.width, this.height);
	}
}
