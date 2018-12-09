package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class StudentPane {
	private static final int BUTTON_WIDTH = 120;
	private static final int BUTTON_HEIGHT = 40;

	private TextField idField; // only search by
	private TextField firstNameField;
	private TextField lastNameField;
	private TextField phoneNumberField;

	private ObservableList<String> majors;
	private ComboBox<String> majorBox;
	private ObservableList<String> coursesTakingList; // put in shop
	private ListView<String> coursesTakingListView;
	private ObservableList<String> coursesToTakeList; // put in shop
	private ListView<String> coursesToTakeListView;
	private ObservableList<String> coursesTakenList; // put in shop
	private ListView<String> coursesTakenListView;

	private GridPane studentPane;
	private Button moveClassRightButton;
	private Button moveClassFarRightButton;
	private Button moveClassLeftButton;
	private Button moveClassFarLeftButton;
	private Button insertBtn;
	private Button searchBtn;
	private Button updateBtn;
	private Button deleteBtn;

	private Label coursesToTakeLbl;
	private Label coursesTakingLbl;
	private Label coursesTakenLbl;
	private Label gpaLabel;
	private Label dynamicGpa;

	private GridPane coursesPane;

	private HBox buttonBox;
	private VBox courseButtonBox;
	private VBox courseFarButtonBox;

	public StudentPane(ObservableList<String> coursesToTakeList, ObservableList<String> coursesTakingList,
			ObservableList<String> coursesTakenList) {
		phoneNumberField = new TextField();
		phoneNumberField.setPromptText("Phone Number");

		firstNameField = new TextField();
		firstNameField.setPromptText("First Name");
		lastNameField = new TextField();
		lastNameField.setPromptText("Last Name");

		majors = FXCollections.observableArrayList("CSE", "CST", "MAT", "ENG", "ELT", "ECO", "PHI", "COM", "HIS", "PHY",
				"CHE", "BIO", "AST", "GEO", "ART", "NUS");
		majorBox = new ComboBox<>();
		majorBox.setItems(majors);
		majorBox.setPromptText("Major");

		idField = new TextField();
		idField.setPromptText("ID");

		coursesToTakeLbl = new Label("Courses To Take");
		coursesTakingLbl = new Label("Courses Taking");
		coursesTakenLbl = new Label("Courses Taken");
		dynamicGpa = new Label("GPA: 0.0");

		this.coursesToTakeList = coursesToTakeList;
		this.coursesTakingList = coursesTakingList;
		this.coursesTakenList = coursesTakenList;
		coursesTakingListView = new ListView<>(coursesTakingList);
		coursesToTakeListView = new ListView<>(coursesToTakeList);
		coursesTakenListView = new ListView<>(coursesTakenList);

		moveClassRightButton = new Button("->");
		moveClassRightButton.setPrefSize(30, 30);
		moveClassFarRightButton = new Button("->");
		moveClassFarRightButton.setPrefSize(30, 30);
		moveClassLeftButton = new Button("<-");
		moveClassLeftButton.setPrefSize(30, 30);
		moveClassFarLeftButton = new Button("<-");
		moveClassFarLeftButton.setPrefSize(30, 30);
		insertBtn = new Button("INSERT");
		insertBtn.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		searchBtn = new Button("SEARCH");
		searchBtn.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		updateBtn = new Button("UPDATE");
		updateBtn.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		deleteBtn = new Button("DELETE");
		deleteBtn.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);

		coursesPane = new GridPane();
		coursesPane.setAlignment(Pos.CENTER);
		coursesPane.setPadding(new Insets(20));
		coursesPane.setVgap(20);
		coursesPane.setHgap(20);
		courseButtonBox = new VBox(20);
		courseButtonBox.setAlignment(Pos.CENTER);
		courseButtonBox.getChildren().addAll(moveClassRightButton, moveClassLeftButton);
		courseFarButtonBox = new VBox(20);
		courseFarButtonBox.setAlignment(Pos.CENTER);
		courseFarButtonBox.getChildren().addAll(moveClassFarRightButton, moveClassFarLeftButton);

		studentPane = new GridPane();
		studentPane.setAlignment(Pos.CENTER);
		studentPane.setPadding(new Insets(20));
		studentPane.setVgap(20);
		studentPane.setHgap(20);
		buttonBox = new HBox(40);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(insertBtn, searchBtn, updateBtn, deleteBtn);
		buildPane();

	}

	public void setDynamicGpa(double gpa) {
		dynamicGpa.setText("GPA: " + String.valueOf(gpa));
	}
	
	public Label getGpaLabel() {
		return gpaLabel;
	}

	public void setGpaLabel(Label gpaLabel) {
		this.gpaLabel = gpaLabel;
	}

	public Label getDynamicGpa() {
		return dynamicGpa;
	}

	public void setDynamicGpa(Label dynamicGpa) {
		this.dynamicGpa = dynamicGpa;
	}

	public String getPhoneNumber() {
		return phoneNumberField.getText();
	}

	public String getMajor() {
		return majorBox.getValue();
	}

	public String getFirst() {
		return firstNameField.getText();
	}

	public String getLast() {
		return lastNameField.getText();
	}

