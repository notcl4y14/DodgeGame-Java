package dodge.entity.entities;

import dodge.entity.Box;
import dodge.entity.Entity;
import dodge.entity.EntityCollision;
import dodge.entity.EntityID;

public class Player extends Box {
	public Player () {
		super(EntityID.Player);
		this.collision = new EntityCollision();
	}

	public void onOverlapIn (Entity entity) {
		if (entity.ID == EntityID.Enemy) {
			System.out.println("Colliding with Enemy");
		}
	}

	public void onOverlapOut (Entity entity) {
		if (entity.ID == EntityID.Enemy) {
			System.out.println("Colliding out of the Enemy");
		}
	}
}
