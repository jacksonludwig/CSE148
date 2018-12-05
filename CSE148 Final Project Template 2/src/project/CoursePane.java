package project;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CoursePane {
	private GridPane gridPane;
	private Button addBtn;
	private Button findBtn;
	private Button removeBtn;
	private Button updateBtn;

	private TextField nameField;
	private TextField phoneField;

	private Text text;

	public CoursePane(College college) {
		final int BUTTON_WIDTH = 110;
		final int TEXTFIELD_WIDTH = 250;
		text = new Text("Course Pane");
		text.setFont(Font.font("Verdana", 20));
		text.setStrokeWidth(6);
		text.setFill(Color.RED);
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
		removeBtn = new Button("REMOTE");
		removeBtn.setPrefWidth(BUTTON_WIDTH);
		updateBtn = new Button("UPDATE");
		updateBtn.setPrefWidth(BUTTON_WIDTH);

		HBox btnBox = new HBox(20);

		btnBox.setAlignment(Pos.CENTER);
		btnBox.getChildren().addAll(addBtn, findBtn, removeBtn, updateBtn);

		gridPane.add(nameField, 0, 0, 2, 1);
		gridPane.add(phoneField, 2, 0, 2, 1);
		gridPane.add(btnBox, 0, 2, 4, 1);
		gridPane.add(text, 1, 3, 4, 1);
	}

	public GridPane getGridPane() {
		return gridPane;
	}
}
