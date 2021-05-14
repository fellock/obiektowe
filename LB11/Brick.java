import java.awt.Color;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Brick extends JPanel {
	private int x, y, health;
	public static int width, height;
	private float hue;

	public Brick(Double x, Double y, float hue) {
		init(x, y, hue);
	}

	private void init(Double x, Double y, float hue) {
		width = (int) (Globals.SCREEN_WIDTH * 0.90 / Globals.BRICKS_COLUMNS);
		height = (int) (Globals.SCREEN_HEIGHT * 0.5 / Globals.BRICKS_ROWS);
		this.x = x.intValue();
		this.y = y.intValue();
		this.health = Globals.BRICK_HEALTH;
		this.hue = hue;
		Random r = new Random();
		setBackground(Color.getHSBColor(this.hue, 0.75f + r.nextFloat() * 0.25f, 0.5f + health * 0.5f / Globals.BRICK_HEALTH));
		setBorder(BorderFactory.createRaisedBevelBorder());
		setBounds(this.x, this.y, width, height);
	}

	public boolean isAlive() {
		if (health < 0) {
			return false;
		} else {
			return true;
		}
	}

	public void damage() {
		health--;
		Random r = new Random();
		setBackground(Color.getHSBColor(hue, 0.75f + r.nextFloat() * 0.25f, 0.5f + health * 0.5f / Globals.BRICK_HEALTH));
	}
}
