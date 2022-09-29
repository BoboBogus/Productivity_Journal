package gui;

import javax.swing.*;
import java.awt.*;

public class ReflectionPanel extends JPanel {
    public ReflectionPanel(String date, String description, int stars) {
        setBackground(Color.GRAY);
        setVisible(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addComponent(date, this);
        addComponent(description, this);

    }

    private static void addComponent(String text, Container container) {
        JTextField Text = new JTextField("\t\t" + text);
        Text.setEditable(false);
        Text.setFont(new Font("Serif", Font.ITALIC, 10));
        Text.setAlignmentX(Component.LEFT_ALIGNMENT);
        container.add(Text);
    }
}
