package utils;

public class GoalContainer {
    static int count;
    String Date;
    String Goal;
    int Difficulty;

    public GoalContainer(String Date, String Goal, int Difficulty) {
        this.Date = Date;
        this.Goal = Goal;
        this.Difficulty = Difficulty;
        count++;
    }

    public void CreateNewGoal() throws Exception {
        DataHandler.CreateNewGoal(this);
    }
}
