package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
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
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public class StudentPane {
	private static final int BUTTON_WIDTH = 120;
	private static final int BUTTON_HEIGHT = 40;

	private TextField idField;
	private TextField firstNameField;
	private TextField lastNameField;
	private TextField phoneNumberField;
	private TextField filterInput;

	private ObservableList<String> majors;
	private ComboBox<String> majorBox;
	private FilteredList<String> coursesList;
	private ListView<String> coursesListView;
	private ObservableList<String> coursesTakingList;
	private ListView<String> coursesTakingListView;
	private ObservableList<String> coursesToTakeList;
	private ListView<String> coursesToTakeListView;
	private ObservableList<String> coursesTakenList;
	private ListView<String> coursesTakenListView;

	private GridPane studentPane;
	private Button moveClassRightButton;
	private Button moveClassFarRightButton;
	private Button moveClassLeftButton;
	private Button moveClassFarLeftButton;
	private Button moveClassNearRightButton;
	private Button moveClassNearLeftButton;
	private Button insertBtn;
	private Button searchBtn;
	private Button updateBtn;
	private Button deleteBtn;
	private Button resetListsBtn;

	private Label allCoursesLbl;
	private Label coursesToTakeLbl;
	private Label coursesTakingLbl;
	private Label coursesTakenLbl;
	private Label gpaLabel;
	private Label dynamicGpa;

	private GridPane coursesPane;

	private HBox buttonBox;
	private VBox courseButtonBox;
	private VBox courseFarButtonBox;
	private VBox courseNearButtonBox;

	public StudentPane(ObservableList<String> allCoursesList, ObservableList<String> coursesToTakeList,
			ObservableList<String> coursesTakingList, ObservableList<String> coursesTakenList) {
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
		majorBox.setPrefSize(95, 20);

		idField = new TextField();
		idField.setPromptText("ID");

		allCoursesLbl = new Label("Course Catalogue");
		coursesToTakeLbl = new Label("Courses To Take");
		coursesTakingLbl = new Label("Courses Taking");
		coursesTakenLbl = new Label("Courses Taken");
		dynamicGpa = new Label("GPA: 0.0");

		coursesList = new FilteredList<>(allCoursesList);
		this.coursesToTakeList = coursesToTakeList;
		this.coursesTakingList = coursesTakingList;
		this.coursesTakenList = coursesTakenList;
		coursesListView = new ListView<>(coursesList);
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
		moveClassNearRightButton = new Button("->");
		moveClassNearRightButton.setPrefSize(30, 30);
		moveClassNearLeftButton = new Button("<-");
		moveClassNearLeftButton.setPrefSize(30, 30);

		insertBtn = new Button("INSERT");
		insertBtn.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		searchBtn = new Button("SEARCH");
		searchBtn.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		updateBtn = new Button("UPDATE");
		updateBtn.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		deleteBtn = new Button("DELETE");
		deleteBtn.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);

		resetListsBtn = new Button("Reset Courses");
		resetListsBtn.setPrefSize(95, 20);

		coursesPane = new GridPane();
		coursesPane.setAlignment(Pos.CENTER);
		coursesPane.setPadding(new Insets(20, 20, 0, 20));
		coursesPane.setVgap(20);
		coursesPane.setHgap(20);
		courseNearButtonBox = new VBox(20);
		courseNearButtonBox.setAlignment(Pos.CENTER);
		courseNearButtonBox.getChildren().addAll(moveClassNearRightButton, moveClassNearLeftButton);
		courseButtonBox = new VBox(20);
		courseButtonBox.setAlignment(Pos.CENTER);
		courseButtonBox.getChildren().addAll(moveClassRightButton, moveClassLeftButton);
		courseFarButtonBox = new VBox(20);
		courseFarButtonBox.setAlignment(Pos.CENTER);
		courseFarButtonBox.getChildren().addAll(moveClassFarRightButton, moveClassFarLeftButton);

		filterInput = new TextField();
		filterInput.setPromptText("Filter Course");

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
		ColumnConstraints column6 = new ColumnConstraints(50);
		ColumnConstraints column7 = new ColumnConstraints(150, 150, Double.MAX_VALUE);

		RowConstraints row1 = new RowConstraints(20);
		RowConstraints row2 = new RowConstraints(20);
		RowConstraints row3 = new RowConstraints(20);
		RowConstraints row4 = new RowConstraints(280);
		RowConstraints row5 = new RowConstraints(280);

		studentPane.getRowConstraints().addAll(row1, row2, row3, row4);

		coursesListView.setMinSize(150, 150);
		coursesToTakeListView.setMinSize(150, 150);
		coursesTakingListView.setMinSize(150, 150);
		coursesTakenListView.setMinSize(150, 150);

		studentPane.add(phoneNumberField, 0, 2);
		studentPane.add(majorBox, 1, 0);
		studentPane.add(dynamicGpa, 1, 3);
		studentPane.add(firstNameField, 0, 0);
		studentPane.add(lastNameField, 0, 1);
		studentPane.add(resetListsBtn, 1, 1);

		coursesPane.add(allCoursesLbl, 0, 3);
		coursesPane.add(coursesListView, 0, 4);
		coursesPane.add(courseNearButtonBox, 1, 4);

		coursesPane.add(coursesToTakeLbl, 2, 3);
		coursesPane.add(coursesToTakeListView, 2, 4);
		coursesPane.add(courseButtonBox, 3, 4);

		coursesPane.add(coursesTakingLbl, 4, 3);
		coursesPane.add(coursesTakingListView, 4, 4);
		coursesPane.add(courseFarButtonBox, 5, 4);

		coursesPane.add(coursesTakenLbl, 6, 3);
		coursesPane.add(coursesTakenListView, 6, 4);

		coursesPane.add(filterInput, 0, 5);
		coursesPane.setPadding(new Insets(0, 0, 40, 0));

		coursesPane.getColumnConstraints().addAll(column1, column2, column3, column4, column5, column6, column7);
		studentPane.add(coursesPane, 0, 3);
		studentPane.add(buttonBox, 0, 5, 1, 2);
	}

	public Pane getStudentPane() {
		return studentPane;
	}

	public TextField getPhoneNumberField() {
		return phoneNumberField;
	}

	public void setPhoneNumberField(String number) {
		phoneNumberField.setText(number);
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

	public TextField getIdField() {
		return idField;
	}

	public void setIdField(String id) {
		idField.setText(id);
	}

	public TextField getFirstNameField() {
		return firstNameField;
	}

	public void setFirstNameField(String name) {
		firstNameField.setText(name);
	}

	public TextField getLastNameField() {
		return lastNameField;
	}

	public void setLastNameField(String name) {
		lastNameField.setText(name);
	}

	public ComboBox<String> getMajorBox() {
		return majorBox;
	}

	public void setMajorBox(String major) {
		majorBox.setValue(major);
	}

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

	public FilteredList<String> getCoursesList() {
		return coursesList;
	}

	public void setCoursesList(ObservableList<String> coursesList) {
		this.coursesList = new FilteredList<>(coursesList);
	}

	public ListView<String> getCoursesListView() {
		return coursesListView;
	}

	public void setCoursesListView(ListView<String> coursesListView) {
		this.coursesListView = coursesListView;
	}

	public Button getMoveClassNearRightButton() {
		return moveClassNearRightButton;
	}

	public void setMoveClassNearRightButton(Button moveClassNearRightButton) {
		this.moveClassNearRightButton = moveClassNearRightButton;
	}

	public Button getMoveClassNearLeftButton() {
		return moveClassNearLeftButton;
	}

	public void setMoveClassNearLeftButton(Button moveClassNearLeftButton) {
		this.moveClassNearLeftButton = moveClassNearLeftButton;
	}

	public VBox getCourseNearButtonBox() {
		return courseNearButtonBox;
	}

	public void setCourseNearButtonBox(VBox courseNearButtonBox) {
		this.courseNearButtonBox = courseNearButtonBox;
	}

	public TextField getFilterInput() {
		return filterInput;
	}

	public void setFilterInput(String filter) {
		this.filterInput.setText(filter);
	}

	public Button getResetListsBtn() {
		return resetListsBtn;
	}

	public void setResetListsBtn(Button resetListsBtn) {
		this.resetListsBtn = resetListsBtn;
	}

	public void clearAllFields() {
		phoneNumberField.clear();
		majorBox.setValue("Major");
		firstNameField.clear();
		lastNameField.clear();
		filterInput.clear();
		setDynamicGpa(0.0);

	}

}
