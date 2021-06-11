import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.lang.Thread;

public class Lobby extends JPanel {
	private JFrame frame;
	private JLabel portLabel;
	private JTextField portField;
	private JButton createButton, joinButton;

	public Lobby(JFrame frame) {
		init(frame);
	}

	private void init(JFrame frame) {
		this.frame = frame;
		setLayout(null);
		setFocusable(true);
		setPreferredSize(new Dimension(Globals.SCREEN_WIDTH, Globals.SCREEN_HEIGHT));
		setBackground(Color.black);
		setOpaque(true);

		portField = new JTextField("14324");
		var portFieldWidth = Globals.SCREEN_WIDTH * 0.8f;
		var portFieldHeight = Globals.SCREEN_HEIGHT * 0.05f;
		portField.setBounds((int) (Globals.SCREEN_WIDTH / 2f - portFieldWidth / 2f),
				(int) (Globals.SCREEN_HEIGHT / 2f - portFieldHeight / 2f), (int) portFieldWidth, (int) portFieldHeight);
		add(portField);

		portLabel = new JLabel("Enter port: ");
		portLabel.setForeground(Color.WHITE);
		portLabel.setBounds(portField.getX(), portField.getY() - portField.getHeight(), portField.getWidth(),
				portField.getHeight());
		add(portLabel);

		createButton = new JButton(new createAction());
		createButton.setText("Create game");
		var createButtonWidth = Globals.SCREEN_WIDTH * 0.4f;
		var createButtonHeight = Globals.SCREEN_HEIGHT * 0.05f;
		createButton.setBounds((int) (Globals.SCREEN_WIDTH / 2f - createButtonWidth),
				(int) (Globals.SCREEN_HEIGHT / 2f + createButtonHeight), (int) createButtonWidth,
				(int) createButtonHeight);
		add(createButton);

		joinButton = new JButton(new joinAction());
		joinButton.setText("Join game");
		var joinButtonWidth = Globals.SCREEN_WIDTH * 0.4f;
		var joinButtonHeight = Globals.SCREEN_HEIGHT * 0.05f;
		joinButton.setBounds((int) (Globals.SCREEN_WIDTH / 2f), (int) (Globals.SCREEN_HEIGHT / 2f + joinButtonHeight),
				(int) joinButtonWidth, (int) joinButtonHeight);
		add(joinButton);
		System.out.println("Lobby initialized...");
	}

	private class createAction extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			int port = Integer.parseInt(portField.getText());
			System.out.println("Creating game on port " + port);
			new Thread() {
				public void run() {
					createServer(port);
				};
			}.start();
		}

	}

	private class joinAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			int port = Integer.parseInt(portField.getText());
			System.out.println("Joining game on port " + port);
		}
	}

	private void createServer(int port) {
		remove(portField);
		remove(createButton);
		remove(joinButton);
		portLabel.setText("Waiting for another player...");
		revalidate();
		repaint();
		Server server = new Server(port);
	}

}
