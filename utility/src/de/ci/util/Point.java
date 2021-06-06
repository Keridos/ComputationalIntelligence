package de.ci.util;



import java.util.List;

public class Point {
    double[] coordinates;

    public Point(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public Point(double x) {
        this.coordinates = new double[]{x};
    }

    public Point(double x, double y) {
        this.coordinates = new double[]{x,y};
    }

    public Point(double x, double y, double z) {
        this.coordinates = new double[]{x,y,z};
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public double distanceTo(Point point) {
        double distance = 0D;
        for (int i = 0; i < coordinates.length; i++) {
            distance += Math.pow(coordinates[i] - point.getCoordinates()[i], 2);
        }
        return distance;
    }

    public static Point getRandomPoint(double[] maxValues) {
        double[] coords = new double[maxValues.length];
        for (int i = 0; i < coords.length; i++) {
            coords[i] = (Util.random.nextDouble() - 0.5D) * maxValues[i];
        }
        return new Point(coords);
    }

    public Point shift(double[] coords) {
        for (int i = 0; i < coords.length; i++) {
            coords[i] += coordinates[i];
        }
        return new Point(coords);
    }

    public Point scale(double factor) {
        double[] coords = new double[2];
        for (int i = 0; i < this.coordinates.length; i++) {
            coords[i] = coordinates[i] * factor;
        }
        return new Point(coords);
    }

    public static Point getAveragePoint(List<Point> list){
        if (list.isEmpty()) {
            return null;
        }
        double[] averageCoords = new double[list.get(0).coordinates.length];
        for (Point point : list) {
            for (int i = 0; i<2;i++){
                averageCoords[i] += point.getCoordinates()[i] / list.size();
            }
        }
        return new Point (averageCoords);
    }
}
