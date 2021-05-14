import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Paddle extends JPanel {
	private int x, y;
	public static int width, height;
	private boolean alive;

	public Paddle() {
		init();
	}

	private void init() {
		width = Globals.PADDLE_WIDTH;
		height = Globals.PADDLE_HEIGHT;
		this.x = (int) (Globals.SCREEN_WIDTH / 2f - width / 2f);
		this.y = (int) (Globals.SCREEN_HEIGHT * 0.9f - height / 2f);
		alive = true;
		setBackground(Color.white);
		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),
				BorderFactory.createLoweredBevelBorder()));
		setBounds(this.x, this.y, width, height);
	}

	public void update(int mouseX) {
		this.x = (int) (mouseX - width / 2f);
		setBounds(this.x, this.y, width, height);
	}

	public boolean isAlive() {
		return alive;
	}

	public void destroy() {
		alive = false;
	}

}
