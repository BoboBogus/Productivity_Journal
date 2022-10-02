package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import utils.*;

public class LineGraph extends JPanel implements ActionListener {
    int panelWidth;
    int panelHeight;
    public int[] Xgrid;
    public int[] Ygrid;
    static ArrayList<ReflectionContainer> c;
    tuple[] points;
    int maximumScore;

    // supposed to be ArrayList<ReflectionContainer> containers
    public LineGraph(ArrayList<ReflectionContainer> containers) {
        this.c = containers;
        for (ReflectionContainer container : containers) {
            maximumScore += container.points;
        }
    }

    public void initialize() {
        calculateGrid();
        points = containers_to_points(c);
        setVisible(true);

    }

    void calculateGrid() {
        Xgrid = new int[c.size()];
        Ygrid = new int[maximumScore + 1];
        for (int i = 0; i <= maximumScore; i++) {
            if (i != 0) {
                Ygrid[i] = i * panelHeight / maximumScore;
            } else
                Ygrid[0] = 0;

        }
        Ygrid = utils.reverse(Ygrid, maximumScore + 1);
        for (int j = 0; j < c.size(); j++) {
            if (j != 0) {
                Xgrid[j] = j * panelWidth / (c.size() - 1);
            } else
                Xgrid[0] = 0;
        }
    }

    static tuple[] containers_to_points(ArrayList<ReflectionContainer> containers) {
        tuple[] result = new tuple[containers.size()];
        int totalpoints = 0;
        for (int i = 0; i < containers.size(); i++) {
            totalpoints += containers.get(i).points;
            tuple point = new tuple(i, totalpoints);
            result[i] = point;
        }
        return result;
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.LIGHT_GRAY);

        for (int i = 0; i < c.size(); i++) {
            g2d.drawLine(Xgrid[i], Ygrid[0], Xgrid[i], Ygrid[maximumScore]);
            for (int j = 0; j <= maximumScore; j++) {
                g2d.drawLine(Xgrid[0], Ygrid[j], Xgrid[c.size() - 1], Ygrid[j]);
            }
        }
        g2d.setPaint(Color.RED);

        for (int i = 1; i < c.size(); i++) {
            g2d.drawLine(Xgrid[points[i - 1].num1], Ygrid[points[i - 1].num2], Xgrid[points[i].num1],
                    Ygrid[points[i].num2]);
        }

        // for (int i = 0; i <= c.size(); i++) {
        // g2d.drawLine(Xgrid[i], Ygrid[i], Xgrid[i], Ygrid[i]);
        // }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}