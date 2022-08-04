package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DataHandler {
    static int GoalComponents = 2;
    static int ReflectionComponents = 3;

    // Create New Goal in the txt file
    public static void CreateNewGoal(GoalContainer container) throws IOException {
        File file = new File("data/Goal_Data.txt");
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write(container.Date + "\n");
        fileWriter.write(container.Goal + "\n");
        fileWriter.write(container.Difficulty + "\n");
    }

    public static void CreateNewReflection(ReflectionContainer container) throws IOException {
        File file = new File("data/Goal_Data.txt");
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write(container.Date + "\n");
        fileWriter.write(container.Goal + "\n");
        fileWriter.write(container.Description + "\n");
        fileWriter.write(container.stars + "\n");
        fileWriter.write(container.points + "\n");
    }

    public static void readElements(int lineStart) {

    }

    public static String getValue(String data, int index) {
        int chosenIndex = 0;
        int followUp = data.length();
        int indexCheck = 0;
        boolean first = false;
        // fix the :recognition
        // if zero get (0):0:0:0

        if (index == -1) {
            chosenIndex = 0;
            first = false;
        }
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == '=') {
                if (indexCheck == index && !first) {
                    chosenIndex = i + 1;
                }
                if (indexCheck == index + 1) {
                    followUp = i;
                }
                indexCheck++;
            }
        }
        String result = "";
        return result;
    }
}
