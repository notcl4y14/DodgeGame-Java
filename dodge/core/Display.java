package dodge.core;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Display extends Canvas {
	public BufferStrategy buffer;

	public Display() {
		// Prevent keyboard listener from not working
		this.setFocusable(false);
	}

	public void init() {
		this.createBufferStrategy(2);
		this.buffer = getBufferStrategy();
	}

	public Graphics2D getGraphics() {
		return (Graphics2D) this.buffer.getDrawGraphics();
	}

	public void present() {
		this.buffer.show();
	}
}
