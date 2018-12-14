package p2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StudentPane {
	private GridPane studentPane;
	private TextField nameField;
	private TextField idField;
	private TextField gpaField;

	private Button insertBtn;
	private Button saveBtn;
	private Button loadBtn;

	public StudentPane() {
		studentPane = new GridPane();

		nameField = new TextField();
		nameField.setPromptText("Name");
		idField = new TextField();
		idField.setPromptText("ID");
		gpaField = new TextField();
		gpaField.setPromptText("GPA");

		insertBtn = new Button("Insert");
		saveBtn = new Button("Save");
		loadBtn = new Button("Load");
		buildPane();
	}

	public void buildPane() {
		studentPane.setAlignment(Pos.CENTER);
		studentPane.setPadding(new Insets(20));

		studentPane.add(nameField, 0, 0);
		studentPane.add(idField, 0, 1);
		studentPane.add(gpaField, 0, 2);

		studentPane.add(insertBtn, 1, 0);
		studentPane.add(insertBtn, 1, 1);
		studentPane.add(insertBtn, 1, 2);
	}

	public GridPane getStudentPane() {
		return studentPane;
	}

	public void setStudentPane(GridPane studentPane) {
		this.studentPane = studentPane;
	}

	public TextField getNameField() {
		return nameField;
	}

	public void setNameField(TextField nameField) {
		this.nameField = nameField;
	}

	public TextField getIdField() {
		return idField;
	}

	public void setIdField(TextField idField) {
		this.idField = idField;
	}

	public TextField getGpaField() {
		return gpaField;
	}

	public void setGpaField(TextField gpaField) {
		this.gpaField = gpaField;
	}

	public Button getInsertBtn() {
		return insertBtn;
	}

	public void setInsertBtn(Button insertBtn) {
		this.insertBtn = insertBtn;
	}

	public Button getSaveBtn() {
		return saveBtn;
	}

	public void setSaveBtn(Button saveBtn) {
		this.saveBtn = saveBtn;
	}

	public Button getLoadBtn() {
		return loadBtn;
	}

	public void setLoadBtn(Button loadBtn) {
		this.loadBtn = loadBtn;
	}

}
