import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class Zadanie3 {
	private JFrame frame;
	private JMenuBar menuBar;
	private JToolBar toolBar;
	private JTextArea textArea;

	public Zadanie3() {
		frame = new JFrame("Zadanie 3");
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menuBar = new JMenuBar();
		menuBar.setAlignmentX(JMenuBar.LEFT_ALIGNMENT);

		JMenu menu = new JMenu("File");

		JMenuItem closeMenuItem = new JMenuItem("Close");
		closeMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		JMenuItem openMenuItem = new JMenuItem("Open");
		openMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog fileDialog = new FileDialog(frame, "Choose a file", FileDialog.LOAD);
				fileDialog.setVisible(true);
				String filename = fileDialog.getFile();
				if (filename != null) {
					try {
						textArea.read(new BufferedReader(new FileReader(filename)), null);
						textArea.requestFocus();
					} catch (Exception x) {
						x.printStackTrace();
					}
				}
			}
		});

		JMenuItem saveAsMenuItem = new JMenuItem("Save as");
		saveAsMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog fileDialog = new FileDialog(frame, "Save a file", FileDialog.SAVE);
				fileDialog.setVisible(true);
				String filename = fileDialog.getFile();
				if (filename != null) {
					try {
						textArea.write(new FileWriter(fileDialog.getFile()));
					} catch (Exception x) {
						x.printStackTrace();
					}
				}
			}
		});

		menu.add(openMenuItem);
		menu.add(saveAsMenuItem);
		menu.add(closeMenuItem);
		menuBar.add(menu);

		toolBar = new JToolBar();
		toolBar.setAlignmentX(JToolBar.LEFT_ALIGNMENT);

		textArea = new JTextArea();
		textArea.setAlignmentX(JTextArea.LEFT_ALIGNMENT);

		frame.add(menuBar);
		frame.add(toolBar);
		frame.add(textArea);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Zadanie3();
	}
}
