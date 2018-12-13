package p3;

public class Pet {
	private String type;
	private String name;
	private String sound;
	
	public Pet(String type, String name, String sound) {
		this.type = type;
		this.name = name;
		this.sound = sound;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public String toString() {
		return "type=" + type + ", name=" + name + ", sound=" + sound;
	}
	
	
}
