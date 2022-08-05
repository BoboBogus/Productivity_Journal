package gui;

import javax.swing.*;

import utils.ReflectionContainer;

import java.awt.*;

public class Submission extends JPanel {
    JTextArea reflection;
    JButton star1;
    JButton star2;
    JButton star3;
    JButton star4;
    JButton star5;
    int rating = 0; // accessed later

    public Submission(String name) {
        setName(name);
        setBackground(Color.lightGray);
        reflection = new JTextArea();
        add(reflection);
        reflection.setBounds(125, 45, 1650, 820);
        reflection.setFont(new Font("Hiragino Kaku Gothic Pro", Font.PLAIN, 22));
        reflection.setBackground(Color.decode("#2e353c"));
        reflection.setForeground(Color.decode("#fbfbfb"));

        // Star rating buttons
        star1 = new JButton();
        star2 = new JButton();
        star3 = new JButton();
        star4 = new JButton();
        star5 = new JButton();
        star1.addActionListener(e -> rating = 1);
        star2.addActionListener(e -> rating = 2);
        star3.addActionListener(e -> rating = 3);
        star4.addActionListener(e -> rating = 4);
        star5.addActionListener(e -> rating = 5);
        add(star1);
        add(star2);
        add(star3);
        add(star4);
        add(star5);
        star1.setBounds(1150, 892, 30, 30);

        // switch statement for every case of rating (for example: if the fifth star is
        // pressed, all of the other stars must also be activated)
        switch (rating) {
            case 1:
                star1.setBackground(Color.decode("#ede35a"));
                break;
            case 2:
                star1.setBackground(Color.decode("#ede35a"));
                star2.setBackground(Color.decode("#ede35a"));
                break;
            case 3:
                star1.setBackground(Color.decode("#ede35a"));
                star2.setBackground(Color.decode("#ede35a"));
                star3.setBackground(Color.decode("#ede35a"));
                break;
            case 4:
                star1.setBackground(Color.decode("#ede35a"));
                star2.setBackground(Color.decode("#ede35a"));
                star3.setBackground(Color.decode("#ede35a"));
                star4.setBackground(Color.decode("#ede35a"));
                break;
            case 5:
                star1.setBackground(Color.decode("#ede35a"));
                star2.setBackground(Color.decode("#ede35a"));
                star3.setBackground(Color.decode("#ede35a"));
                star4.setBackground(Color.decode("#ede35a"));
                star5.setBackground(Color.decode("#ede35a"));
                break;
        }
        // Rating Label
        JLabel rate = new JLabel();
        rate.setText("Rate how you did:");
        rate.setBounds(1000, 892, 180, 35);
        rate.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(rate);

        // Submit button
        JButton submit = new JButton("Submit");
        submit.setBackground(Color.GREEN);
        submit.setForeground(Color.WHITE);
        add(submit);
        submit.setFont(new Font("Times New Roman", Font.BOLD, 18));
        submit.setBounds(1575, 870, 200, 70);
        submit.addActionListener(e -> Submit());
        setLayout(null);
        setVisible(true);
    }

    void Submit() {
        ReflectionContainer container = new ReflectionContainer("8/4/2022", this.getName(), reflection.getText(),
                rating, 0);
        container.SaveReflectionContainer();
    }
}
