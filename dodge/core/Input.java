package dodge.core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class Input implements KeyListener {

	private static HashMap<String, Boolean> keys = new HashMap<>();

	public static boolean isKeyDown(String key) {
		if (!Input.keys.containsKey(key)) {
			return false;
		}

		return Input.keys.get(key);
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {
		Input.keys.put(KeyEvent.getKeyText(e.getKeyCode()), true);
	}

	public void keyReleased(KeyEvent e) {
		Input.keys.put(KeyEvent.getKeyText(e.getKeyCode()), false);
	}
	
}
