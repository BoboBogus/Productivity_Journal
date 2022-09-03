package gui;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import utils.DataHandler;
import static javax.swing.JOptionPane.showMessageDialog;

public class LoginWindow extends JFrame {

    JTextField username = new JTextField();
    JTextField password = new JTextField();

    public LoginWindow() {

        setSize(400, 200);

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(layout);

        JButton Login = new JButton("Login");
        Login.addActionListener(e -> {
            try {
                Login();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        JButton SignUp = new JButton("Sign Up");
        SignUp.addActionListener(e -> {
            try {
                SignUp();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        JLabel u = new JLabel("enter username: ");
        username = new JTextField();
        JLabel p = new JLabel("enter password: ");
        password = new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        // Adjust constraints for the text field so it's at
        // (<label's right edge> + 5, 5).

        c.insets = new Insets(0, 10, 0, 10); // top padding
        add(u, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        add(username, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        add(p, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        add(password, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;

        c.insets = new Insets(10, 5, 0, 5); // top padding
        add(Login, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        add(SignUp, c);
        setLocationRelativeTo(null);
        setFocusable(true);
        setVisible(true);
    }

    void Login() throws SQLException {
        String user = username.getText();
        String pass = password.getText();
        if (DataHandler.CheckPassword(user, pass)) {
            new AppFrame();
            Alert("welcome! " + user);
            DataHandler.user = user;
        } else {
            Alert("password and or username is incorrect");
        }
    }

    void SignUp() throws SQLException {

        String user = username.getText();
        String pass = password.getText();
        if (DataHandler.CheckUsername(user) != null) {
            Alert("account already exists");
            return;
        }
        Alert("Account Created! \n username " + user + ", password " + pass);
        DataHandler.CreateAccount(user, pass);
    }

    void Alert(String message) {
        showMessageDialog(null, message);
    }
}
