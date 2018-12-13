package controllers;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.Textbook;
import model.TextbookBag;
import utilities.Alerts;
import view.TextbookPane;

// Searches by book TITLE.

public class TextbookShop {
	private TextbookPane textbookPane;
	private MenuBarShop menuBarShop;
	private TextbookBag textbookBag;
	private BorderPane root;

	public TextbookShop(TextbookBag textbookBag, MenuBarShop menuBarShop, BorderPane root) {
		textbookPane = new TextbookPane();
		this.menuBarShop = menuBarShop;
		this.textbookBag = textbookBag;
		this.root = root;
		setCallbacks();
	}

	public Pane getTextbookPane() {
		return textbookPane.getTextbookPane();
	}

	private void setCallbacks() {
		menuBarShop.getInsertTextbookMenuItem().setOnAction(e -> {
			root.setCenter(textbookPane.getTextbookPane());
		});

		textbookPane.getInsertBtn().setOnAction(e -> {
			String title = textbookPane.getTitle();
			String isbn = textbookPane.getIsbn();
			String authorFirst = textbookPane.getAuthorFirst();
			String authorLast = textbookPane.getAuthorLast();
			double price = textbookPane.getPrice();
			Textbook textbook = new Textbook(title, isbn, authorFirst, authorLast, price);
			if (textbookBag.findByTitle(textbook.getTitle()) != null) {
				if (Alerts.showRepeatItem()) {
					textbookPane.clearAllFields();
				}
			} else {
				textbookBag.insert(textbook);
				if (Alerts.showItemInserted()) {
					textbookPane.clearAllFields();
				}
			}

		});

		textbookPane.getSearchBtn().setOnAction(e -> { 
			String title = textbookPane.getTitle();
			
			if (textbookBag.findByTitle(title) != null) {
				if (Alerts.showItemFound()) {
					Textbook textbook = textbookBag.findByTitle(title);
					String first = textbook.getAuthorFirstName();
					String last = textbook.getAuthorLastName();
					String isbn = textbook.getISBN();
					String price = String.valueOf(textbook.getPrice());
					textbookPane.setAuthorFirst(first);
					textbookPane.setAuthorLast(last);
					textbookPane.setIsbnField(isbn);
					textbookPane.setPriceField(price);
				}
			} else {
				if (Alerts.showItemNotFound()) {
					textbookPane.clearAllFields();
				}
			}
		});

		textbookPane.getUpdateBtn().setOnAction(e -> { 
			String title = textbookPane.getTitle();
			String isbn = textbookPane.getIsbn();
			String authorFirst = textbookPane.getAuthorFirst();
			String authorLast = textbookPane.getAuthorLast();
			double price = textbookPane.getPrice();
			Textbook textbook = new Textbook(title, isbn, authorFirst, authorLast, price);

			Textbook temp = textbookBag.findByTitle(title);
			if (temp != null) {
				textbookBag.deleteByTitle(temp.getTitle());
				textbookBag.insert(textbook);
				if (Alerts.showItemUpdated()) {
					textbookPane.clearAllFields();
				}
			} else {
				if (Alerts.showItemNotUpdated()) {
					textbookPane.clearAllFields();
				}
			}
		});
		
		textbookPane.getDeleteBtn().setOnAction(e -> { 
			String title = textbookPane.getTitle();
			if (textbookBag.findByTitle(title) != null) {
				Textbook textbook = textbookBag.deleteByTitle(title);
				if (Alerts.showItemDeleted()) {
					String first = textbook.getAuthorFirstName();
					String last = textbook.getAuthorLastName();
					String isbn = textbook.getISBN();
					String price = String.valueOf(textbook.getPrice());
					textbookPane.setAuthorFirst(first);
					textbookPane.setAuthorLast(last);
					textbookPane.setIsbnField(isbn);
					textbookPane.setPriceField(price);
				}
			} else {
				if (Alerts.showItemNotDeleted()) {
					textbookPane.clearAllFields();
				}
			}
		});
	}
}
