package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DataHandler {

    // Create New Goal in the txt file
    public static void CreateNewGoal(GoalContainer container) {
        try {
            File file = new File("data/Goal_Data.txt");
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(container.Date + "\n");
            fileWriter.write("Goal =" + container.Goal + "\n");
            fileWriter.write("Goal =" + container.Difficulty + "\n");
            fileWriter.write("\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void CreateNewReflection(ReflectionContainer container) {

        try {
            File file = new File("data/Reflection_Data.txt");
            System.out.println(file.getAbsolutePath());
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(container.Date + "\n");
            fileWriter.write("Goal =" + container.Goal + "\n");
            fileWriter.write("Description =" + container.Description + "\n");
            fileWriter.write("stars =" + container.stars + "\n");
            fileWriter.write("difficulty =" + container.difficulty + "\n");
            fileWriter.write("\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // outputs a GoalContainer based on the starting position of the text container
    // in the txt file
    public static GoalContainer readGoalElements(int lineStart) {
        String Date = "";
        String Goal = "";
        int Difficulty = -1;
        try {
            File data = new File("DATA/Goal_Data.txt");
            Scanner dataRead = new Scanner(data);
            for (int lineNum = 1; dataRead.hasNext(); lineNum++) {
                if (lineNum == lineStart) {
                    Date = getValue(dataRead.nextLine());
                }
                if (lineNum == lineStart + 1) {
                    Goal = getValue(dataRead.nextLine());
                }
                if (lineNum == lineStart + 2) {
                    Difficulty = Integer.parseInt(getValue(dataRead.nextLine()));
                }
            }
            dataRead.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        GoalContainer container = new GoalContainer(Date, Goal, Difficulty);
        return container;
    }

    // outputs a ReflectionContainer based on the starting position of the text
    // container in the txt file
    public static ReflectionContainer readRelectionElements(int lineStart) {
        String Date = "";
        String Goal = "";
        String Description = "";
        int Stars = -1;
        int Difficulty = -1;
        try {
            File data = new File("DATA/Goal_Reflection_Data.txt");
            Scanner dataRead = new Scanner(data);
            for (int lineNum = 1; dataRead.hasNext(); lineNum++) {
                if (lineNum == lineStart) {
                    Date = getValue(dataRead.nextLine());
                }
                if (lineNum == lineStart + 1) {
                    Goal = getValue(dataRead.nextLine());
                }
                if (lineNum == lineStart + 2) {
                    Description = getValue(dataRead.nextLine());
                }
                if (lineNum == lineStart + 3) {
                    Stars = Integer.parseInt(getValue(dataRead.nextLine()));
                }
                if (lineNum == lineStart + 4) {
                    Difficulty = Integer.parseInt(getValue(dataRead.nextLine()));
                }
            }
            dataRead.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        ReflectionContainer container = new ReflectionContainer(Date, Goal, Description, Stars, Difficulty);
        return container;
    }

    public static String getValue(String data) {
        String result = "";
        for (int i = data.indexOf("=") + 2; i < data.length(); i++) {
            result += data.charAt(i) + "";
        }
        return result;
    }
}
