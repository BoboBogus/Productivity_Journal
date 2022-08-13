package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataHandler {

    // Create New Goal in the txt file
    public static void CreateNewGoal(GoalContainer container) throws Exception {
        int id = container.count;
        String date = container.Date;
        String goal = container.Goal;
        int difficulty = container.Difficulty;
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        String append = "insert into goals values('" + id + "','" + date + "','" + goal + "','" + difficulty + "')";
        stmt.executeUpdate(append);
        conn.close();
    }

    public static void CreateNewReflection(ReflectionContainer container) throws Exception {
        int id = container.count;
        String date = container.Date;
        String goal = container.Goal;
        String description = container.Description;
        int stars = container.stars;
        int difficulty = container.difficulty;
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        String append = "insert into reflections values('" + id + "','" + date + "','" + goal + "','" + description
                + "','" + stars + "','" + difficulty
                + "')";
        stmt.executeUpdate(append);
        conn.close();
    }

    // outputs a GoalContainer based on the starting position of the text container
    // in the txt file
    public static GoalContainer readGoalElements(int lineStart) {
        String Date = "";
        String Goal = "";
        int Difficulty = -1;
        GoalContainer container = new GoalContainer(Date, Goal, Difficulty);
        return container;
    }

    // outputs a ReflectionContainer based on the starting position of the text
    // container in the txt file
    public static ReflectionContainer readReflectionElements(int lineStart) {
        String Date = "";
        String Goal = "";
        String Description = "";
        int Stars = -1;
        int Difficulty = -1;
        ReflectionContainer container = new ReflectionContainer(Date, Goal, Description, Stars, Difficulty);
        return container;
    }

    public static Connection getConnection() throws Exception {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/productivity";
            String username = "root";
            String password = "Bobo24680";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;

    }
}
