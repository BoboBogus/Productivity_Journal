import java.awt.Color;

import javax.swing.*;
import java.awt.*;
import gui.*;
import utils.*;

public class AppFrame extends JFrame {
    public AppFrame() {
        setSize(100, 100);
        setBackground(Color.DARK_GRAY);
        JournalPanel Journal = new JournalPanel();
        GraphPanel Graph = new GraphPanel();
        JTabbedPane Tabbed = new JTabbedPane();
        Tabbed.addTab("Graph", Graph);
        Tabbed.addTab("Journal", Journal);
        add(Tabbed);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new AppFrame();
        DataHandler.conn = DataHandler.getConnection();
    }
}