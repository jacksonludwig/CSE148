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


public class ClassroomPane {
	private static final int BUTTON_WIDTH = 120;
	private static final int BUTTON_HEIGHT = 40;
	private TextField roomNumberField;
	private TextField numberOfSeatsField;
	private TextField numberOfComputersField;
	private TextField projectorOrNotField;

	private GridPane classroomPane;
	private Button insertBtn;
	private Button searchBtn;
	private Button updateBtn;
	private Button deleteBtn;

	private ObservableList<String> buildings;
	private ComboBox<String> buildingBox;
	private HBox buttonBox1;
	private HBox buttonBox2;

	public ClassroomPane() {
		roomNumberField = new TextField();
		roomNumberField.setPromptText("Room Number");
		numberOfSeatsField = new TextField();
		numberOfSeatsField.setPromptText("Number Of Seats");
		numberOfComputersField = new TextField();
		numberOfComputersField.setPromptText("Number Of Computers");
		projectorOrNotField = new TextField();
		projectorOrNotField.setPromptText("Projector Or Not");

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

		classroomPane = new GridPane();
		classroomPane.setAlignment(Pos.CENTER);
		classroomPane.setPadding(new Insets(80));
		classroomPane.setVgap(20);
		classroomPane.setHgap(10);
		buttonBox1 = new HBox(40);
		buttonBox1.setAlignment(Pos.CENTER);
		buttonBox1.getChildren().addAll(insertBtn, searchBtn);
		buttonBox2 = new HBox(40);
		buttonBox2.setAlignment(Pos.CENTER);
		buttonBox2.getChildren().addAll(updateBtn, deleteBtn);
		buildPane();

	}

	public String getBuildingName() {
		return buildingBox.getValue();
	}

	public String getRoomNumber() {
		try {
			return getBuildingName().charAt(0) + roomNumberField.getText();
		} catch (Exception e) {
			return "X" + roomNumberField.getText();
		}
	}

	public String getNumberOfSeats() {
		try {
			return numberOfSeatsField.getText();
		} catch (Exception e) {
			return "0";
		}
	}

	public String getNumberOfComputers() {
		try {
			return numberOfComputersField.getText();
		} catch (Exception e) {
			return "0";
		}
	}

	public boolean getProjectorOrNot() {
		try {
			return Boolean.parseBoolean(projectorOrNotField.getText());
		} catch (NumberFormatException e) {
			return false;
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
		return buttonBox1;
	}
	
	public HBox getButtonBox2() {
		return buttonBox2;
	}

	private void buildPane() {
		roomNumberField.setMaxWidth(150);
		projectorOrNotField.setMaxWidth(125);
		numberOfSeatsField.setMaxWidth(150);
		numberOfComputersField.setMaxWidth(150);
		classroomPane.add(roomNumberField, 0, 0);
		classroomPane.add(buildingBox, 1, 0);
		classroomPane.add(numberOfSeatsField, 0, 1);
		classroomPane.add(numberOfComputersField, 0, 2);
		classroomPane.add(projectorOrNotField, 1, 1);
     	classroomPane.add(buttonBox1, 0, 3, 3, 2);
     	classroomPane.add(buttonBox2, 0, 5, 3, 2);
//		classroomPane.add(buttonBox1, 0, 3);
//		classroomPane.add(buttonBox2, 0, 4);
	}

	public Pane getClassroomPane() {
		return classroomPane;
	}

	public TextField getRoomNumberField() {
		return roomNumberField;
	}

	public void setRoomNumberField(TextField roomNumberField) {
		this.roomNumberField = roomNumberField;
	}

	public TextField getSeats() {
		return numberOfSeatsField;
	}

	public TextField getComputers() {
		return numberOfComputersField;
	}

	public void setNumberOfSeats(TextField numberOfSeatsField) {
		this.numberOfSeatsField = numberOfSeatsField;
	}

	public void setNumberOfComputers(TextField numberOfComputersField) {
		this.numberOfComputersField = numberOfComputersField;
	}

	public TextField getProjector() {
		return projectorOrNotField;
	}

	public void setProjectorOrNotField(TextField projectorOrNotField) {
		this.projectorOrNotField = projectorOrNotField;
	}

	public void clearAllFields() {
		roomNumberField.clear();
		numberOfSeatsField.clear();
		numberOfComputersField.clear();
		projectorOrNotField.clear();
	}

}
