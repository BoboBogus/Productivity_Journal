import javax.swing.*;
import gui.*;

public class AppFrame extends JFrame {
    public AppFrame() {
        setSize(100, 100);
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

    public static void main(String[] args) {
        new AppFrame();
    }
}