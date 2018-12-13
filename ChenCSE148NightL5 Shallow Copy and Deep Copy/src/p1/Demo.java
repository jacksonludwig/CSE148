package p1;

import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		String[] stars = {"Peter", "MaryJane", "Others"};
		String[] shallowCopyOfStars = stars;
		String[] hardCopyOfStars = Arrays.copyOf(stars, stars.length);
		hardCopyOfStars[0] = "Parker";
		System.out.println(Arrays.equals(stars, shallowCopyOfStars));

		System.out.println(Arrays.equals(stars, hardCopyOfStars));
		System.out.println(stars == hardCopyOfStars);
		Movie m1 = new Movie("Spiderman", "PG-13", 15.0, hardCopyOfStars);
		Movie m2 = new Movie(m1);
		Movie m3 = Movie.shallowCopy(m1);
		Movie m4 = Movie.deepCopy(m1);
		
		
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m1 == m3);
		
//		String[] stars2 = stars;
		
//		System.out.println(stars == stars2);
		
//		System.out.println(stars[2]);
	}

}
