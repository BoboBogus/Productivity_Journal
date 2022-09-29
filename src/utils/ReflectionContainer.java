package utils;

public class ReflectionContainer {
    public String Date;
    String User;
    String Goal;
    public String Description;
    public int stars;
    int difficulty;
    int points;

    public ReflectionContainer(String User, String Date, String Goal, String Description, int stars,
            int difficulty) {
        this.Date = Date;
        this.Goal = Goal;
        this.Description = Description;
        this.stars = stars;
        this.difficulty = difficulty;

        // difficulty x stars conversion rate
        points = stars * difficulty;
    }

    public void SaveReflectionContainer() throws Exception {
        DataHandler.CreateNewReflection(this);
    }
}
