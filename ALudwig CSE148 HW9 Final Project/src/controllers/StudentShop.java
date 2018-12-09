package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.Course;
import model.CourseBag;
import model.PersonBag;
import model.Student;
import utilities.Alerts;
import view.StudentPane;

public class StudentShop {
	private StudentPane studentPane;
	private MenuBarShop menuBarShop;
	private PersonBag studentBag;
	private CourseBag courseBag;
	private BorderPane root;
	private ObservableList<String> coursesToTakeList;
	private ObservableList<String> coursesTakingList;
	private ObservableList<String> coursesTakenList;

	public StudentShop(PersonBag studentBag, CourseBag courseBag, MenuBarShop menuBarShop, BorderPane root) {
		HashSet<String> coursesToTake = new HashSet<String>();
		HashSet<String> coursesTaking = new HashSet<String>();
		HashSet<String> coursesTaken = new HashSet<String>();
		for (int i = 0; i < courseBag.getnElems(); i++) {
			coursesToTake.add(courseBag.getCourse(i).getCourseTitleShort());
		}
		coursesToTakeList = FXCollections.observableArrayList(coursesToTake);
		coursesTakingList = FXCollections.observableArrayList(coursesTaking);
		coursesTakenList = FXCollections.observableArrayList(coursesTaken);
		FXCollections.sort(coursesToTakeList);
		studentPane = new StudentPane(coursesToTakeList, coursesTakingList, coursesTakenList);
		this.menuBarShop = menuBarShop;
		this.studentBag = studentBag;
		this.courseBag = courseBag;
		this.root = root;
		setCallbacks();
	}

	public Pane getStudentPane() {
		return studentPane.getStudentPane();
	}

	private void setCallbacks() {
		menuBarShop.getInsertStudentMenuItem().setOnAction(e -> {
			root.setCenter(studentPane.getStudentPane());
		});

		studentPane.getMoveClassRightButton().setOnAction(e -> {
			String potential = studentPane.getCoursesToTakeListView().getSelectionModel().getSelectedItem();
			if (potential != null) {
				studentPane.getCoursesToTakeListView().getSelectionModel().clearSelection();
				coursesToTakeList.remove(potential);
				coursesTakingList.add(potential);
			}
		});

		studentPane.getMoveClassLeftButton().setOnAction(e -> {
			String potential = studentPane.getCoursesTakingListView().getSelectionModel().getSelectedItem();
			if (potential != null) {
				studentPane.getCoursesTakingListView().getSelectionModel().clearSelection();
				coursesTakingList.remove(potential);
				coursesToTakeList.add(potential);
			}
		});

		// find way to store grades for insertion
		studentPane.getMoveClassFarRightButton().setOnAction(e -> {
			String potential = studentPane.getCoursesTakingListView().getSelectionModel().getSelectedItem();
			if (potential != null) {
				Course course = courseBag.findByCourseTitleShort(potential);
				if(Alerts.confirmClassGradeWeighted(course.getNumberOfCredits()) > 0) { 
					studentPane.getCoursesTakingListView().getSelectionModel().clearSelection();
					coursesTakingList.remove(potential);
					coursesTakenList.add(potential);
				}
			}
		});

		studentPane.getMoveClassFarLeftButton().setOnAction(e -> {
			String potential = studentPane.getCoursesTakenListView().getSelectionModel().getSelectedItem();
			if (potential != null) {
				studentPane.getCoursesTakenListView().getSelectionModel().clearSelection();
				coursesTakenList.remove(potential);
				coursesTakingList.add(potential);
			}
		});

		studentPane.getInsertBtn().setOnAction(e -> {
//			String first = studentPane.getFirst();
//			String last = studentPane.getLast();
//			String phoneNumber = studentPane.getPhoneNumber();
//			String major = studentPane.getMajor();
//			ArrayList<String> coursesToTake = new ArrayList<>();
//			for (int i = 0; i < coursesToTakeList.size(); i++) {
//				coursesToTake.add(coursesToTakeList.get(i));
//			}
//			ArrayList<String> coursesTaking = new ArrayList<>();
//			for (int i = 0; i < coursesTakingList.size(); i++) {
//				coursesTaking.add(coursesTakingList.get(i));
//			}
//			ArrayList<String> coursesTaken = new ArrayList<>();
//			for (int i = 0; i < coursesTakenList.size(); i++) {
//				coursesTaken.add(coursesTakenList.get(i));
//			}
//			double gpa;
//			Student student = new Student(first, last, phoneNumber, major, coursesToTake, coursesTaking, coursesTaken,
//					gpa);
//			if (studentBag.findById(student.getId()) != null) {
//				if (Alerts.showRepeatItem()) {
//					studentPane.clearAllFields();
//				}
//			} else {
//				studentBag.insert(student);
//				if (Alerts.showItemInserted()) {
//					studentPane.clearAllFields();
//				}
//			}

		});

		studentPane.getSearchBtn().setOnAction(e -> {
//			String title = studentPane.getTitle();
//			if (studentBag.findByTitle(title) != null) {
//				if (Alerts.showItemFound()) {
//					studentPane.clearAllFields();
//				}
//			} else {
//				if (Alerts.showItemNotFound()) {
//					studentPane.clearAllFields();
//				}
//			}
		});

		studentPane.getUpdateBtn().setOnAction(e -> {
//			String title = studentPane.getTitle();
//			String isbn = studentPane.getIsbn();
//			String authorFirst = studentPane.getAuthorFirst();
//			String authorLast = studentPane.getAuthorLast();
//			double price = studentPane.getPrice();
//			Student student = new Student(title, isbn, authorFirst, authorLast, price);
//
//			Student temp = studentBag.findByTitle(title);
//			if (temp != null) {
//				studentBag.deleteByTitle(temp.getTitle());
//				studentBag.insert(student);
//				if (Alerts.showItemUpdated()) {
//					studentPane.clearAllFields();
//				}
//			} else {
//				if (Alerts.showItemNotUpdated()) {
//					studentPane.clearAllFields();
//				}
//			}
		});

		studentPane.getDeleteBtn().setOnAction(e -> {
//			String title = studentPane.getTitle();
//			if (studentBag.findByTitle(title) != null) {
//				studentBag.deleteByTitle(title);
//				if (Alerts.showItemDeleted()) {
//					studentPane.clearAllFields();
//				}
//			} else {
//				if (Alerts.showItemNotDeleted()) {
//					studentPane.clearAllFields();
//				}
//			}
		});
	}
}
