import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScientificCalculator {
    private JFrame frame;
    private JPanel panel;
    private JTextField display;
    private JButton[] buttons;
    private Color[] buttonColors;

    public ScientificCalculator() {
        frame = new JFrame("Scientific Calculator");
        panel = new JPanel();
        display = new JTextField(20);
        buttons = new JButton[20];
        buttonColors = new Color[20];

        // Set initial button colors
        for (int i = 0; i < 20; i++) {
            buttonColors[i] = Color.WHITE;
        }

        // Set up GUI
        panel.setLayout(new GridLayout(5, 4, 5, 5));
        panel.add(display);

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C", "AC", "Color", "Exit"
        };

        for (int i = 0; i < 20; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setBackground(buttonColors[i]);
            panel.add(buttons[i]);

            final int index = i;
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    buttonClick(index);
                }
            });
        }

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    private void buttonClick(int index) {
        if (index == 18) { // Change color button
            Color color = JColorChooser.showDialog(null, "Select a color", buttonColors[index]);
            if (color != null) {
                buttonColors[index] = color;
                buttons[index].setBackground(buttonColors[index]);
            }
        } else if (index == 19) { // Exit button
            System.exit(0);
        } else {
            display.setText(display.getText() + buttons[index].getText());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ScientificCalculator();
            }
        });
    }
}
