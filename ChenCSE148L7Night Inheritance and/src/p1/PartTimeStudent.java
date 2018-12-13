package p1;

public class PartTimeStudent extends Student {
	private int numberOfCredits;
	private final double PRICE_PER_CREDIT = 250.00;

	public PartTimeStudent(String name, String ssn, double gpa, int numberOfCredits) {
		super(name, ssn, gpa);
		this.numberOfCredits = numberOfCredits;
	}

	public int getNumberOfCredits() {
		return numberOfCredits;
	}

	public void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}

	public double getPRICE_PER_CREDIT() {
		return PRICE_PER_CREDIT;
	}

	@Override
	public String toString() {
		return "PartTimeStudent =" + super.toString() + ", numberOfCredits=" + numberOfCredits
				+ ", PRICE_PER_CREDIT=" + PRICE_PER_CREDIT;
	}
	
	

}
