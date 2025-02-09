package dodge;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import dodge.common.Controller;
import dodge.common.SceneManager;
import dodge.core.Display;
import dodge.core.IRunnerHandle;
import dodge.core.Input;
import dodge.core.Runner;
import dodge.core.Window;
import dodge.entity.World;
import dodge.level.Level;
import dodge.level.LevelScript;

public class Dodge implements IRunnerHandle {
	public Window window;
	Display display;
	public Runner runner;
	SceneManager sceneManager;

	public Level level;
	public World world;
	public Controller controller;

	public Dodge() {
		this.initCore();
		this.initCommon();

		level = new Level();
		world = new World(256);
		controller = new Controller(null);

		LevelScript script = new LevelScript(4);
		script.codeData[0] = 1;
		script.codeData[1] = 2;
		script.codeData[2] = 100;
		script.codeData[3] = 10;

		level.lengthTime = 1000 * 5;
		level.setWorld(world);
		level.loadScript(script);
	}

	// ==== Initialize ==== //
	private void initCore() {
		this.window = new Window("Dodge", 800, 600);
		this.display = new Display();
		this.runner = new Runner(this);
		
		window.setVisible(true);
		window.addKeyListener(new Input());
		window.add(display);
		display.init();
	}

	private void initCommon() {
		this.sceneManager = new SceneManager(this);

		this.sceneManager.addScene(new dodge.scenes.Boot());
		this.sceneManager.addScene(new dodge.scenes.MainMenu());
		this.sceneManager.addScene(new dodge.scenes.SceneLevel());

		this.sceneManager.loadScene("boot");
	}

	// ==== Scene ==== //
	public boolean loadScene(String name) {
		return this.sceneManager.loadScene(name);
	}

	// ==== Start/Stop ==== //
	public void start() {
		runner.start();
	}

	public void stop() {
		runner.stop();
	}

	// ==== Update/Render ==== //
	public void update() {
		this.sceneManager.update();
	}

	public void render() {
		Graphics2D graphics = this.display.getGraphics();

		// Initialize graphics
		graphics.setFont( new Font("Arial", Font.PLAIN, 12) );
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		// Render the scene
		this.sceneManager.render(graphics);

		// Draw FPS
		graphics.setColor( Color.white );
		graphics.drawString("FPS: " + this.runner.getFPS(), 0, 10);
		graphics.drawString("Scene: " + this.sceneManager.currentScene.name, 0, 20);
		graphics.drawString("Level Time: " + (System.currentTimeMillis() - this.level.startTime) + "/" + this.level.lengthTime, 0, 30);
		graphics.drawString("Level Finished: " + this.level.finished, 0, 40);

		this.display.present();
		graphics.dispose();
	}

	// ==== Loop ==== //
	public void loop() {
		this.update();
		this.render();

		// System.out.println("FPS: " + this.runner.getFPS());
	}

	// ==== Main ==== //
	public static void main(String[] args) {
		Dodge dodge = new Dodge();
		dodge.start();
	}
}