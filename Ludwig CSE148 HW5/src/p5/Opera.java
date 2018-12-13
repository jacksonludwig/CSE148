package p5;

public class Opera extends PlayableItem {
	public Opera(int duration, String name, String operaTitle) {
		super(duration);
		this.name = name;
		this.operaTitle = operaTitle;
	}

	@Override
	public String toString() {
		return "Opera [toString()=" + super.toString() + ", name=" + name + ", operaTitle=" + operaTitle + "]";
	}

	private String name;
	private String operaTitle;
	
	@Override
	public void play() {
		System.out.println(name + "\n" + operaTitle + "\n" + getDuration());
	}
	
}
