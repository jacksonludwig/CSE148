package p1Car; 

// mem addresses are always 8bytes
// ^ deep vs shallow copy
public class Demo {

	public static void main(String[] args) {
		Car car1 = new Car();
		System.out.println(car1);
		
		Car car2 = new Car("Honda", 2018, 20200.95, "RED"); // arguments are
		// the things inside parenthesis that match up with the method
		System.out.println(car2);
		car2.setColor("WHITE");
		
		System.out.println(car2);
		System.out.println("The year of the second car is: " + car2.getYear());
		System.out.println("The speed is " + car2.getSpeed());
		car2.speedUp(30);
		car2.speedUp(40);
		System.out.println("The speed is " + car2.getSpeed());
		car2.slowDown(50);
		System.out.println("The speed is " + car2.getSpeed());
	}

}
