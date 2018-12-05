package model;

import java.io.Serializable;

public class Textbook implements Serializable{
	private String title;
	private String authorFirstName;
	private String authorLastName;
	private String ISBN;
	private double price;
	
	public Textbook(String dataLine) {
		title = generateTitleFromFile(dataLine);
		authorFirstName = generateAuthorFirstNameFromFile(dataLine);
		authorLastName = generateAuthorLastNameFromFile(dataLine);
		ISBN = generateISBNFile(dataLine);
		price = generatePriceFromFile(dataLine);
	}
	
	public Textbook(String title, String first, String last, String ISBN, double price) {
		this.title = title;
		authorFirstName = first;
		authorLastName = last;
		this.ISBN = ISBN;
		this.price = price;
	}
	
	public String generateTitleFromFile(String line) {
		int count = 0;
		String title = "";
		while (line.charAt(count) != '*') {
			title += line.charAt(count);
			count++;
		}
		return title;
	}
	
	public String generateAuthorFirstNameFromFile(String line) {
		int sectionCount = 0;
		int count = 0;
		String name = "";
		while (sectionCount < 1) {
			if (line.charAt(count) == '*') {
				sectionCount++;
			}
			count++;
		}
		while (line.charAt(count) != '*') {
			name += line.charAt(count);
			count++;
		}
		return name;
	}
	
	public String generateAuthorLastNameFromFile(String line) {
		int sectionCount = 0;
		int count = 0;
		String name = "";
		while (sectionCount < 2) {
			if (line.charAt(count) == '*') {
				sectionCount++;
			}
			count++;
		}
		while (line.charAt(count) != '*') {
			name += line.charAt(count);
			count++;
		}
		return name;
	}
	
	public String generateISBNFile(String line) {
		int sectionCount = 0;
		int count = 0;
		String isbn = "";
		while (sectionCount < 3) {
			if (line.charAt(count) == '*') {
				sectionCount++;
			}
			count++;
		}
		while (line.charAt(count) != '*') {
			isbn += line.charAt(count);
			count++;
		}
		return isbn;
	}
	
	public double generatePriceFromFile(String line) {
		int sectionCount = 0;
		int count = 0;
		String price = "";
		while (sectionCount < 4) {
			if (line.charAt(count) == '*') {
				sectionCount++;
			}
			count++;
		}
		while (line.charAt(count) != '*') {
			price += line.charAt(count);
			count++;
		}
		return Double.parseDouble(price);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}

	public String getAuthorLastName() {
		return authorLastName;
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Textbook [title=" + title + ", authorFirstName=" + authorFirstName + ", authorLastName="
				+ authorLastName + ", ISBN=" + ISBN + ", price=" + price + "]";
	}
	
	
}
