package controllers;

// controller package will effectively combine/connect the data from model with the view classes.
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.Textbook;
import model.TextbookBag;
import utilities.Alerts;
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
			if (textbookBag.findByTitle(textbook.getTitle()) != null) {
				if (Alerts.showRepeatItem()) {
					textbookPane.clearAllFields();
				}
			} else {
				textbookBag.insert(textbook);
				if (Alerts.showItemInserted()) {
					textbookPane.clearAllFields();
				}
				System.out.println("The book is added");
			}

		});

		textbookPane.getSearchBtn().setOnAction(e -> { // Callback 2.
			String title = textbookPane.getTitle();
			if (textbookBag.findByTitle(title) != null) {
				if (Alerts.showItemFound()) {
					textbookPane.clearAllFields();
				}
			} else {
				if (Alerts.showItemNotFound()) {
					textbookPane.clearAllFields();
				}
			}
			System.out.println("The book was searched for");
		});

		textbookPane.getUpdateBtn().setOnAction(e -> { // Callback 2.
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

			System.out.println("The book was updated");
		});
		
		textbookPane.getDeleteBtn().setOnAction(e -> { // Callback 2.
			String title = textbookPane.getTitle();
			if (textbookBag.findByTitle(title) != null) {
				textbookBag.deleteByTitle(title);
				if (Alerts.showItemDeleted()) {
					textbookPane.clearAllFields();
				}
			} else {
				if (Alerts.showItemNotDeleted()) {
					textbookPane.clearAllFields();
				}
			}
			System.out.println("The book was searched for");
		});
	}

//	public static boolean checkForCompleteData(TextbookPane textbookPane) {
//		if (textbookPane.getAuthorFirst() != null && textbookPane.getAuthorLast() != null
//				&& textbookPane.getIsbn() != null && String.valueOf(textbookPane.getPrice()) != null) {
//			return true;
//		}
//		return false;
//	}

}
