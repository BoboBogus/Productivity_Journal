package gui;

import javax.swing.*;

import utils.*;

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
        setLayout(new BorderLayout());
        setSize(utils.ComponentPercentage(50, 50));
        setName(name);
        setBackground(Color.lightGray);
        reflection = new JTextArea();
        add(reflection, BorderLayout.CENTER);
        reflection.setFont(new Font("Hiragino Kaku Gothic Pro", Font.PLAIN, 22));
        reflection.setBackground(Color.decode("#2e353c"));
        reflection.setForeground(Color.decode("#fbfbfb"));

        ratingPanel rating = new ratingPanel();
        add(rating, BorderLayout.PAGE_END);

        // Submit button
        JButton submit = new JButton("Submit");
        submit.setBackground(Color.GREEN);
        submit.setForeground(Color.WHITE);
        add(submit, BorderLayout.EAST);
        submit.setFont(new Font("Times New Roman", Font.BOLD, 18));
        submit.addActionListener(e -> {
            try {
                Submit();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        setVisible(true);
    }

    void Submit() throws Exception {
        if (rating == 0) {
            DataHandler.Alert("please rate your productivity");
            return;
        }
        ReflectionContainer container = new ReflectionContainer(DataHandler.user, DataHandler.date, this.getName(),
                reflection.getText(), rating, DataHandler.readGoalElementsName(this.getName()).Difficulty);
        container.SaveReflectionContainer();
    }

    private class ratingPanel extends JPanel {
        public ratingPanel() {
            // Rating Label ***************************** needs to be overhauled
            setBackground(Color.DARK_GRAY);
            JLabel rate = new JLabel();
            rate.setText("Rate how you did:");
            rate.setFont(new Font("Times New Roman", Font.BOLD, 18));
            add(rate, BorderLayout.PAGE_END);

            // Star rating buttons
            star1 = new JButton();
            star2 = new JButton();
            star3 = new JButton();
            star4 = new JButton();
            star5 = new JButton();
            star1.setBackground(Color.decode("#696969"));
            star2.setBackground(Color.decode("#696969"));
            star3.setBackground(Color.decode("#696969"));
            star4.setBackground(Color.decode("#696969"));
            star5.setBackground(Color.decode("#696969"));
            star1.addActionListener(e -> changeRating(1));
            star2.addActionListener(e -> changeRating(2));
            star3.addActionListener(e -> changeRating(3));
            star4.addActionListener(e -> changeRating(4));
            star5.addActionListener(e -> changeRating(5));
            add(star1, BorderLayout.PAGE_END);
            add(star2, BorderLayout.PAGE_END);
            add(star3, BorderLayout.PAGE_END);
            add(star4, BorderLayout.PAGE_END);
            add(star5, BorderLayout.PAGE_END);
            setVisible(true);
        }

        private void changeRating(int num) {
            rating = num;
            switch (rating) {
                case 1:
                    star1.setBackground(Color.decode("#ede35a"));
                    star2.setBackground(Color.decode("#696969"));
                    star3.setBackground(Color.decode("#696969"));
                    star4.setBackground(Color.decode("#696969"));
                    star5.setBackground(Color.decode("#696969"));
                    break;
                case 2:
                    star1.setBackground(Color.decode("#ede35a"));
                    star2.setBackground(Color.decode("#ede35a"));
                    star3.setBackground(Color.decode("#696969"));
                    star4.setBackground(Color.decode("#696969"));
                    star5.setBackground(Color.decode("#696969"));
                    break;
                case 3:
                    star1.setBackground(Color.decode("#ede35a"));
                    star2.setBackground(Color.decode("#ede35a"));
                    star3.setBackground(Color.decode("#ede35a"));
                    star4.setBackground(Color.decode("#696969"));
                    star5.setBackground(Color.decode("#696969"));
                    break;
                case 4:
                    star1.setBackground(Color.decode("#ede35a"));
                    star2.setBackground(Color.decode("#ede35a"));
                    star3.setBackground(Color.decode("#ede35a"));
                    star4.setBackground(Color.decode("#ede35a"));
                    star5.setBackground(Color.decode("#696969"));
                    break;
                case 5:
                    star1.setBackground(Color.decode("#ede35a"));
                    star2.setBackground(Color.decode("#ede35a"));
                    star3.setBackground(Color.decode("#ede35a"));
                    star4.setBackground(Color.decode("#ede35a"));
                    star5.setBackground(Color.decode("#ede35a"));
                    break;
            }
        }
    }
}
