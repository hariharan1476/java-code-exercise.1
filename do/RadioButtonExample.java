import javax.swing.*;
import java.awt.event.ActionEvent;

public class RadioButtonExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Radio Button Example");

        JRadioButton javaRadioButton = new JRadioButton("Java");
        JRadioButton aspNetRadioButton = new JRadioButton("ASP.NET");
        JRadioButton sqlRadioButton = new JRadioButton("SQL");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(javaRadioButton);
        buttonGroup.add(aspNetRadioButton);
        buttonGroup.add(sqlRadioButton);

        JLabel label = new JLabel("Select u r language:");

        javaRadioButton.addActionListener(e -> label.setText("Java is selected"));
        aspNetRadioButton.addActionListener(e -> label.setText("ASP.NET is selected"));
        sqlRadioButton.addActionListener(e -> label.setText("SQL is selected"));

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(javaRadioButton);
        frame.add(aspNetRadioButton);
        frame.add(sqlRadioButton);
        frame.add(label);

        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

