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
		if (Input.isKeyDown("Left")) {
			this.entity.x -= 2;
		} else if (Input.isKeyDown("Right")) {
			this.entity.x += 2;
		}

		if (Input.isKeyDown("Up")) {
			this.entity.y -= 2;
		} else if (Input.isKeyDown("Down")) {
			this.entity.y += 2;
		}
	}
}
