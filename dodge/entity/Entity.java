package dodge.entity;

import java.awt.Graphics2D;

public class Entity {
	public int x;
	public int y;
	public int width;
	public int height;

	public EntityID ID;
	public EntityCollision collision;
	public boolean shouldDestroy;

	public Entity (EntityID ID) {
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;

		this.ID = ID;
		this.collision = null;
		this.shouldDestroy = false;
	}

	public void setPosition (int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setSize (int width, int height) {
		this.width = width;
		this.height = height;
	}

	// ==== Collision ==== //
	public void onOverlapIn (Entity other) {}
	public void onOverlapOut (Entity other) {}

	// ==== Update/Render ==== //
	public void update () {}

	public void render (Graphics2D graphics) {}
}