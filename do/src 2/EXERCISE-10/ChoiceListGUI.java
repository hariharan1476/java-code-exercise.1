import javax.swing.*;
import java.awt.*;
public class ChoiceListGUI extends JFrame {

    private Choice choiceList;
    private JTextField displayTextField;

    public ChoiceListGUI() {
        setTitle("Choice List Demo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createComponents();
        setupListeners();
        createLayout();
    }

    private void createComponents() {
        choiceList = new Choice();
        choiceList.add("Option 1");
        choiceList.add("Option 2");
        choiceList.add("Option 3");

        displayTextField = new JTextField(20);
        displayTextField.setEditable(false);
    }

    private void setupListeners() {
        choiceList.addItemListener(e -> displayTextField.setText(choiceList.getSelectedItem()));
    }

    private void createLayout() {
        setLayout(new FlowLayout());

        add(new JLabel("Choose an option:"));
        add(choiceList);
        add(new JLabel("Selected option:"));
        add(displayTextField);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ChoiceListGUI().setVisible(true));
    }
}
