package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import utils.GoalContainer;

public class JournalPanel extends JPanel implements ItemListener {
    JPanel cards;
    JComboBox goalSelection;
    String CurrGoal;
    JTextField GoalName;
    JTextField GoalDifficulty;
    int FrameCount = 1;
    String[] goals = new String[1];
    JPanel comboBoxPane;

    public JournalPanel() {
        // Main GUI vars for submission page
        // Goal SelectionSystem.out.println(FrameCount);
        goals[0] = "Create Goal";
        comboBoxPane = new JPanel();
        goalSelection = new JComboBox(goals);
        System.out.println(goalSelection);
        cards = new JPanel(new CardLayout());
        JPanel newGoalPane = new JPanel();
        createFrameNew(newGoalPane);
        cards.add(newGoalPane, goals[0]);

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

    public void createFrameNew(JPanel pane) {
        JLabel label = new JLabel("Input Goal Name");
        GoalName = new JTextField();
        JLabel label2 = new JLabel("Input Difficulty ranges 1-5");
        GoalDifficulty = new JTextField();

        JButton button = new JButton("Create New Goal");
        button.addActionListener(e -> createNewGoal());

        GoalName.setSize(new Dimension(100, 100));
        GoalDifficulty.setSize(new Dimension(50, 100));
        pane.add(label, BorderLayout.CENTER);
        pane.add(button, BorderLayout.CENTER);
        pane.add(GoalName, BorderLayout.NORTH);
        pane.add(GoalDifficulty, BorderLayout.NORTH);
        pane.add(label2, BorderLayout.CENTER);
        setLayout(null);
    }

    void createNewGoal() {
        System.out.println(GoalName.getText());
        JPanel card = new Submission(GoalName.getText());
        card.setPreferredSize(new Dimension(1900, 1000));
        cards.add(card, GoalName.getText());
        goalSelection.addItem(GoalName.getText());

        GoalContainer container = new GoalContainer("8/4/2022", GoalName.getText(),
                Integer.parseInt(GoalDifficulty.getText()));
        container.CreateNewGoal();
    }

    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, (String) evt.getItem());
    }
}
