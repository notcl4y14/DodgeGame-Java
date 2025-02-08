package dodge.common;

import dodge.core.Input;
import dodge.entity.Entity;

public class Controller {
	public Entity entity;

	public Controller (Entity entity) {
		this.entity = entity;
	}

	public void setEntity (Entity entity) {
		this.entity = entity;
	}

	public Entity getEntity () {
		return this.entity;
	}

	public void update () {
		if (Input.isKeyDown("A")) {
			this.entity.x -= 2;
		} else if (Input.isKeyDown("D")) {
			this.entity.x += 2;
		}

		if (Input.isKeyDown("W")) {
			this.entity.y -= 2;
		} else if (Input.isKeyDown("S")) {
			this.entity.y += 2;
		}
	}
}
