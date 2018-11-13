package p1ObjectSerialization;

import java.io.Serializable;

public abstract class Person implements Serializable{
	private String name;
	private String id;
	
	private static int idNumber = 0;
	
	public Person(String name) {
		this.name = name;
		id = String.valueOf(idNumber++); // String.valueOf(arg0) Turns ANYTHING into String. Opposite of PARSE.
	}
	
	public Person() {
		name="";
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
		return "Name= " + name + ", ID= " + id;
	}
	
	
}
