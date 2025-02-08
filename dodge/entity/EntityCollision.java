package dodge.entity;

import java.util.ArrayList;

public class EntityCollision {
	public ArrayList<Entity> overlaps;
	public ArrayList<EntityID> idOverlaps;

	public EntityCollision () {
		this.overlaps = new ArrayList<>();
		this.idOverlaps = new ArrayList<>();
	}

	public void add (Entity entity) {
		this.overlaps.add(entity);
		this.idOverlaps.add(entity.ID);
	}

	public void remove (Entity entity) {
		this.overlaps.remove(entity);
		this.idOverlaps.remove(entity.ID);
	}

	public boolean contains (Entity entity) {
		return this.overlaps.contains(entity);
	}

	public boolean contains (EntityID entityID) {
		return this.idOverlaps.contains(entityID);
	}
	
	public static boolean overlaps(Entity e1, Entity e2) {
		return e1.x < e2.x + e2.width
		    && e2.x < e1.x + e1.width
			&& e1.y < e2.y + e2.height
			&& e2.y < e1.y + e1.height;
	}
}