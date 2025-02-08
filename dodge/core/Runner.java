package dodge.core;

public class Runner implements Runnable {
	public Thread thread;
	public boolean running;

	public int framerate;

	public double fps;
	public int ticks;

	public double delta;
	public double lastTime;

	public IRunnerHandle handle;

	public Runner(IRunnerHandle handle) {
		this.thread = new Thread(this);
		this.running = false;
		this.framerate = 60;
		this.fps = 0;
		this.ticks = 0;
		this.delta = 0;
		this.lastTime = System.currentTimeMillis();
		this.handle = handle;
	}

	public int getFPS() {
		return (int)Math.round(this.fps);
	}

	public void bindHandle(IRunnerHandle handle) {
		this.handle = handle;
	}

	// ==== Start/Stop ==== //

	public synchronized void start() {
		this.thread.start();
		this.running = true;
	}

	public void stop() {
		this.running = false;

		try {
			this.thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	// ==== Loop ==== //

	public void run() {
		while (this.running) {
			this.handle.loop();

			double now = System.currentTimeMillis();
			this.delta = (now - this.lastTime);
			this.lastTime = System.currentTimeMillis();
			this.fps = 1000 / this.delta;

			this.ticks++;
			
			try {
				Thread.sleep(1000 / this.framerate);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}