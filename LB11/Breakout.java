import javax.swing.JFrame;

public class Breakout extends JFrame {

	public Breakout() {
		init();
	}

	private void init() {
		add(new Board(this));
		setTitle("Breakout");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new Breakout();
	}
}
