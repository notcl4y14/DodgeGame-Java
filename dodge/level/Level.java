package dodge.level;

import dodge.entity.Entity;
import dodge.entity.World;

public class Level {
	public long startTime;
	public long lengthTime;
	public LevelScript script;
	public boolean finished;
	public World world;

	public Level () {
		this.startTime = 0;
		this.lengthTime = 0;
		this.script = null;
		this.finished = false;
	}

	public void loadScript (LevelScript script) {
		this.script = script;
		this.script.level = this;
	}

	public void setWorld (World world) {
		this.world = world;
	}

	public void start () {
		this.startTime = System.currentTimeMillis();
		this.finished = false;
		this.script.run();
	}

	public void stop () {
		this.finished = true;
	}

	public void addEntity (Entity entity) {
		this.world.add(entity);
	}

	public void update () {
		if (System.currentTimeMillis() - this.startTime >= this.lengthTime) {
			this.stop();
		}
	}
}
