package p1TextFileGenerators;

import java.io.IOException;

public abstract class Person {
	private String firstName;
	private String lastName;
	private String id;

	private static int idNumber = 0;

	public Person() throws IOException {
		super();
		firstName = Utilities.generateRandomWordFromFile("firstnames.txt");
		lastName = Utilities.generateRandomWordFromFile("lastnames.txt");
		id = String.valueOf(idNumber++);
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + " " + id + " ";
	}

}
