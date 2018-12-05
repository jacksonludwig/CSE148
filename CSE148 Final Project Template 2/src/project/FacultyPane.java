package project;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class FacultyPane {
	private GridPane gridPane;
	private Button addBtn;
	private Button findBtn;
	private Button removeBtn;
	private Button updateBtn;

	private TextField nameField;
	private TextField phoneField;

	public FacultyPane(College college) {
		final int BUTTON_WIDTH = 110;
		final int TEXTFIELD_WIDTH = 250;
		gridPane = new GridPane();
		gridPane.setPadding(new Insets(30));
		gridPane.setHgap(20);
		gridPane.setVgap(30);
		nameField = new TextField();
		nameField.setPromptText("Name");
		nameField.setPrefWidth(TEXTFIELD_WIDTH);
		phoneField = new TextField();
		phoneField.setPromptText("Phone");
		phoneField.setPrefWidth(TEXTFIELD_WIDTH);
		addBtn = new Button("ADD");
		addBtn.setPrefWidth(BUTTON_WIDTH);
		
		addBtn.setOnAction(e -> {
			Person person = new Person(nameField.getText(), phoneField.getText());
			college.getPersonBag().insert(person);
			System.out.println(person);
			nameField.clear();
			phoneField.clear();
		});
		
		findBtn = new Button("FIND");
		findBtn.setPrefWidth(BUTTON_WIDTH);
		removeBtn = new Button("Remove");
		removeBtn.setPrefWidth(BUTTON_WIDTH);
		updateBtn = new Button("Update");
		updateBtn.setPrefWidth(BUTTON_WIDTH);

		HBox btnBox = new HBox(20);

		btnBox.setAlignment(Pos.CENTER);
		btnBox.getChildren().addAll(addBtn, findBtn, removeBtn, updateBtn);
		
		gridPane.add(nameField, 0, 0, 2, 1);
		gridPane.add(phoneField, 2, 0, 2, 1);
//		gridPane.add(addBtn, 0, 1);
//		gridPane.add(findBtn, 1, 1);
//		gridPane.add(removeBtn, 2, 1);
//		gridPane.add(updateBtn, 3, 1);
		
		gridPane.add(btnBox, 0, 2, 4, 1);
	}
	
	public GridPane getGridPane() {
		return gridPane;
	}
}
