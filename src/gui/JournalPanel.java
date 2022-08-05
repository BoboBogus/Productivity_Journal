package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import utils.ReflectionContainer;

public class JournalPanel extends JPanel implements ItemListener {
    JPanel cards;
    JComboBox goalSelection;
    String CurrGoal;

    public JournalPanel() {
        // Main GUI vars for submission page
        // Goal Selection
        String[] goals = { "goalname" };
        JPanel comboBoxPane = new JPanel();
        goalSelection = new JComboBox(goals);
        cards = new JPanel(new CardLayout());
        JPanel card = new Submission("goalname");
        card.setPreferredSize(new Dimension(1900, 1080));
        cards.add(card, "goalname");

        goalSelection.addItemListener(this);
        comboBoxPane.add(goalSelection);
        goalSelection.setBounds(20, 15, 90, 20);
        comboBoxPane.setBackground(Color.DARK_GRAY);
        add(comboBoxPane, BorderLayout.PAGE_START);
        add(cards, BorderLayout.CENTER);

        // Submission text area
        setLayout(new FlowLayout());
        // allows items to not be in a specific layout
        setVisible(true);
    }

    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, (String) evt.getItem());
    }
}
