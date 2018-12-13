package p4;

import java.util.ArrayList;

public class PlayList extends PlayableItem {
	private ArrayList<PlayableItem> musicList = new ArrayList<PlayableItem>();
	
	public PlayList(int duration) {
		super(duration);
	}
	
	public void addSong(Song song) {
		musicList.add(song);
	}
	
	public void addOpera(Opera opera) {
		musicList.add(opera);
	}

	@Override
	public void play() {
		for(int i = 0; i < musicList.size(); i++) {
			System.out.println(musicList.get(i));
		}

	}

}
