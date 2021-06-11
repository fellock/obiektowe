import javax.swing.JFrame;

public class TicTacToe extends JFrame {
	public TicTacToe() {
		System.out.println("Launching game...");
		init();
	}

	private void init() {
		add(new Lobby(this));
		setTitle("TicTacToe");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new TicTacToe();
	}
}
