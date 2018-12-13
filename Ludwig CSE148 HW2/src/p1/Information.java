package p1;

public class Information {
	private String name;
	private String address;
	private int age;
	private String phone;
	
	public Information(String name, String address, int age, String phone) {
		this.name = name;
		this.address = address;
		this.age = age;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String toString() {
		return "name=" + name + ", address=" + address + ", age=" + age + ", phone=" + phone;
	}
	
	
	
	
}
