package utils;

public class GoalContainer {
    String Date;
    String Goal;
    int Difficulty;

    public GoalContainer(String Date, String Goal, int Difficulty) {
        this.Date = Date;
        this.Goal = Goal;
        this.Difficulty = Difficulty;
    }

    public void CreateNewGoal() {
        DataHandler.CreateNewGoal(this);
    }
}
