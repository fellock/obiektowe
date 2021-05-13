import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
	private String filename = null;

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
				filename = fileDialog.getFile();
				if (filename != null) {
					try {
						frame.setTitle("Zadanie 3: " + filename);
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
				filename = fileDialog.getFile();
				if (filename != null) {
					try {
						frame.setTitle("Zadanie 3: " + filename);
						textArea.write(new FileWriter(filename));
					} catch (Exception x) {
						x.printStackTrace();
					}
				}
			}
		});

		JMenuItem saveMenuItem = new JMenuItem("Save");
		saveMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (filename != null) {
					try {
						textArea.write(new FileWriter(filename));
					} catch (Exception x) {
						x.printStackTrace();
					}
				} else {
					saveAsMenuItem.getActionListeners()[0].actionPerformed(e);
				}
			}
		});

		menu.add(openMenuItem);
		menu.add(saveMenuItem);
		menu.add(saveAsMenuItem);
		menu.add(closeMenuItem);
		menuBar.add(menu);

		toolBar = new JToolBar();
		toolBar.setAlignmentX(JToolBar.LEFT_ALIGNMENT);

		JButton openButton = new JButton(new ImageIcon("folder.png"));
		openButton.setToolTipText("Open a file");
		openButton.addActionListener(openMenuItem.getActionListeners()[0]);

		JButton saveButton = new JButton(new ImageIcon("disk.png"));
		saveButton.setToolTipText("Save current file");
		saveButton.addActionListener(saveMenuItem.getActionListeners()[0]);

		JButton saveAsButton = new JButton(new ImageIcon("disk_multiple.png"));
		saveAsButton.setToolTipText("Save as a new file");
		saveAsButton.addActionListener(saveAsMenuItem.getActionListeners()[0]);

		toolBar.add(openButton);
		toolBar.add(saveButton);
		toolBar.add(saveAsButton);

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
