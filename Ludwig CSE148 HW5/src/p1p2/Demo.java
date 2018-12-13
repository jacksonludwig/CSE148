package p1p2;

public class Demo {
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(2.5,5);
		Rectangle r2 = new Rectangle(4.0,2.0);
		
		System.out.println(r1.getArea());
		System.out.println(r2.getArea());
		
		Cube c1 = new Cube(3,3,3);
		Cube c2 = new Cube(400,400,400);
		
		System.out.println(c1 + "\n" + c2 + "\n" + c1.getVolume() + "\n" + c1.getSurfaceArea()
		+ "\n" + c2.getVolume() + "\n" + c2.getSurfaceArea());
	}
}