//	public double getGpaField() {
//		try {
//			return Double.parseDouble(gpaField.getText());
//		} catch (NumberFormatException e) {
//			return 0.0;
//		}
//	}

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
		ColumnConstraints column1 = new ColumnConstraints(50, 150, Double.MAX_VALUE);
		ColumnConstraints column2 = new ColumnConstraints(50);
		ColumnConstraints column3 = new ColumnConstraints(150, 150, Double.MAX_VALUE);
		ColumnConstraints column4 = new ColumnConstraints(50);
		ColumnConstraints column5 = new ColumnConstraints(150, 150, Double.MAX_VALUE);

		studentPane.add(phoneNumberField, 0, 2);
		studentPane.add(majorBox, 1, 0);
		studentPane.add(dynamicGpa, 1, 3);
		studentPane.add(firstNameField, 0, 0);
		studentPane.add(lastNameField, 0, 1);

		coursesPane.add(coursesToTakeLbl, 0, 3);
		coursesPane.add(coursesToTakeListView, 0, 4);
		coursesPane.add(courseButtonBox, 1, 4);

		coursesPane.add(coursesTakingLbl, 2, 3);
		coursesPane.add(coursesTakingListView, 2, 4);
		coursesPane.add(courseFarButtonBox, 3, 4);

		coursesPane.add(coursesTakenLbl, 4, 3);
		coursesPane.add(coursesTakenListView, 4, 4);

		coursesPane.getColumnConstraints().addAll(column1, column2, column3, column4, column5);
//		studentPane.add(gpaField, 1, 1);
		studentPane.add(coursesPane, 0, 3);
		studentPane.add(buttonBox, 0, 6, 1, 1);

	}

	public Pane getStudentPane() {
		return studentPane;
	}

	public TextField getPhoneNumberField() {
		return phoneNumberField;
	}

	public void setPhoneNumberField(TextField phoneNumberField) {
		this.phoneNumberField = phoneNumberField;
	}

	public TextField getFirstName() {
		return firstNameField;
	}

	public TextField getLastName() {
		return lastNameField;
	}

	public void setAuthorFirst(TextField firstNameField) {
		this.firstNameField = firstNameField;
	}

	public void setAuthorLast(TextField lastNameField) {
		this.lastNameField = lastNameField;
	}

//	public TextField getGpaField() {
//		return gpaField;
//	}
//
//	public void setGpaField(TextField gpaField) {
//		this.gpaField = gpaField;
//	}

	public ObservableList<String> getCoursesTakingList() {
		return coursesTakingList;
	}

	public void setCoursesTakingList(ObservableList<String> coursesTakingList) {
		this.coursesTakingList = coursesTakingList;
	}

	public ObservableList<String> getCoursesToTakeList() {
		return coursesToTakeList;
	}

	public void setCoursesToTakeList(ObservableList<String> coursesToTakeList) {
		this.coursesToTakeList = coursesToTakeList;
	}

	public ObservableList<String> getCoursesTakenList() {
		return coursesTakenList;
	}

	public void setCoursesTakenList(ObservableList<String> coursesTakenList) {
		this.coursesTakenList = coursesTakenList;
	}

	public Button getMoveClassRightButton() {
		return moveClassRightButton;
	}

	public void setMoveClassRightButton(Button moveClassRightButton) {
		this.moveClassRightButton = moveClassRightButton;
	}

	public Button getMoveClassFarRightButton() {
		return moveClassFarRightButton;
	}

	public void setMoveClassFarRightButton(Button moveClassFarRightButton) {
		this.moveClassFarRightButton = moveClassFarRightButton;
	}

	public Button getMoveClassLeftButton() {
		return moveClassLeftButton;
	}

	public void setMoveClassLeftButton(Button moveClassLeftButton) {
		this.moveClassLeftButton = moveClassLeftButton;
	}

	public Button getMoveClassFarLeftButton() {
		return moveClassFarLeftButton;
	}

	public void setMoveClassFarLeftButton(Button moveClassFarLeftButton) {
		this.moveClassFarLeftButton = moveClassFarLeftButton;
	}

	public ListView<String> getCoursesTakingListView() {
		return coursesTakingListView;
	}

	public void setCoursesTakingListView(ListView<String> coursesTakingListView) {
		this.coursesTakingListView = coursesTakingListView;
	}

	public ListView<String> getCoursesToTakeListView() {
		return coursesToTakeListView;
	}

	public void setCoursesToTakeListView(ListView<String> coursesToTakeListView) {
		this.coursesToTakeListView = coursesToTakeListView;
	}

	public ListView<String> getCoursesTakenListView() {
		return coursesTakenListView;
	}

	public void setCoursesTakenListView(ListView<String> coursesTakenListView) {
		this.coursesTakenListView = coursesTakenListView;
	}

	public void clearAllFields() {
		phoneNumberField.clear();
//		majorField.clear();
		firstNameField.clear();
		lastNameField.clear();
		setDynamicGpa(0.0);
//		gpaField.clear();
	}

}
