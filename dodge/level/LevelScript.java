package dodge.level;

import dodge.entity.Entity;
import dodge.entity.EntityID;

public class LevelScript implements Runnable {
	public Thread thread;
	public byte[] codeData;
	public int codeLength;
	public Level level;

	public LevelScript (int length) {
		this.thread = new Thread(this);
		this.codeData = new byte[length];
		this.codeLength = length;
	}

	public void run () {
		int position = 0;

		while (position < this.codeLength) {
			byte command = this.codeData[position];

			switch (command) {
				case 0:
					this.level.stop();
				
				case 1:
					position++;

					int entityID = this.codeData[position++];
					int entityX = this.codeData[position++];
					int entityY = this.codeData[position];

					Entity entity = Entity.fromID(EntityID.values()[entityID]);
					entity.setPosition(entityX, entityY);
					entity.setSize(16, 16);

					this.level.addEntity(entity);
			}
			position++;
		}

		try {
			this.thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.thread = null;
	}
}
