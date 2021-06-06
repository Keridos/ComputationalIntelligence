package de.ci.util;

import java.util.Arrays;

public enum EnumCoordSystem {
    CARTESIAN, POLAR;

    public double[] cartesianToPolar2Dim(double[] data) {
        double r = Math.sqrt(Arrays.stream(data).map(n -> n * n).reduce(0, Double::sum));
        double theta = Math.atan2(data[1] , data[0]);
        return new double[]{r, theta};
    }
}