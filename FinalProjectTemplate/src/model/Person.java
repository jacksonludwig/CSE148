package model;

public abstract class Person {
	private String name;
	private String id;
	
	private static int idCounter = 0;
	
	public Person(String name) {
		this.name = name;
		id = String.valueOf(idCounter++);
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
		return "name=" + name + ", id=" + id;
	}
	
	
}
