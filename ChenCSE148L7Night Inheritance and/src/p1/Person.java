package p1;

public class Person {
	private String name;
	private String ssn;

	public Person(String name, String ssn) {
		super();
		this.name = name;
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "Person name=" + name + ", ssn=" + ssn;
	}
	
	 

}
