package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class TextbookPane {
	private static final int BUTTON_WIDTH = 120;
	private static final int BUTTON_HEIGHT = 40;
	private TextField titleField;
	private TextField isbnField;
	private TextField authorFirstField;
	private TextField authorLastField;
	private TextField priceField;

	private GridPane textbookPane;
	private Button insertBtn;
	private Button searchBtn;
	private Button updateBtn;
	private Button deleteBtn;

	private HBox buttonBox;

	public TextbookPane() {
		titleField = new TextField();
		titleField.setPromptText("Title (search index)");
		isbnField = new TextField();
		isbnField.setPromptText("ISBN");
		authorFirstField = new TextField();
		authorFirstField.setPromptText("Author First Name");
		authorLastField = new TextField();
		authorLastField.setPromptText("Author Last Name");
		priceField = new TextField();
		priceField.setPromptText("Price");

		insertBtn = new Button("INSERT");
		insertBtn.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		searchBtn = new Button("SEARCH");
		searchBtn.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		updateBtn = new Button("UPDATE");
		updateBtn.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		deleteBtn = new Button("DELETE");
		deleteBtn.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);

		textbookPane = new GridPane();
		textbookPane.setAlignment(Pos.CENTER);
		textbookPane.setPadding(new Insets(20));
		textbookPane.setVgap(20);
		textbookPane.setHgap(20);
		buttonBox = new HBox(40);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(insertBtn, searchBtn, updateBtn, deleteBtn);
		buildPane();

	}

	public String getTitle() {
		return titleField.getText();
	}

	public String getIsbn() {
		return isbnField.getText();
	}

	public String getAuthorFirst() {
		return authorFirstField.getText();
	}
	
	public String getAuthorLast() {
		return authorLastField.getText();
	}

	public double getPrice() {
		try {
			return Double.parseDouble(priceField.getText());
		} catch (NumberFormatException e) {
			return 0.0;
		}
	}

	public Button getInsertBtn() {
		return insertBtn;
	}

	public Button getSearchBtn() {
		return searchBtn;
	}

	public Button getUpdateBtn() {
		return updateBtn;
	}

	public Button getDeleteBtn() {
		return deleteBtn;
	}

	public HBox getButtonBox() {
		return buttonBox;
	}

	private void buildPane() {
		textbookPane.add(titleField, 0, 0);
		textbookPane.add(isbnField, 1, 0);
		textbookPane.add(authorFirstField, 0, 1);
		textbookPane.add(authorLastField, 0, 2);
		textbookPane.add(priceField, 1, 1);
		textbookPane.add(buttonBox, 0, 3, 2, 1);
	}

	public Pane getTextbookPane() {
		return textbookPane;
	}

	public TextField getTitleField() {
		return titleField;
	}

	public void setTitleField(String title) {
		this.titleField.setText(title);
	}

	public TextField getIsbnField() {
		return isbnField;
	}

	public void setIsbnField(String isbn) {
		this.isbnField.setText(isbn);
	}

	public TextField getFirstName() {
		return authorFirstField;
	}
	
	public TextField getLastName() {
		return authorLastField;
	}

	public void setAuthorFirst(String name) {
		this.authorFirstField.setText(name);
	}
	
	public void setAuthorLast(String name) {
		this.authorLastField.setText(name);
	}

	public TextField getPriceField() {
		return priceField;
	}

	public void setPriceField(String price) {
		this.priceField.setText(price);
	}

	public void clearAllFields() {
		titleField.clear();
		isbnField.clear();
		authorFirstField.clear();
		authorLastField.clear();
		priceField.clear();
	}

}
