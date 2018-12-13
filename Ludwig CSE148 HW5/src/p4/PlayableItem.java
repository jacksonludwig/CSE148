package p4;

public abstract class PlayableItem {
	
	public PlayableItem(int duration) {
		super();
		this.duration = duration;
	}

	private int duration;

	public abstract void play();

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
