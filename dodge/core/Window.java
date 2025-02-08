package dodge.core;

import javax.swing.JFrame;
// import javax.swing.JPanel;

public class Window extends JFrame {
	public Window(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	// public void setSize(int width, int height) {
	// 	JPanel panel = new JPanel();
	// 	panel.setSize(width, height);

	// 	this.add(panel);
	// 	this.pack();
	// 	this.remove(panel);
	// }
}
