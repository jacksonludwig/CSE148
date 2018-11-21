package sampleCode;

import java.io.Serializable;

public class Student implements Serializable{
	private String name;
	private String id;
	private static int idNumber = 0;

	public Student(String name) {
		super();
		this.name = name;
		id = String.valueOf(idNumber++);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + "]";
	}

}
