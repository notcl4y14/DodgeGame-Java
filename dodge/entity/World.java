package dodge.entity;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class World {
	public ArrayList<Entity> entities;
	public int count;
	public int size;

	public World (int size) {
		this.entities = new ArrayList<>();
		this.count = 0;
		this.size = size;
	}

	public void add (Entity entity) {
		if (this.count + 1 >= this.size) {
			return;
		}

		// this.entities.set(this.count++, entity);
		this.entities.add(entity);
		this.count++;
	}

	public void remove (Entity entity) {
		this.entities.remove(entity);
		this.count--;
	}

	public void remove (int index) {
		this.entities.remove(index);
		this.count--;
	}

	public void processCollision (Entity entity) {
		for (int i = 0; i < this.count; i++) {
			Entity other = this.entities.get(i);

			if (entity.equals(other)) {
				continue;
			}

			boolean collision = EntityCollision.overlaps(entity, other);
			boolean hasOverlap = entity.collision.contains(other);

			if (collision && !hasOverlap) {
				entity.collision.add(other);
				entity.onOverlapIn(other);
			} else if (!collision && hasOverlap) {
				entity.collision.remove(other);
				entity.onOverlapOut(other);
			}
		}
	}

	// ==== Update/Render ==== //
	public void update () {
		ArrayList<Integer> toDestroy = new ArrayList<>();
		
		for (int i = 0; i < this.count; i++) {
			Entity entity = this.entities.get(i);

			if (entity.shouldDestroy) {
				toDestroy.add(i);
			}

			entity.update();
		}

		int size = toDestroy.size();
		for (int i = 0; i < size; i++) {
			this.remove(toDestroy.get(i).intValue());
		}
	}

	public void render (Graphics2D graphics) {
		for (int i = 0; i < this.count; i++) {
			this.entities.get(i).render(graphics);
		}
	}
}
