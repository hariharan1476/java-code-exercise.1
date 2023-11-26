import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingChoiceListExample {
    public static void main(String[] args) {
        // Create a frame
        JFrame frame = new JFrame("Choice List Example");

        // Create labels and text fields
        JLabel subjectLabel = new JLabel("Select subject:");
        JTextField subjectTextField = new JTextField(20);

        JLabel nameLabel = new JLabel("Select name:");
        JTextField nameTextField = new JTextField(20);

        // Create choice lists (combo boxes)
        String[] subjects = {"Math", "Science", "English", "History"};
        JComboBox<String> subjectList = new JComboBox<>(subjects);

        String[] names = {"Alice", "Bob", "Charlie", "David"};
        JComboBox<String> nameList = new JComboBox<>(names);

        // Add action listeners to the choice lists
        subjectList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedSubject = (String) subjectList.getSelectedItem();
                subjectTextField.setText(selectedSubject);
            }
        });

        nameList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedName = (String) nameList.getSelectedItem();
                nameTextField.setText(selectedName);
            }
        });

        // Set layout manager
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // Add components to the frame
        frame.add(subjectLabel);
        frame.add(subjectList);
        frame.add(subjectTextField);

        frame.add(nameLabel);
        frame.add(nameList);
        frame.add(nameTextField);

        // Set frame properties
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
