import java.io.Serializable;

public class Student implements Serializable{
	private String name;
	private String major;
	private String id;

	public Student(String name, String major, String id) {
		super();
		this.name = name;
		this.major = major;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", major=" + major + ", id=" + id + "]";
	}

	// no auto id here

}
