package gui;
import javax.swing.*;

public class JournalPanel extends JPanel 
{
    public void journal()
    {
        //Main GUI vars for submission page
            //Goal Selection
        String[] goals = {"test", "test1"};
        JComboBox<String> goalSelection = new JComboBox<String>(goals);
        add(goalSelection);
        goalSelection.setBounds(20,15,90,20);

            //Submission text area
        JTextArea reflection = new JTextArea();
        add(reflection);
        reflection.setBounds(20, 30, 120, 50);

            //Star rating buttons
        JButton star1 = new JButton(); JButton star2 = new JButton(); JButton star3 = new JButton();
        JButton star4 = new JButton(); JButton star5 = new JButton();
        add(star1); add(star2); add(star3); add(star4); add(star5);

            //Rating Label
        JLabel rate = new JLabel();
        rate.setText("Rate how you did:");
        rate.setBounds(40, 180, 50, 30);
        add(rate);
    }
}
