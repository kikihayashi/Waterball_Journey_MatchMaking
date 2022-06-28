public class Coordinate {

    private double x = 0;
    private double y = 0;

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDistance(double member_x, double member_y) {
        double x_square = Math.pow(this.x - member_x, 2);
        double y_square = Math.pow(this.y - member_y, 2);
        return Math.sqrt(x_square + y_square);
    }
}
