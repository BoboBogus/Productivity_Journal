package gui;

import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import utils.*;

public class GraphPanel extends JPanel {
    int width = 50;
    int height = 10;
    int windowPercentX = 70;
    int windowPercentY = 100;
    int yOffset = 8;
    int xOffset = 5;
    int fontSize = 10;
    int fontSize2 = 8;

    public GraphPanel(ArrayList<ReflectionContainer> containers) {
        setLayout(null);
        final LineGraph surface = new LineGraph(containers);
        for (int i = 0; i < surface.Ygrid.length; i++) {
            JLabel label = new JLabel(i + " points");
            label.setFont(new Font("Times New Roman", Font.BOLD, fontSize));
            label.setBounds(0, surface.Ygrid[i], width, height);
            add(label);
        }
        for (int i = 0; i < containers.size(); i++) {
            JLabel label = new JLabel(containers.get(i).Date);
            label.setFont(new Font("Times New Roman", Font.BOLD, fontSize2));
            label.setBounds(surface.Xgrid[i] + width - xOffset, surface.Ygrid[0] + yOffset, width, height);
            add(label);
        }
        surface.setBounds(width, yOffset, utils.WidthPercentage(windowPercentX),
                utils.HeightPercentage(windowPercentY));
        add(surface);
        setSize(utils.ComponentPercentage(windowPercentX, windowPercentY));
        setVisible(true);
    }
}
