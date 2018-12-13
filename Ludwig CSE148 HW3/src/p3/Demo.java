package p3;

public class Demo {

	public static void main(String[] args) {
		Cop c1 = new Cop("John Doe", "123");
		ParkingMeter m1 = new ParkingMeter(50, "SuffolkMeter101");

		ParkingTicket t1 = new ParkingTicket(c1, m1, "101", 0.10);

		Cop c2 = new Cop("Jane Doe", "321");
		ParkingMeter m2 = new ParkingMeter(100, "SuffolkMeter102");

		ParkingTicket t2 = new ParkingTicket(c1, m1, "210", 0.15);

		System.out.println(t1);
		System.out.println("\n" + t2);
	}

}
