package gui;
import java.awt.Color;

import javax.swing.*;

public class JournalPanel extends JPanel
{
    JButton star1; JButton star2; JButton star3; JButton star4; JButton star5;
    int rating; //accessed later

    public JournalPanel()
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
        reflection.setBounds(20, 30, 500, 400);
        reflection.setBackground(Color.BLACK);

            //Star rating buttons
        star1 = new JButton(); star2 = new JButton(); star3 = new JButton();
        star4 = new JButton(); star5 = new JButton();
        star1.addActionListener(e -> rating = 1); star2.addActionListener(e -> rating = 2); star3.addActionListener(e -> rating = 3);
        star4.addActionListener(e -> rating = 4); star5.addActionListener(e -> rating = 5);
        add(star1); add(star2); add(star3); add(star4); add(star5);

        //switch statement for every case of rating (for example: if the fifth star is pressed, all of the other stars must also be activated)
        switch (rating)
        {
            case 1:
                star1.setBackground(Color.BLACK);
            case 2:
                star1.setBackground(Color.BLACK); star2.setBackground(Color.BLACK);
            case 3:
                star1.setBackground(Color.BLACK); star2.setBackground(Color.BLACK); star3.setBackground(Color.BLACK);
            case 4:
                star1.setBackground(Color.BLACK); star2.setBackground(Color.BLACK); star3.setBackground(Color.BLACK); 
                star4.setBackground(Color.BLACK);
            case 5:
                star1.setBackground(Color.BLACK); star2.setBackground(Color.BLACK); star3.setBackground(Color.BLACK); 
                star4.setBackground(Color.BLACK); star5.setBackground(Color.BLACK);
        }
            //Rating Label
        JLabel rate = new JLabel();
        rate.setText("Rate how you did:");
        rate.setBounds(40, 180, 50, 30);
        add(rate);

            //allows items to not be in a specific layout
        setLayout(null);
    }
}
