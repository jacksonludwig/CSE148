package p6;

public class Demo {

	public static void main(String[] args) {
		Song s1 = new Song(10, "John", "Waves");
		Song s2 = new Song(3, "Brian", "Song");
		Opera o1 = new Opera(12, "Jane", "Loud");
		Opera o2 = new Opera(8, "Jim", "Quiet");
		
		PlayList p1 = new PlayList(33);
		p1.addSong(s1);
		p1.addSong(s2);
		p1.addOpera(o1);
		p1.addOpera(o2);
		
		p1.play();

	}

}
