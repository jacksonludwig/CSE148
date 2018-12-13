package p1;

public class Pet {
	private String name;
	private String type;
	private int age;
	
	public Pet(String name, String type, int age) {
		super();
		this.name = name;
		this.type = type;
		this.age = age;
	}
	
	public Pet() {
		super();
	}

	public Pet(Pet p) {
		this(p.name, p.type, p.age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Pet [name=" + name + ", type=" + type + ", age=" + age + "]";
	}
	
	
	
	

}
