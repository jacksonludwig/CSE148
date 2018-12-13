package p1p2;

public class Cube extends Rectangle {
	private double height;
		
	public Cube(double length, double width, double height) {
		super(length, width);
		this.height = height;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getVolume() {
		return height * height * height;
	}
	
	public double getSurfaceArea() {
		return 6 * height * height;
	}
	
	@Override
	public String toString() {
		return "Cube [toString()=" + super.toString() + ", height=" + height + "]";
	}
	
	

}
