import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements MouseMotionListener {
	private int mouseX;
	private Timer timer;
	private Ball ball;
	private Paddle paddle;
	private Brick[] bricks;
	private JFrame frame;

	public Board(JFrame frame) {
		init(frame);
	}

	private void init(JFrame frame) {
		this.frame = frame;
		addMouseMotionListener(this);
		setLayout(null);
		setFocusable(true);
		setPreferredSize(new Dimension(Globals.SCREEN_WIDTH, Globals.SCREEN_HEIGHT));
		setBackground(Color.black);
		setOpaque(true);
		startGame();
	}

	private void startGame() {
		bricks = new Brick[Globals.BRICKS_COLUMNS * Globals.BRICKS_ROWS];

		int n = 0;
		for (int c = 0; c < Globals.BRICKS_ROWS; c++) {
			for (int r = 0; r < Globals.BRICKS_COLUMNS; r++) {
				bricks[n] = new Brick(Globals.SCREEN_WIDTH * 0.05 + r * Brick.width, Globals.SCREEN_HEIGHT * 0.05 + c * Brick.height, 0.8f / (float) Globals.BRICKS_ROWS * c);
				add(bricks[n]);
				n++;
			}
		}

		paddle = new Paddle();
		ball = new Ball(paddle);

		add(ball);
		add(paddle);

		timer = new Timer(1000 / Globals.TICK_RATE, new GameCycle());
		timer.start();
	}

	private class GameCycle implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			doGameCycle();
		}
	}

	private void checkOver() {
		int alive = 0;
		for (Brick brick : bricks) {
			if (brick.isAlive()) {
				alive++;
			}
		}
		if (alive == 0) {
			frame.setTitle("VICTORY!");
		} else {
			if (ball.getY() > Globals.SCREEN_HEIGHT) {
				frame.setTitle("GAME OVER");
			}
		}

	}

	private void doGameCycle() {
		checkOver();
		ball.update();
		paddle.update(mouseX);
		checkCollision();
		repaint();
	}

	private void checkCollision() {
		if ((ball.getBounds(null).intersects(paddle.getBounds(null)))) {

			int paddleLeft = (int) paddle.getBounds(null).getMinX();
			int ballCenter = (int) (ball.getBounds(null).getMinX() + Ball.size/2f);

			if (ballCenter >= paddleLeft && ballCenter < paddleLeft + paddle.getWidth() / 3) {
				ball.setxVelocity(-1);
			} else if (ballCenter >= paddleLeft + paddle.getWidth()/3 && ballCenter < paddleLeft + paddle.getWidth() / 3 * 2) {
				ball.setxVelocity(0);
			} else {
				ball.setxVelocity(1);
			}

			ball.setyVelocity(-1);
		}

		for (int i = 0; i < Globals.BRICKS_COLUMNS * Globals.BRICKS_ROWS;i++) {

            if ((ball.getBounds(null)).intersects(bricks[i].getBounds(null))) {

                int ballLeft = (int) ball.getBounds(null).getMinX();
                int ballHeight = (int) ball.getBounds(null).getHeight();
                int ballWidth = (int) ball.getBounds(null).getWidth();
                int ballTop = (int) ball.getBounds(null).getMinY();

                var pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
                var pointLeft = new Point(ballLeft - 1, ballTop);
                var pointTop = new Point(ballLeft, ballTop - 1);
                var pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);

                if (bricks[i].isAlive()) {

                    if (bricks[i].getBounds(null).contains(pointRight)) {
                        ball.setxVelocity(-1);
                    } else if (bricks[i].getBounds(null).contains(pointLeft)) {
                        ball.setxVelocity(1);
                    }
                    if (bricks[i].getBounds(null).contains(pointTop)) {
                        ball.setyVelocity(1);
                    } else if (bricks[i].getBounds(null).contains(pointBottom)) {
                        ball.setyVelocity(-1);
                    }
                    bricks[i].damage();
                } else {
					bricks[i].setVisible(false);
				}
            }
        }
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseMoved(e);
	}
}
