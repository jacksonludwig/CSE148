package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class CoursePane {
	private static final int BUTTON_WIDTH = 120;
	private static final int BUTTON_HEIGHT = 40;
	private TextField courseTitleShortField;
	private TextField courseTitleLongField;
	private TextField courseDescriptionField;
	private TextField credits;
	private TextField facultyIDField;
	private TextField textbookISBNField;
	private TextField classroomField;
	
	private ObservableList<String> buildings;
	private ComboBox<String> buildingBox;

	private GridPane coursePane;
	private Button insertBtn;
	private Button searchBtn;
	private Button updateBtn;
	private Button deleteBtn;

	private HBox buttonBox;

	public CoursePane() {
		courseTitleShortField = new TextField();
		courseTitleShortField.setPromptText("Course Title (search index)");
		courseTitleShortField.setMinSize(200, 20);
		courseTitleLongField = new TextField();
		courseTitleLongField.setPromptText("Full Course Title");
		courseDescriptionField = new TextField();
		courseDescriptionField.setPromptText("Course Description");
		credits = new TextField();
		credits.setPromptText("Number of Credits For Class");
		credits.setMaxWidth(165);
		facultyIDField = new TextField();
		facultyIDField.setPromptText("Faculty ID");
		textbookISBNField = new TextField();
		textbookISBNField.setPromptText("Textbook ISBN");
		classroomField = new TextField();
		classroomField.setPromptText("Classroom");
		
		buildings = FXCollections.observableArrayList("Smithtown", "Babylon", "Ammerman", "Riverhead", "Southhampton",
				"Shea", "Kreiling", "Brookhaven");
		buildingBox = new ComboBox<>();
		buildingBox.setItems(buildings);
		buildingBox.setPromptText("Building Name");

		insertBtn = new Button("INSERT");
		insertBtn.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		searchBtn = new Button("SEARCH");
		searchBtn.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		updateBtn = new Button("UPDATE");
		updateBtn.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		deleteBtn = new Button("DELETE");
		deleteBtn.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);

		coursePane = new GridPane();
		coursePane.setAlignment(Pos.CENTER);
		coursePane.setPadding(new Insets(20));
		coursePane.setVgap(20);
		coursePane.setHgap(20);
		buttonBox = new HBox(40);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(insertBtn, searchBtn, updateBtn, deleteBtn);
		buildPane();

	}

	public String getCourseTitleShort() {
		return courseTitleShortField.getText();
	}

	public String getCourseTitleLong() {
		return courseTitleLongField.getText();
	}

	public String getCourseDescription() {
		return courseDescriptionField.getText();
	}

	public String getFacultyID() {
		return facultyIDField.getText();
	}

	public String getTextbookISBN() {
		return textbookISBNField.getText();
	}

	public String getClassroom() {
		return classroomField.getText();
	}
	
	public String getBuildingName() {
		return buildingBox.getValue();
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
		coursePane.add(courseTitleShortField, 0, 0);
		coursePane.add(courseTitleLongField, 0, 1);
		coursePane.add(courseDescriptionField, 1, 0);
		coursePane.add(facultyIDField, 0, 2);
		coursePane.add(textbookISBNField, 1, 1);
		coursePane.add(classroomField, 1, 2);
		coursePane.add(buildingBox, 0, 3);
		coursePane.add(credits, 1, 3);
		coursePane.add(buttonBox, 0, 4, 2, 1);
	}

	public Pane getCoursePane() {
		return coursePane;
	}

	public TextField getCourseTitleShortField() {
		return courseTitleShortField;
	}

	public void setCourseTitleShortField(String title) {
		this.courseTitleShortField.setText(title);
	}

	public TextField getCourseTitleLongField() {
		return courseTitleLongField;
	}

	public void setCourseTitleLongField(String title) {
		this.courseTitleLongField.setText(title);
	}

	public TextField getCourseDescriptionField() {
		return courseDescriptionField;
	}

	public TextField getFacultyIDField() {
		return facultyIDField;
	}

	public void setCourseDescriptionField(String desc) {
		this.courseDescriptionField.setText(desc);
	}

	public void setFacultyIDField(String id) {
		this.facultyIDField.setText(id);
	}

	public TextField getPriceField() {
		return textbookISBNField;
	}

	public void setTextbookISBNField(String isbn) {
		this.textbookISBNField.setText(isbn);
	}

	public TextField getClassroomField() {
		return classroomField;
	}

	public void setClassroomField(String classroom) {
		this.classroomField.setText(classroom);
	}
	
	public void setNumberOfCredits(String credits) {
		this.credits.setText(credits);
	}

	public void setBuildingBox(String building) {
		buildingBox.setValue(building);
	}
	
	public void clearAllFields() {
		courseTitleShortField.clear();
		courseTitleLongField.clear();
		courseDescriptionField.clear();
		facultyIDField.clear();
		textbookISBNField.clear();
		classroomField.clear();
		credits.clear();
		buildingBox.setValue("Building Name");
	}

	public double getCredits() {
		try {
			return Double.parseDouble(credits.getText());
		} catch (NumberFormatException e) {
			return 0.0;
		}
	}

}
