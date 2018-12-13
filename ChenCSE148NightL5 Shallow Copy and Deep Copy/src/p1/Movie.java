package p1;

import java.util.Arrays;

public class Movie {
	private String title;
	private String rating;
	private double price;
	private String[] movieStars;

	public Movie(String title, String rating, double price, String[] movieStars) {
		this.title = title;
		this.rating = rating;
		this.price = price;
		movieStars[2] = "Parker";
		this.movieStars = movieStars;
	}
	
	public Movie(Movie m) {
//		this.title = m.title;
//		this.rating = m.rating;
//		this.price = m.price;
//		this.movieStars = Arrays.copyOf(m.movieStars, m.movieStars.length);
		this(m.title, m.rating, m.price, 
				Arrays.copyOf(m.movieStars, m.movieStars.length));
	}
	
	public Movie() {
	}
	
	public static Movie shallowCopy(Movie m) {
		return m;
	}
	
	public static Movie deepCopy(Movie m) {
		return new Movie(m);
	}
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String[] getMovieStars() {
		return movieStars;
	}

	public void setMovieStars(String[] movieStars) {
		this.movieStars = movieStars;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", rating=" + rating + ", price=" + price + ", movieStars="
				+ Arrays.toString(movieStars) + "]";
	}

}
