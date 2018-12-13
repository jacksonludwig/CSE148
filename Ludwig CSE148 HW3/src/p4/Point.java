package p4;

public class Point {
	private double x;
	private double y;

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Point(Point p) {
		super();
		x = p.getX();
		y = p.getY();
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	public Point deepCopy(Point point) {
		return new Point(point.getX(), point.getY());
	}

	public Point shallowCopy(Point point) {
		return point;
	}
}
