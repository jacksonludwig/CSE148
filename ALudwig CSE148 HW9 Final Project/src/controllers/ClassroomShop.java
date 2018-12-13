package controllers;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.Classroom;
import model.ClassroomBag;
import utilities.Alerts;
import view.ClassroomPane;

// Searches by ROOM NUMBER (without letter).

public class ClassroomShop {
	private ClassroomPane classroomPane;
	private MenuBarShop menuBarShop;
	private ClassroomBag classroomBag;
	private BorderPane root;

	public ClassroomShop(ClassroomBag classroomBag, MenuBarShop menuBarShop, BorderPane root) {
		classroomPane = new ClassroomPane();
		this.menuBarShop = menuBarShop;
		this.classroomBag = classroomBag;
		this.root = root;
		setCallbacks();
	}

	public Pane getClassroomPane() {
		return classroomPane.getClassroomPane();
	}

	private void setCallbacks() {
		menuBarShop.getInsertClassroomMenuItem().setOnAction(e -> {
			root.setCenter(classroomPane.getClassroomPane());
		});

		classroomPane.getInsertBtn().setOnAction(e -> {
			String buildingName = classroomPane.getBuildingName();
			String roomNumber = classroomPane.getRoomNumber();
			int numberOfSeats = 0;
			int numberOfComputers = 0;
			if (!(classroomPane.getNumberOfSeats().equals(""))) {
				numberOfSeats = Integer.parseInt(classroomPane.getNumberOfSeats());
				numberOfComputers = Integer.parseInt(classroomPane.getNumberOfComputers());
			}
			boolean projectorOrNot = classroomPane.getProjectorOrNot();
			Classroom classroom = new Classroom(roomNumber, buildingName, numberOfSeats, numberOfComputers,
					projectorOrNot);
			if (classroomBag.findByRoom(classroom.getRoomNumber()) != null) {
				if (Alerts.showRepeatItem()) {
					classroomPane.clearAllFields();
				}
			} else {
				classroomBag.insert(classroom);
				if (Alerts.showItemInserted()) {
					classroomPane.clearAllFields();
				}
			}

		});

		classroomPane.getSearchBtn().setOnAction(e -> {
			String roomNumber;
			try {
				roomNumber = classroomPane.getBuildingName().charAt(0) + classroomPane.getRoomNumber();
			} catch (Exception e1) {
				roomNumber = "X" + classroomPane.getRoomNumber();
			}
			Classroom classroom = classroomBag.findByRoom(roomNumber);
			if (classroom != null) {
				if (Alerts.showItemFound()) {
					classroomPane.setNumberOfComputers(String.valueOf(classroom.getNumberOfComputers()));
					classroomPane.setNumberOfSeats(String.valueOf(classroom.getNumberOfSeats()));
					classroomPane.setProjectorOrNotField(String.valueOf(classroom.isProjectorOrNot()));
				}
			} else {
				if (Alerts.showItemNotFound()) {
					classroomPane.clearAllFields();
				}
			}
		});

		classroomPane.getUpdateBtn().setOnAction(e -> {
			String buildingName = classroomPane.getBuildingName();
			String roomNumber = classroomPane.getRoomNumber();
			int numberOfSeats = 0;
			int numberOfComputers = 0;
			if (!(classroomPane.getNumberOfSeats().equals(""))) {
				numberOfSeats = Integer.parseInt(classroomPane.getNumberOfSeats());
				numberOfComputers = Integer.parseInt(classroomPane.getNumberOfComputers());
			}
			boolean projectorOrNot = classroomPane.getProjectorOrNot();
			Classroom classroom = new Classroom(roomNumber, buildingName, numberOfSeats, numberOfComputers,
					projectorOrNot);

			Classroom temp;
			try {
				temp = classroomBag.findByRoom(buildingName.charAt(0) + roomNumber);
			} catch (Exception e1) {
				temp = classroomBag.findByRoom("X" + roomNumber);
			}
			if (temp != null) {
				classroomBag.deleteByRoom(temp.getRoomNumber());
				classroomBag.insert(classroom);
				if (Alerts.showItemUpdated()) {
					classroomPane.clearAllFields();
				}
			} else {
				if (Alerts.showItemNotUpdated()) {
					classroomPane.clearAllFields();
				}
			}
		});

		classroomPane.getDeleteBtn().setOnAction(e -> {
			String roomNumber;
			try {
				roomNumber = classroomPane.getBuildingName().charAt(0) + classroomPane.getRoomNumber();
			} catch (Exception e1) {
				roomNumber = "X" + classroomPane.getRoomNumber();
			}
			if (classroomBag.findByRoom(roomNumber) != null) {
				Classroom classroom = classroomBag.deleteByRoom(roomNumber);
				if (Alerts.showItemDeleted()) {
					classroomPane.setNumberOfComputers(String.valueOf(classroom.getNumberOfComputers()));
					classroomPane.setNumberOfSeats(String.valueOf(classroom.getNumberOfSeats()));
					classroomPane.setProjectorOrNotField(String.valueOf(classroom.isProjectorOrNot()));
				}
			} else {
				if (Alerts.showItemNotDeleted()) {
					classroomPane.clearAllFields();
				}
			}
		});
	}
}
