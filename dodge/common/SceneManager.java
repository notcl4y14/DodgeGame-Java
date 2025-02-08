package dodge.common;

import java.awt.Graphics2D;
import java.util.HashMap;

import dodge.Dodge;

public class SceneManager {
	public HashMap<String, Scene> loadedScenes;
	public Scene currentScene;
	public Dodge handle;

	public SceneManager(Dodge handle) {
		this.loadedScenes = new HashMap<>();
		this.currentScene = null;
		this.handle = handle;
	}

	public Scene getScene(String name) {
		try {
			return this.loadedScenes.get(name);
		} catch (Exception e) {
			return null;
		}
	}

	public void addScene(Scene scene) {
		loadedScenes.put(scene.name, scene);
	}

	public boolean loadScene(String name) {
		Scene scene = this.getScene(name);

		if (scene == null) {
			return false;
		}

		this.currentScene = scene;
		this.currentScene.bindHandle(this.handle);
		this.currentScene.load();

		return true;
	}

	public void update() {
		this.currentScene.update();
	}

	public void render(Graphics2D graphics) {
		this.currentScene.render(graphics);
	}
}
