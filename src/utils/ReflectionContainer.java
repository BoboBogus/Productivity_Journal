package utils;

public class ReflectionContainer {
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
    }

    public void SaveReflectionContainer() {
        DataHandler.CreateNewReflection(this);
    }
}
