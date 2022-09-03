package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import gui.LoginWindow;

public class DataHandler {
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
            System.out.println(rs);
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
                System.out.println(currentUsername);
                currentUsername = currentUsername.trim();
                username = username.trim();
                if (username.equals(currentUsername)) {
                    System.out.println("working");
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
    public static GoalContainer readGoalElements(int identifier) throws Exception {
        PreparedStatement p = null;
        ResultSet rs = null;
        try {

            // SQL command data stored in String datatype
            String sql = "select * from reflections";
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();

            // Condition check
            while (rs.next()) {
                int id = rs.getInt("id");
                if (identifier == id) {
                    String date = rs.getString("date");
                    String goal = rs.getString("goal");
                    int difficulty = rs.getInt("difficulty");
                    GoalContainer container = new GoalContainer(id, date, goal, difficulty);
                    return container;
                }

            }
        } catch (SQLException e) {

            // Print exception pop-up on screen
            System.out.println(e);
        }
        return null;
    }

    // outputs a ReflectionContainer based on the starting position of the text
    // container in the txt file
    public static ReflectionContainer readReflectionElements(int identifier) throws Exception {
        PreparedStatement p = null;
        ResultSet rs = null;
        try {

            // SQL command data stored in String datatype
            String sql = "select * from reflections";
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                if (identifier == id) {
                    String date = rs.getString("date");
                    String goal = rs.getString("goal");
                    String description = rs.getString("description");
                    int stars = rs.getInt("stars");
                    int difficulty = rs.getInt("difficulty");
                    ReflectionContainer container = new ReflectionContainer(id, date, goal, description, stars,
                            difficulty);
                    return container;
                }

            }
        } catch (SQLException e) {

            // Print exception pop-up on screen
            System.out.println(e);
        }
        return null;
    }

    public static Connection getConnection() throws Exception {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            // personal external ip
            String url = "jdbc:mysql://47.205.208.30:3306/productivity";
            String username = "global";
            String password = "password";
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
}
