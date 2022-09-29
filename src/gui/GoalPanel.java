package gui;

import javax.swing.*;
import java.awt.*;

public class GoalPanel extends JPanel {
    public GoalPanel(String title, String difficulty, String Date) {
        setBackground(Color.GRAY);
        setVisible(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addComponent("Goal: " + title, this);
        addComponent("Difficulty: " + difficulty, this);
        addComponent("Date Started: " + Date, this);

    }

    private static void addComponent(String text, Container container) {
        JTextField Text = new JTextField(text);
        Text.setEditable(false);
        Text.setFont(new Font("Serif", Font.BOLD, 15));
        Text.setAlignmentX(Component.LEFT_ALIGNMENT);
        container.add(Text, BorderLayout.LINE_START);
    }
}
