package project;
import java.io.Serializable;

public class Textbook implements Serializable{
	private String title;
	private String isbn;
	private double price;

	public Textbook(String title, String isbn, double price) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Textbook [title=" + title + ", ISBN=" + isbn + ", price=" + price + "]";
	}

}
