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

public class FacultyPane {
	private static final int BUTTON_WIDTH = 120;
	private static final int BUTTON_HEIGHT = 40;

	private TextField idField;
	private TextField firstNameField;
	private TextField lastNameField;
	private TextField phoneNumberField;
	private TextField salaryField;
	private TextField filterInput;

	private ObservableList<String> majors;
	private ComboBox<String> majorBox;
	private FilteredList<String> coursesList;
	private ListView<String> coursesListView;
	private ObservableList<String> coursesTakingList;
	private ListView<String> coursesTakingListView;

	private GridPane facultyPane;
	private Button moveClassNearRightButton;
	private Button moveClassNearLeftButton;
	private Button insertBtn;
	private Button searchBtn;
	private Button updateBtn;
	private Button deleteBtn;
	
	private Button resetListsBtn;

	private Label allCoursesLbl;
	private Label coursesTakingLbl;

	private GridPane coursesPane;

	private HBox buttonBox;
	HBox majorAndClassResetBox;
	private VBox courseNearButtonBox;

	public FacultyPane(ObservableList<String> allCoursesList, ObservableList<String> coursesTakingList) {

		firstNameField = new TextField();
		firstNameField.setPromptText("First Name");
		lastNameField = new TextField();
		lastNameField.setPromptText("Last Name");
		phoneNumberField = new TextField();
		phoneNumberField.setPromptText("Phone Number");
		salaryField = new TextField();
		salaryField.setPromptText("Salary");

		majors = FXCollections.observableArrayList("CSE", "CST", "MAT", "ENG", "ELT", "ECO", "PHI", "COM", "HIS", "PHY",
				"CHE", "BIO", "AST", "GEO", "ART", "NUS");
		majorBox = new ComboBox<>();
		majorBox.setItems(majors);
		majorBox.setPromptText("Department");
		majorBox.setPrefSize(110, 20);

		idField = new TextField();
		idField.setPromptText("ID");

		allCoursesLbl = new Label("Course Catalogue");
		coursesTakingLbl = new Label("Courses Teaching");

		coursesList = new FilteredList<>(allCoursesList);
		this.coursesTakingList = coursesTakingList;
		coursesListView = new ListView<>(coursesList);
		coursesTakingListView = new ListView<>(coursesTakingList);

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

		coursesPane = new GridPane();
		coursesPane.setAlignment(Pos.CENTER);
		coursesPane.setPadding(new Insets(20, 0, 0, 20));
		coursesPane.setVgap(20);
		coursesPane.setHgap(20);
		courseNearButtonBox = new VBox(20);
		courseNearButtonBox.setAlignment(Pos.CENTER);
		courseNearButtonBox.getChildren().addAll(moveClassNearRightButton, moveClassNearLeftButton);
		
		resetListsBtn = new Button("Reset Courses");
		resetListsBtn.setPrefSize(110, 20);

		filterInput = new TextField();
		filterInput.setPromptText("Filter Course");

		facultyPane = new GridPane();
		facultyPane.setAlignment(Pos.CENTER);
		facultyPane.setPadding(new Insets(20));
		facultyPane.setVgap(20);
		facultyPane.setHgap(20);
		majorAndClassResetBox = new HBox(10);
		majorAndClassResetBox.setAlignment(Pos.TOP_LEFT);
		majorAndClassResetBox.getChildren().addAll(majorBox, resetListsBtn);
		buttonBox = new HBox(40);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(insertBtn, searchBtn, updateBtn, deleteBtn);
		buildPane();

	}

	public String getDepartment() {
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

		RowConstraints row1 = new RowConstraints(20);
		RowConstraints row2 = new RowConstraints(20);
		RowConstraints row3 = new RowConstraints(20);
		RowConstraints row4 = new RowConstraints(20);
		RowConstraints row5 = new RowConstraints(280);

		facultyPane.getRowConstraints().addAll(row1, row2, row3, row4, row5);

		coursesListView.setMinSize(150, 150);
		coursesTakingListView.setMinSize(150, 150);

		facultyPane.add(majorAndClassResetBox, 0, 3, 2, 1);
		facultyPane.add(firstNameField, 0, 0);
		facultyPane.add(lastNameField, 0, 1);
		facultyPane.add(phoneNumberField, 0, 2);

		coursesPane.add(allCoursesLbl, 0, 2);
		coursesPane.add(coursesListView, 0, 3);
		coursesPane.add(courseNearButtonBox, 1, 3);

		coursesPane.add(coursesTakingLbl, 2, 2);
		coursesPane.add(coursesTakingListView, 2, 3);

		coursesPane.add(filterInput, 0, 4);
		coursesPane.add(salaryField, 2, 4);
		coursesPane.setPadding(new Insets(0, 20, 60, 90));

		coursesPane.getColumnConstraints().addAll(column1, column2, column3, column4);
		facultyPane.add(coursesPane, 0, 4);
		facultyPane.add(buttonBox, 0, 5, 1, 2);
	}

	public Pane getFacultyPane() {
		return facultyPane;
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

	public ComboBox<String> getDepartmentBox() {
		return majorBox;
	}

	public void setDepartmentBox(String major) {
		majorBox.setValue(major);
	}

	public ObservableList<String> getCoursesTakingList() {
		return coursesTakingList;
	}

	public void setCoursesTakingList(ObservableList<String> coursesTakingList) {
		this.coursesTakingList = coursesTakingList;
	}

	public ListView<String> getCoursesTakingListView() {
		return coursesTakingListView;
	}

	public void setCoursesTakingListView(ListView<String> coursesTakingListView) {
		this.coursesTakingListView = coursesTakingListView;
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

	public TextField getSalaryField() {
		return salaryField;
	}

	public void setSalaryField(TextField salaryField) {
		this.salaryField = salaryField;
	}

	public TextField getPhoneNumberField() {
		return phoneNumberField;
	}

	public void setPhoneNumberField(TextField phoneNumberField) {
		this.phoneNumberField = phoneNumberField;
	}
	
	public Button getResetListsBtn() {
		return resetListsBtn;
	}

	public void setResetListsBtn(Button resetListsBtn) {
		this.resetListsBtn = resetListsBtn;
	}

	public void clearAllFields() {
		majorBox.setValue("Department");
		firstNameField.clear();
		lastNameField.clear();
		filterInput.clear();
		salaryField.clear();
		phoneNumberField.clear();
	}

}
