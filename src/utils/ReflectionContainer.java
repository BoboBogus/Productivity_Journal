package utils;

public class ReflectionContainer {
    static int count;
    String Date;
    String Goal;
    String Description;
    int stars;
    int difficulty;
    int points;

    public ReflectionContainer(String Date, String Goal, String Description, int stars, int difficulty) {
        this.Date = Date;
        this.Goal = Goal;
        this.Description = Description;
        this.stars = stars;
        this.difficulty = difficulty;

        // difficulty x stars conversion rate
        points = stars * difficulty;
        count++;
    }

    public void SaveReflectionContainer() throws Exception {
        DataHandler.CreateNewReflection(this);
    }
}
