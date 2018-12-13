package p6;

public class Persons {
	private String name;
	private String SSnum;
	private int age;
	
	public Persons(String name, String sSnum, int age) {
		this.name = name;
		SSnum = sSnum;
		this.age = age;
	}

	public Persons() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSSnum() {
		return SSnum;
	}

	public void setSSnum(String sSnum) {
		SSnum = sSnum;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "name=" + name + ", SSnum=" + SSnum + ", age=" + age;
	}
	
	
}
