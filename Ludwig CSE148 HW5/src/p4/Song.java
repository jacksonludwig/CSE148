package p4;

public class Song extends PlayableItem {

	public Song(int duration, String name, String songTitle) {
		super(duration);
		this.name = name;
		this.songTitle = songTitle;
	}

	@Override
	public String toString() {
		return "Song [toString()=" + super.toString() + ", name=" + name + ", songTitle=" + songTitle + "]";
	}

	private String name;
	private String songTitle;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSongTitle() {
		return songTitle;
	}

	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}

	@Override
	public void play() {
		System.out.println(name + "\n" + songTitle + "\n" + getDuration());
	}

}
