package de.ci;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {
    static Random random = new Random();
    static double[] werte6_1 = new double[2048];
    static double[] werte6_2 = new double[2048];
    static double[] werte6_3 = new double[2048];
    static double[] werte6_5 = new double[2048];
    static double[] werte6_6_x = new double[2000];
    static double[] werte6_6_y = new double[2000];
    static double[] werte6_7 = new double[2048];

    public static void calculate6_1() {
        for (int i = 0; i < 2048; i++) {
            werte6_1[i] = 0.7D * Math.sin(0.01D * i);
        }
    }

    public static void calculate6_2() {
        for (int i = 0; i < 2048; i++) {
            werte6_2[i] = 0.7D * Math.sin(0.01D * i) + 0.2D * (random.nextDouble() - 0.5D);
        }
    }

    public static void calculate6_3() {
        for (int i = 0; i < 2048; i++) {
            if (i > 1 && i < 2046) {
                werte6_3[i] = 0.2D * (werte6_2[i - 2] + werte6_2[i - 1] + werte6_2[i] + werte6_2[i + 1] + werte6_2[i + 2]);
            } else if (i == 1) {
                werte6_3[i] = 0.25D * (werte6_2[i - 1] + werte6_2[i] + werte6_2[i + 1] + werte6_2[i + 2]);
            } else if (i == 0) {
                werte6_3[i] = 1D / 3D * (werte6_2[i] + werte6_2[i + 1] + werte6_2[i + 2]);
            } else if (i == 2046) {
                werte6_3[i] = 0.25D * (werte6_2[i - 2] + werte6_2[i - 1] + werte6_2[i] + werte6_2[i + 1]);
            } else {
                werte6_3[i] = 1D / 3D * (werte6_2[i - 2] + werte6_2[i - 1] + werte6_2[i]);
            }
        }
    }

    public static void calculate6_5() {
        for (int i = 0; i < 2048; i++) {
            if (i > 1 && i < 2046) {
                werte6_5[i] = 20D * (-werte6_1[i - 2] + werte6_1[i + 2]);
            } else if (i == 1) {
                werte6_5[i] = 20D * (-werte6_1[i - 1] + werte6_1[i + 2]);
            } else if (i == 0) {
                werte6_5[i] = 20D * (-werte6_1[i] + werte6_1[i + 2]);
            } else if (i == 2046) {
                werte6_5[i] = 20D * (-werte6_1[i - 2] + werte6_1[i + 1]);
            } else {
                werte6_5[i] = 20D * (-werte6_1[i - 2] + werte6_1[i]);
            }
        }
    }

    public static void calculate6_6_x() {
        double momentary_value = random.nextDouble();
        werte6_6_x[0] = momentary_value;
        for (int i = 1; i < 2000; i++) {
            if (i % 100 == 0) {
                momentary_value = random.nextDouble();
            }
            werte6_6_x[i] = momentary_value;
        }
    }

    public static void calculate6_6_y() {
        for (int i = 0; i < 2000; i++) {
            if (i > 1 && i < 1998) {
                werte6_6_y[i] = 0.5D * (-werte6_6_x[i - 2] + 4.0D * werte6_6_x[i] - werte6_6_x[i + 2]);
            } else if (i < 2) {
                werte6_6_y[i] = 0.5D * (4.0D * werte6_6_x[i] - werte6_6_x[i + 2]);
            } else {
                werte6_6_y[i] = 0.5D * (-werte6_6_x[i - 2] + 4.0D * werte6_6_x[i]);
            }
        }
    }

    public static void calculate6_7() {
        for (int i = 0; i < 2048; i++) {
            if (i > 2 && i < 2045) {
                werte6_7[i] = 0.2D * (werte6_2[i - 3] - werte6_2[i - 2] - 3D * werte6_2[i] - werte6_2[i + 2] + werte6_2[i + 3]);
            } else if (i == 2) {
                werte6_7[i] = 1.8D / 4D * (-werte6_2[i - 2] - 3D * werte6_2[i] - werte6_2[i + 2] + werte6_2[i + 3]);
            } else if (i < 2) {
                werte6_7[i] = 1.4D / 4D * (3D * werte6_2[i] - werte6_2[i + 2] + werte6_2[i + 3]);
            } else if (i == 2045) {
                werte6_7[i] = 1.8D / 4D * (werte6_2[i - 3] - werte6_2[i - 2] - 3D * werte6_2[i] - werte6_2[i + 2]);
            } else {
                werte6_7[i] = 1.4D / 4D * (werte6_2[i - 3] - werte6_2[i - 2] - 3D * werte6_2[i]);
            }
        }
    }

    private static void writeResultsToFile(double[] results, String filename, int maxout) {
        try {
            FileWriter myWriter = new FileWriter("results-" + filename + ".txt");
            int i = 0;
            for (double result : results) {
                myWriter.write(i++ + " " + result + "\n");
                if (maxout != 0 && i > maxout) {
                    break;
                }
            }

            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        calculate6_1();
        calculate6_2();
        calculate6_3();
        calculate6_5();
        calculate6_6_x();
        calculate6_6_y();
        calculate6_7();

        writeResultsToFile(werte6_1, "6_1", 500);
        writeResultsToFile(werte6_2, "6_2", 500);
        writeResultsToFile(werte6_3, "6_3_y", 2048);
        writeResultsToFile(werte6_2, "6_3_x", 2048);
        writeResultsToFile(werte6_1, "6_5_x", 2048);
        writeResultsToFile(werte6_5, "6_5_y", 2048);
        writeResultsToFile(werte6_6_x, "6_6_x", 2000);
        writeResultsToFile(werte6_6_y, "6_6_y", 2000);
        writeResultsToFile(werte6_2, "6_7_x", 2048);
        writeResultsToFile(werte6_7, "6_7_y", 2048);
    }
}
