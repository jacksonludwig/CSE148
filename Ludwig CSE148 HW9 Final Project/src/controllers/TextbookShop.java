package controllers;
// controller package will effectively combine/connect the data from model with the view classes.

import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.Textbook;
import model.TextbookBag;
import utilities.Utilities;
import view.TextbookPane;

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
			// returns the gridpane into the center of the root/borderpane. Callback 1.
			root.setCenter(textbookPane.getTextbookPane());
		});
		
		textbookPane.getInsertBtn().setOnAction(e -> { // Callback 2.
			String title = textbookPane.getTitle();
			String isbn = textbookPane.getIsbn();
			String authorFirst = textbookPane.getAuthorFirst();
			String authorLast = textbookPane.getAuthorLast();
			double price = textbookPane.getPrice();
			Textbook textbook = new Textbook(title, isbn, authorFirst, authorLast, price);
			textbookBag.insert(textbook);
			textbookPane.clearAllFields();
			System.out.println("The book is added");
		});
		
		textbookPane.getSearchBtn().setOnAction(e -> { // Callback 2.
			String title = textbookPane.getTitle();
			if(textbookBag.findByTitle(title) != null) {
				if(Utilities.showItemFound() == true) {
					textbookPane.clearAllFields();
				}
			} else {
				if(Utilities.showItemNotFound() == true) {
					textbookPane.clearAllFields();
				}
			}
			//textbookPane.clearAllFields();
			System.out.println("The book was searched for");
		});
	}

}
