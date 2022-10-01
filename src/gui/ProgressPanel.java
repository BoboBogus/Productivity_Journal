package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import utils.*;

public class ProgressPanel extends JPanel {

    public ProgressPanel() throws Exception {
        ArrayList<GoalContainer> goals = DataHandler.readGoalElements();
        // implement goal selector
        setBackground(Color.DARK_GRAY);
        setLayout(new BorderLayout());
        JPanel Logpanel = new JPanel();
        LogPane log = new LogPane(goals);
        // temporary ********************************* goal selector
        GraphPanel graph = new GraphPanel(DataHandler.readReflectionElements("testi"));

        add(Logpanel, BorderLayout.LINE_START);
        Logpanel.add(log);
        Logpanel.setVisible(true);
        add(graph, BorderLayout.CENTER);
        JScrollPane scrollPane = new JScrollPane(log);

        scrollPane.setPreferredSize(utils.ComponentPercentage(30, 85));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        Logpanel.add(scrollPane);
        setVisible(true);
    }
}