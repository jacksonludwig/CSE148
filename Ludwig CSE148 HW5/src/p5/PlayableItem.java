package p5;

public class PlayableItem {
	
	public PlayableItem(int duration) {
		super();
		this.duration = duration;
	}

	private int duration;

	public void play() {
		System.out.println(duration);
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "PlayableItem [duration=" + duration + "]";
	}
	
	
}
