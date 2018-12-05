package project;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class TextbookPane {
	private GridPane gridPane;
	private Button addBtn;
	private Button findBtn;
	private Button removeBtn;
	private Button updateBtn;

	private TextField nameField;
	private TextField priceField;
	private TextField isbnField;
	
	private Label actionStatus = new Label("HI");

	public TextbookPane(College college) {
		final int BUTTON_WIDTH = 110;
		final int TEXTFIELD_WIDTH = 250;
		gridPane = new GridPane();
		gridPane.setPadding(new Insets(30));
		gridPane.setHgap(20);
		gridPane.setVgap(30);
		nameField = new TextField();
		nameField.setPromptText("Name");
		nameField.setPrefWidth(TEXTFIELD_WIDTH);

		isbnField = new TextField();
		isbnField.setPromptText("ISBN");
		isbnField.setPrefWidth(TEXTFIELD_WIDTH);

		priceField = new TextField();
		priceField.setPromptText("Price");
		priceField.setPrefWidth(TEXTFIELD_WIDTH);
		addBtn = new Button("ADD");
		addBtn.setPrefWidth(BUTTON_WIDTH);

		addBtn.setOnAction(e -> {
			actionStatus.setText("");
			if (Util.inputCheck(nameField)) {
				Textbook textbook = new Textbook(nameField.getText(), isbnField.getText(),
						Double.parseDouble(priceField.getText()));
				college.getTextbookBag().insert(textbook);
				nameField.clear();
				isbnField.clear();
				priceField.clear();
				actionStatus = Util.getActionStatus();
			}
		});

		findBtn = new Button("FIND");
		findBtn.setPrefWidth(BUTTON_WIDTH);
		findBtn.setOnAction(e -> {
			String isbn = Util.requestID();
			Textbook textbook = college.getTextbookBag().findByISBN(isbn);
			try {
				nameField.setText(textbook.getTitle());
				isbnField.setText(textbook.getIsbn());
				priceField.setText(String.valueOf(textbook.getPrice()));
			} catch (NullPointerException el) {
				Util.failureAlert("Item not found");
			}
			
		});

		removeBtn = new Button("REMOVE");
		removeBtn.setPrefWidth(BUTTON_WIDTH);
		removeBtn.setOnAction(e -> {
			actionStatus.setText("");
			String isbn = Util.requestID();
			Textbook textbook = college.getTextbookBag().removeByISBN(isbn);
			if(textbook != null) {
			nameField.setText(textbook.getTitle());
			isbnField.setText(textbook.getIsbn());
			priceField.setText(String.valueOf(textbook.getPrice()));
			Util.confirm();
			nameField.clear();
			isbnField.clear();
			priceField.clear();
//			actionStatus = Util.getActionStatus();
			actionStatus.setText("Item removed");
			} else {
				Util.failureAlert("Item cannot be found");
			}
		});
		
		
		updateBtn = new Button("UPDATE");
		updateBtn.setPrefWidth(BUTTON_WIDTH);

		HBox btnBox = new HBox(20);

		btnBox.setAlignment(Pos.CENTER);
		btnBox.getChildren().addAll(addBtn, findBtn, removeBtn, updateBtn);

		gridPane.add(nameField, 0, 0, 2, 1);
		gridPane.add(isbnField, 2, 0, 2, 1);
		gridPane.add(priceField, 4, 0, 2, 1);
		
		gridPane.add(btnBox, 0, 2, 6, 1);
		
		gridPane.add(actionStatus, 1,3,4,1);
	}

	public GridPane getGridPane() {
		return gridPane;
	}
	
	public Label getActionStatus() {
		return actionStatus;
	}
	
	
	
}
