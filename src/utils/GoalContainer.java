package utils;

public class GoalContainer {
    static int count = 1;
    public String Date;
    String User;
    public String Goal;
    public int Difficulty;

    int id;

    public GoalContainer(String User, String Date, String Goal, int Difficulty) {
        this.Date = Date;
        this.User = User;
        this.Goal = Goal;
        this.Difficulty = Difficulty;
        count++;
    }

    public void CreateNewGoal() throws Exception {
        DataHandler.CreateNewGoal(this);
    }
}
