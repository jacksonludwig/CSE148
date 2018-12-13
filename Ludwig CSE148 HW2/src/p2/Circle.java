package p2;

public class Circle {
	private double radius;
	private static double pi = 3.14159;
	
	public Circle(double rad) {
		radius = rad;
	}
	
	public void setRadius(double newRadius) {
		this.radius = newRadius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getArea() {
		double area = pi * radius * radius;
		return area;
	}
	
	public double getDiameter() {
		double diameter = radius * 2;
		return diameter;
	}
	
	public double getCircumference () {
		double circumference = 2 * pi * radius;
		return circumference;
	}

	@Override
	public String toString() {
		return "Area=" + String.format("%1$.2f", getArea()) + ", Diameter()=" + String.format("%1$.2f",getDiameter())
				+ ", Circumference()=" + String.format("%1$.2f",getCircumference());
	}
}
