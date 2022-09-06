package utils;

public class GoalContainer {
    static int count = 1;
    String Date;
    String User;
    public String Goal;
    int Difficulty;

    int id;

    public GoalContainer(String Date, String User, String Goal, int Difficulty) {
        this.id = count;
        this.Date = Date;
        this.User = User;
        this.Goal = Goal;
        this.Difficulty = Difficulty;
        count++;
    }

    public GoalContainer(int id, String Date, String Goal, int Difficulty) {
        this.id = id;
        this.Date = Date;
        this.Goal = Goal;
        this.Difficulty = Difficulty;
    }

    public void CreateNewGoal() throws Exception {
        DataHandler.CreateNewGoal(this);
    }
}
