package utils;

import java.awt.Dimension;

public class utils {
    public static Dimension ComponentPercentage(int percentX, int percentY) {
        int x = (int) Math.round(values.windowX * percentX * 0.01);
        int y = (int) Math.round(values.windowY * percentY * 0.01);
        return new Dimension(x, y);
    }

    public static int WidthPercentage(int percentX) {
        int x = (int) Math.round(values.windowX * percentX * 0.01);
        return x;
    }

    public static int HeightPercentage(int percentY) {
        int y = (int) Math.round(values.windowY * percentY * 0.01);
        return y;
    }

    public static int[] reverse(int a[], int n) {
        int[] b = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
        return b;
    }
}
