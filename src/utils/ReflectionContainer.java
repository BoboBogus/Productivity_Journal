package utils;

public class ReflectionContainer {
    static int count;
    String Date;
    String Goal;
    String Description;
    int stars;
    int difficulty;
    int points;

    int id;

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

    public ReflectionContainer(int id, String Date, String Goal, String Description, int stars, int difficulty) {
        this.id = id;
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
