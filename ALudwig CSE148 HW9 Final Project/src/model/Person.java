package model;

import java.io.Serializable;

public abstract class Person implements Serializable {
	private String firstName;
	private String lastName;
	private String id;
	private String dataLine;

	private static int newPersonId = 2300;

	public Person(String dataLine) {
		firstName = getFirstNameFromFile(dataLine);
		lastName = getLastNameFromFile(dataLine);
		id = getIdFromFile(dataLine);
//		if (Integer.parseInt(id) > newPersonId) {
//			newPersonId = Integer.parseInt(id) + 1;
//		}
	}

	public Person(String first, String last) {
		firstName = first;
		lastName = last;
		id = String.valueOf(newPersonId++);
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

	public static String getIdFromFile(String line) {
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

	public static int getNewPersonId() {
		return newPersonId;
	}

	public static void setNewPersonId(int newPersonId) {
		Person.newPersonId = newPersonId;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + "]";
	}
}
