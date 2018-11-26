package model;

public abstract class Person {
	private String firstName;
	private String lastName;
	private String id;
	private String dataLine;

	public Person(String filename) {
		dataLine = Utilities.generateRandomLineFromFile(filename);
		firstName = getFirstNameFromFile(dataLine);
		lastName = getLastNameFromFile(dataLine);
		id = getIdFromFile(dataLine);
	}

	public String getFirstNameFromFile(String line) {
		int count = 0;
		String name = "";
		while (line.charAt(count) != '*') {
			name += line.charAt(count);
			count++;
		}
		return name;
	}

	public String getLastNameFromFile(String line) {
		int count = 0;
		String name = "";
		while (line.charAt(count) != '*') {
			count++;
		}
		count++;
		while (line.charAt(count) != '*') {
			name += line.charAt(count);
			count++;
		}

		return name;
	}

	public String getIdFromFile(String line) {
		int sectionCount = 0;
		int count = 0;
		String id = "";
		while (sectionCount < 2) {
			if (line.charAt(count) == '*') {
				sectionCount++;
			}
			count++;
		}
		while (line.charAt(count) != '*') {
			id += line.charAt(count);
			count++;
		}
		return id;
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

	public String getDataLine() {
		return dataLine;
	}

	public void setDataLine(String dataLine) {
		this.dataLine = dataLine;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + "]";
	}
}
