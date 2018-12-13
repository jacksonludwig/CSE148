package p5;

public class Demo {

	public static void main(String[] args) {
		try {
			RetailItem r1 = new RetailItem(34853457,"chocolate bar",10,2.0);
			RetailItem r2 = new RetailItem(34853457,"chocolate bar",-1,2.0);
		} catch (BadPriceException e) {
			System.out.println(e.getMessage());
		} catch (BadUnitsException e) {
			System.out.println(e.getMessage());
		}

	}

}
