package model;

import java.io.Serializable;

public class Textbook implements Serializable {
	private String title;
	private String isbn;
	private String author;
	private double price;

	public Textbook(String title, String isbn, String author, double price) {
		super();
		this.title = title;
		this.isbn = isbn;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Title=" + title + ", isbn=" + isbn;
	}

}
