package p1courses;

public class Textbook {
	private String title;
	private String isbn;
	private double price;
	private String author;

	public Textbook(String title, String isbn, double price, String author) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.price = price;
		this.author = author;
	}
	
	public Textbook(Textbook t) {
		this(t.title, t.isbn, t.price, t.author);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Textbook [title=" + title + ", isbn=" + isbn + ", price=" + price + ", author=" + author + "]";
	}

}
