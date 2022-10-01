package testing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.Timer;
import utils.*;
import java.awt.*;

class test extends JFrame {
    public test() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(values.windowX, values.windowY));
        ArrayList<ReflectionContainer> refs = new ArrayList<ReflectionContainer>();
        ReflectionContainer a = new ReflectionContainer("Jayden", "20", "how to eat", "very tasty", 1, 5);
        ReflectionContainer b = new ReflectionContainer("Jayden", "21", "how to eat", "very tasty", 0, 5);
        ReflectionContainer c = new ReflectionContainer("Jayden", "20", "how to eat", "very tasty", 2, 5);
        ReflectionContainer d = new ReflectionContainer("Jayden", "21", "how to eat", "very tasty", 0, 5);
        refs.add(a);
        refs.add(b);
        refs.add(c);
        refs.add(d);
        LineGraph ex = new LineGraph(refs);
        add(ex, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new test();
    }
}