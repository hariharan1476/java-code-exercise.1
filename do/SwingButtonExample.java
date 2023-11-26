import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class SwingButtonExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Example");
        JButton yesButton = new JButton("Yes");
        JButton noButton = new JButton("No");
        JButton closeButton = new JButton("Close");
        JLabel label = new JLabel();

        frame.setLayout(new FlowLayout());
        frame.add(yesButton);
        frame.add(noButton);
        frame.add(closeButton);
        frame.add(label);

        yesButton.addActionListener(e -> label.setText("Button Yes is pressed"));
        noButton.addActionListener(e -> label.setText("Button No is pressed"));
        closeButton.addActionListener(e -> System.exit(0));

        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
