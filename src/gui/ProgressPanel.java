package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import utils.*;

public class ProgressPanel extends JPanel implements ItemListener {
    JPanel cards = new JPanel();
    JPanel comboBoxPane;

    public ProgressPanel() throws Exception {
        ArrayList<GoalContainer> goals = DataHandler.readGoalElements();
        // implement goal selector
        setBackground(Color.DARK_GRAY);
        setLayout(new BorderLayout());
        JPanel Logpanel = new JPanel();
        LogPane log = new LogPane(goals);

        add(Logpanel, BorderLayout.LINE_START);
        Logpanel.add(log);
        Logpanel.setVisible(true);
        JScrollPane scrollPane = new JScrollPane(log);

        scrollPane.setPreferredSize(utils.ComponentPercentage(30, 82));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        Logpanel.add(scrollPane);

        cards = new JPanel(new CardLayout());
        comboBoxPane = new JPanel();
        JComboBox cb = new JComboBox();
        for (GoalContainer goal : goals) {
            JPanel Graphpanel = new JPanel();
            GraphPanel graph = new GraphPanel(DataHandler.readReflectionElements(goal.Goal));
            Graphpanel.add(graph);
            JScrollPane scrollPane1 = new JScrollPane(graph);
            scrollPane1.setPreferredSize(utils.ComponentPercentage(65, 82));
            scrollPane1.getVerticalScrollBar().setUnitIncrement(20);
            Graphpanel.add(scrollPane1, BorderLayout.CENTER);
            cb.addItem(goal.Goal);
            cards.add(Graphpanel, goal.Goal);
        }
        cb.addItemListener(this);
        comboBoxPane.add(cb);
        add(comboBoxPane, BorderLayout.PAGE_START);
        add(cards, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, (String) evt.getItem());
    }
}