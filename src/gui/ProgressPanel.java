package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import utils.*;

public class ProgressPanel extends JPanel {

    public ProgressPanel() throws Exception {
        setBackground(Color.DARK_GRAY);
        setLayout(new BorderLayout());
        JPanel Logpanel = new JPanel();
        LogPane log = new LogPane();
        GraphPanel graph = new GraphPanel();

        add(Logpanel, BorderLayout.LINE_START);
        Logpanel.add(log);
        Logpanel.setVisible(true);
        add(graph, BorderLayout.CENTER);
        JScrollPane scrollPane = new JScrollPane(log);

        scrollPane.setPreferredSize(new Dimension(300, 500));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        Logpanel.add(scrollPane);
        setVisible(true);
    }
}