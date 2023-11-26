import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class A101 extends JFrame {
    private JRadioButton javaRadioButton;
    private JRadioButton aspNetRadioButton;
    private JRadioButton sqlRadioButton;
    private ButtonGroup radioButtonGroup;

    public A101() {
        setTitle("Radio Button Demo");
        setLayout(new FlowLayout());

        javaRadioButton = new JRadioButton("Java");
        aspNetRadioButton = new JRadioButton("ASP.net");
        sqlRadioButton = new JRadioButton("SQL");
        
        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(javaRadioButton);
        radioButtonGroup.add(aspNetRadioButton);
        radioButtonGroup.add(sqlRadioButton);

        add(javaRadioButton);
        add(aspNetRadioButton);
        add(sqlRadioButton);

        javaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMessage("You selected Java.");
            }
        });

        aspNetRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMessage("You selected ASP.net.");
            }
        });

        sqlRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMessage("You selected SQL.");
            }
        });

        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new A101();
            }
        });
    }
}
