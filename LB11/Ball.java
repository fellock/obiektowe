import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ball extends JLabel {
	private int x, y, xVelocity, yVelocity;
	public static int size = 16;
	public static int speed = 1;

	public Ball(Paddle paddle, int index) {
		init(paddle, index);
	}

	private void init(Paddle paddle, int index) {
		setIcon(new ImageIcon("ball.png"));
		this.x = (int) (paddle.getX() + paddle.getWidth() / Globals.BALL_COUNT * index);
		this.y = (int) (paddle.getY() - 20);
		this.xVelocity = speed;
		this.yVelocity = -speed;
		setBounds(this.x, this.y, size, size);
	}

	public void update() {
		this.x += xVelocity;
		this.y += yVelocity;

		if (x == 0) {
			setxVelocity(speed);
		}

		if (x == Globals.SCREEN_WIDTH - size) {
			setxVelocity(-speed);
		}

		if (y == 0) {
			setyVelocity(speed);
		}

		setBounds(this.x, this.y, size, size);
	}

	public void setxVelocity(int xVelocity) {
		this.xVelocity = xVelocity;
	}

	public void setyVelocity(int yVelocity) {
		this.yVelocity = yVelocity;
	}

	public int getyVelocity() {
		return yVelocity;
	}
}
