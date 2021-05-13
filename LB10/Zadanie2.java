import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import static javax.swing.JOptionPane.showMessageDialog;

public class Zadanie2 implements ActionListener {
	private JFrame frame;
	private JPanel panel;
	private JTextField left, right, result;
	private JComboBox<String> comboBox;
	private JLabel label;
	private JButton button;

	public Zadanie2() {
		frame = new JFrame("Zadanie 2");
		frame.setLayout(new GridLayout(2, 1));
		frame.setSize(500, 160);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel(new GridLayout(1, 5));

		left = new JTextField(null);
		right = new JTextField(null);
		result = new JTextField(null);
		result.setEditable(false);

		String[] operations = new String[] { "+", "-", "*", "/" };
		comboBox = new JComboBox<>(operations);

		label = new JLabel("=");
		label.setHorizontalAlignment(SwingConstants.CENTER);

		panel.add(left);
		panel.add(comboBox);
		panel.add(right);
		panel.add(label);
		panel.add(result);

		button = new JButton("Oblicz");
		button.addActionListener(this);

		frame.add(panel);
		frame.add(button);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Double leftFactor = Double.parseDouble(left.getText());
		Double rightFactor = Double.parseDouble(right.getText());

		switch (comboBox.getSelectedItem().toString()) {
			case "+":
				result.setText(String.valueOf(leftFactor + rightFactor));
				break;
			case "-":
				result.setText(String.valueOf(leftFactor - rightFactor));
				break;
			case "*":
				result.setText(String.valueOf(leftFactor * rightFactor));
				break;
			case "/":
				if (rightFactor == 0) {
					showMessageDialog(frame, "ERROR: Nie dziel przez zero");
					result.setText("");
				} else {
					result.setText(String.valueOf(leftFactor / rightFactor));
				}
				break;
		}
	}

	public static void main(String[] args) {
		new Zadanie2();
	}
}
