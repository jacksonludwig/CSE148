package p1;

public class Secretary extends Person {
	
	private int deskNumber;
	
	public Secretary(String name, String ssn, int deskNumber) {
		super(name, ssn);
		this.deskNumber = deskNumber;
	}

	public int getDeskNumber() {
		return deskNumber;
	}

	public void setDeskNumber(int deskNumber) {
		this.deskNumber = deskNumber;
	}

	@Override
	public String toString() {
		return "Secretary ="  + super.toString() + ", deskNumber=" + deskNumber;
	}
	
	
	
}
