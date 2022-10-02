package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import gui.LoginWindow;
import io.github.cdimascio.dotenv.Dotenv;

import static javax.swing.JOptionPane.showMessageDialog;

public class DataHandler {
    static Dotenv dotenv = Dotenv.load();
    static String url = dotenv.get("DATABASE_URL");
    static String username = dotenv.get("DATABASE_USERNAME");
    static String password = dotenv.get("DATABASE_PASSWORD");
    public static String date = java.time.LocalDate.now().toString();
    public static Connection conn;
    public static String user;

    public static void CreateAccount(String username, String password) throws SQLException {
        Statement stmt = conn.createStatement();
        String append = "insert into users (username, password) values('" + username + "', '" + password + "')";
        stmt.executeUpdate(append);
    }

    public static boolean CheckPassword(String username, String password) throws SQLException {
        try {
            // SQL command data stored in String datatype
            ResultSet rs = CheckUsername(username);
            if (rs != null) {
                String pass = rs.getString("password");
                pass = pass.trim();
                password = password.trim();
                if (password.equals(pass)) {
                    return true;
                }
            }
        } catch (SQLException e) {

            // Print exception pop-up on screen
            System.out.println(e);
        }
        return false;
    }

    public static ResultSet CheckUsername(String username) {
        PreparedStatement p = null;
        ResultSet rs = null;
        try {

            // SQL command data stored in String datatype
            String sql = "select * from users";
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();

            // Condition check
            while (rs.next()) {
                String currentUsername = (String) rs.getString("username");
                currentUsername = currentUsername.trim();
                username = username.trim();
                if (username.equals(currentUsername)) {
                    return rs;
                }

            }
        } catch (SQLException e) {

            // Print exception pop-up on screen
            System.out.println(e);
        }
        System.out.println("null");
        return null;
    }

    // Create New Goal in the txt file
    public static void CreateNewGoal(GoalContainer container) throws Exception {
        String date = container.Date;
        String goal = container.Goal;
        int difficulty = container.Difficulty;
        Statement stmt = conn.createStatement();
        String append = "insert into goals (date,user,goal,difficulty) values('" + date + "','" + user + "','" + goal
                + "','" + difficulty
                + "')";
        stmt.executeUpdate(append);
    }

    public static void CreateNewReflection(ReflectionContainer container) throws Exception {
        String date = container.Date;
        String goal = container.Goal;
        String description = container.Description;
        int stars = container.stars;
        int difficulty = container.difficulty;
        Statement stmt = conn.createStatement();
        String append = "insert into reflections (date,user,goal,description,stars,difficulty) values('" + date + "','"
                + user + "','"
                + goal + "','" + description
                + "','" + stars + "','" + difficulty
                + "')";
        stmt.executeUpdate(append);
    }

    // outputs a GoalContainer based on the starting position of the text container
    // in the txt file
    public static ArrayList<GoalContainer> readGoalElements() throws Exception {
        PreparedStatement p = null;
        ResultSet rs = null;
        ArrayList<GoalContainer> containers = new ArrayList<GoalContainer>();
        try {

            // SQL command data stored in String datatype
            String sql = "select * from goals";
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();

            // Condition check
            while (rs.next()) {
                String currentUsername = rs.getString("user");
                if (user.equals(currentUsername)) {
                    String date = rs.getString("date");
                    String goal = rs.getString("goal");
                    int difficulty = rs.getInt("difficulty");
                    GoalContainer container = new GoalContainer(user, date, goal, difficulty);
                    containers.add(container);
                }

            }
            return containers;
        } catch (SQLException e) {

            // Print exception pop-up on screen
            System.out.println(e);
        }
        return null;
    }

    public static GoalContainer readGoalElementsName(String name) throws Exception {
        PreparedStatement p = null;
        ResultSet rs = null;
        try {

            // SQL command data stored in String datatype
            String sql = "select * from goals";
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();

            // Condition check
            while (rs.next()) {
                String currentUsername = rs.getString("user");
                String currentName = rs.getString("goal");
                if (user.equals(currentUsername) && name.equals(currentName)) {
                    String date = rs.getString("date");
                    int difficulty = rs.getInt("difficulty");
                    GoalContainer container = new GoalContainer(user, date, name, difficulty);
                    return container;
                }

            }
        } catch (SQLException e) {

            // Print exception pop-up on screen
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<ReflectionContainer> readReflectionElements(String goal) throws Exception {
        PreparedStatement p = null;
        ResultSet rs = null;
        ArrayList<ReflectionContainer> containers = new ArrayList<ReflectionContainer>();
        try {

            // SQL command data stored in String datatype
            String sql = "select * from reflections";
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();

            // Condition check
            while (rs.next()) {
                String currentUsername = rs.getString("user");
                String currentGoal = rs.getString("goal");
                if (user.equals(currentUsername) && goal.equals(currentGoal)) {
                    String date = rs.getString("date");
                    String title = rs.getString("Goal");
                    String description = rs.getString("description");
                    int stars = rs.getInt("stars");
                    int difficulty = rs.getInt("difficulty");
                    ReflectionContainer container = new ReflectionContainer(user, date, title, description, stars,
                            difficulty);
                    containers.add(container);
                }

            }
            return containers;
        } catch (SQLException e) {

            // Print exception pop-up on screen
            System.out.println(e);
        }
        return null;
    }

    // outputs a ReflectionContainer based on the starting position of the text
    // container in the txt file

    public static Connection getConnection() throws Exception {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;

    }

    public static void main(String[] args) throws Exception {
        conn = getConnection();
        new LoginWindow();
    }

    public static void Alert(String message) {
        showMessageDialog(null, message);
    }
}
