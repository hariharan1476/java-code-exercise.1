import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonActionGUI extends JFrame {

    private JLabel label;

    public ButtonActionGUI() {
        setTitle("Button Action Demo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createComponents();
        setupListeners();
        createLayout();
    }

    private void createComponents() {
        label = new JLabel("Press a button");
        JButton yesButton = new JButton("Yes");
        JButton noButton = new JButton("No");
        JButton closeButton = new JButton("Close");

        add(label);
        add(yesButton);
        add(noButton);
        add(closeButton);
    }

    private void setupListeners() {
        ActionListener buttonActionListener = e -> {
            JButton sourceButton = (JButton) e.getSource();
            String buttonText = sourceButton.getText();
            label.setText("Button " + buttonText + " is pressed");
        };

        for (Component component : getContentPane().getComponents()) {
            if (component instanceof JButton) {
                ((JButton) component).addActionListener(buttonActionListener);
            }
        }
    }

    private void createLayout() {
        setLayout(new FlowLayout());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ButtonActionGUI().setVisible(true));
    }
}
