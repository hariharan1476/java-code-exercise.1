import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Application");
        frame.setSize(300, 150);
        JPanel panel = new JPanel();
        frame.add(panel);

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(15);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(15);
        JButton loginButton = new JButton("Login");

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            JOptionPane.showMessageDialog(frame, (username.equals("Karunya") && password.equals("Karunya")) ? "Login Successful" : "Login failed");
            passwordField.setText("");
        });
        frame.setVisible(true);
    }
}

