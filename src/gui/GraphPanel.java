package gui;

import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import utils.*;

public class GraphPanel extends JPanel {
    int width = 50;
    int height = 10;
    int windowPercentX = 65;
    int windowPercentY = 92;
    int windowX;
    int windowY;
    float windowXScalar = 0.05f;
    float windowYScalar = 0.002f;
    int yOffset = 8;
    int fontSize = 10;
    int fontSize2 = 8;

    public GraphPanel(ArrayList<ReflectionContainer> containers) {
        setLayout(null);
        System.out.println(containers.size());
        windowX = utils.WidthPercentage(windowPercentX);
        windowY = utils.HeightPercentage(windowPercentY);
        windowX += containers.size() * windowXScalar * windowX;
        windowY += containers.size() * windowYScalar * windowY;
        LineGraph surface = new LineGraph(containers);
        surface.panelWidth = windowX - width * 2;
        surface.panelHeight = windowY - yOffset * 2;
        surface.initialize();
        for (int i = 0; i < surface.Ygrid.length; i++) {
            JLabel label = new JLabel(i + " points");
            label.setFont(new Font("Times New Roman", Font.BOLD, fontSize));
            label.setBounds(0, surface.Ygrid[i], width, height);
            add(label);
        }
        for (int i = 0; i < containers.size(); i++) {
            JLabel label = new JLabel(containers.get(i).Date);
            label.setFont(new Font("Times New Roman", Font.BOLD, fontSize2));
            label.setBounds(surface.Xgrid[i] + width / 2, surface.Ygrid[0] + yOffset, width, height);
            add(label);
        }
        surface.setBounds(width, yOffset, windowX,
                windowY);
        add(surface);
        setPreferredSize(new Dimension(windowX, windowY));
        setVisible(true);
    }
}
