import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Zadanie1 implements ActionListener {
    private JFrame frame;
    private JLabel label;
    private JButton button;

    public Zadanie1() {
        frame = new JFrame("Zadanie 1");
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 80);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("taki o label");

        button = new JButton("Kliknij mnie!");
        button.addActionListener(this);

        frame.add(label);
        frame.add(button);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        label.setText("Hello world!");
    }

    public static void main(String[] args) {
        new Zadanie1();
    }
}