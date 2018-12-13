package p4;

public class Demo {
	public static void main(String[] args) {
		Point p1 = new Point(5, 12);

		Point p2 = p1.deepCopy(p1);
		p2.setX(7);
		
		Point p3 = new Point(p2);
		p3.setY(15);
		
		Point p4 = p3.shallowCopy(p3);
		
		System.out.println(p1 + " " + p2 + " " + p3 + " " + p4);
	}
}
