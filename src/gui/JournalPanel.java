package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import utils.*;

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
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout());
        goals[0] = "Create Goal";
        comboBoxPane = new JPanel();
        goalSelection = new JComboBox(goals);
        cards = new JPanel(new CardLayout());
        JPanel newGoalPane = new JPanel();
        createFrameNew(newGoalPane);
        cards.add(newGoalPane, goals[0]);

        try {
            loadGoals();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        goalSelection.addItemListener(this);
        comboBoxPane.add(goalSelection);
        goalSelection.setBounds(20, 15, 90, 20);
        comboBoxPane.setBackground(Color.DARK_GRAY);
        add(comboBoxPane, BorderLayout.PAGE_START);
        add(cards, BorderLayout.CENTER);

        // Submission text area
        // allows items to not be in a specific layout
        setVisible(true);
    }

    public void createFrameNew(JPanel pane) {
        JLabel label = new JLabel("Input Goal Name");
        GoalName = new JTextField();
        GoalName.setPreferredSize(new Dimension(70, 30));
        JLabel label2 = new JLabel("Input Difficulty ranges 1-5");
        GoalDifficulty = new JTextField();
        GoalDifficulty.setPreferredSize(new Dimension(70, 30));

        JButton button = new JButton("Create New Goal");
        button.addActionListener(e -> {
            try {
                createNewGoal();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });

        GoalName.setSize(new Dimension(100, 100));
        GoalDifficulty.setSize(new Dimension(50, 100));
        pane.add(label, BorderLayout.LINE_START);
        pane.add(button, BorderLayout.LINE_END);
        pane.add(GoalName, BorderLayout.NORTH);
        pane.add(GoalDifficulty, BorderLayout.NORTH);
        pane.add(label2, BorderLayout.LINE_START);
    }

    void createNewGoal() throws Exception {
        JPanel card = new Submission(GoalName.getText());
        cards.add(card, GoalName.getText());
        goalSelection.addItem(GoalName.getText());

        GoalContainer container = new GoalContainer(DataHandler.user, DataHandler.date, GoalName.getText(),
                Integer.parseInt(GoalDifficulty.getText()));
        container.CreateNewGoal();
    }

    void loadGoals() throws Exception {
        ArrayList<GoalContainer> containers = DataHandler.readGoalElements();
        for (GoalContainer container : containers) {
            JPanel card = new Submission(container.Goal);
            card.setBackground(Color.lightGray);
            cards.add(card, container.Goal);
            goalSelection.addItem(container.Goal);
        }
    }

    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, (String) evt.getItem());
    }
}
