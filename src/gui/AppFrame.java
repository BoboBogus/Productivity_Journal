package gui;

import java.awt.Color;

import javax.swing.*;
import java.awt.*;
import gui.*;
import utils.*;

public class AppFrame extends JFrame {
    public AppFrame() throws Exception {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(values.windowX, values.windowY));
        setBackground(Color.DARK_GRAY);
        JournalPanel Journal = new JournalPanel();
        ProgressPanel Graph = new ProgressPanel();
        JTabbedPane Tabbed = new JTabbedPane();
        Tabbed.addTab("Progress", Graph);
        Tabbed.addTab("Journal", Journal);
        Tabbed.setSize(900, 500);
        add(Tabbed, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}