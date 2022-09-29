package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import utils.*;

public class LogPane extends JPanel {
    GoalPanel goalPanel;

    public LogPane() throws Exception {
        setBackground(Color.BLACK);
        setVisible(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        ArrayList<GoalContainer> goals = DataHandler.readGoalElements();
        for (GoalContainer goal : goals) {
            String title = goal.Goal;
            String difficulty = String.valueOf(goal.Difficulty);
            String Date = goal.Date;
            goalPanel = new GoalPanel(title, difficulty, Date);

            ArrayList<ReflectionContainer> containers = DataHandler.readReflectionElements(title);
            for (ReflectionContainer container : containers) {
                String description = container.Description;
                String date = container.Date;
                int stars = container.stars;
                ReflectionPanel panel = new ReflectionPanel(date, description, stars);
                goalPanel.add(panel);
                this.revalidate();
            }
            add(goalPanel, BorderLayout.LINE_START);

        }

    }
}
