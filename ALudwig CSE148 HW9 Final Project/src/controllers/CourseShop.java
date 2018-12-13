package controllers;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.Course;
import model.CourseBag;
import utilities.Alerts;
import view.CoursePane;

// Searches by course number (WITH LETTERS; e.g. CSE148).

public class CourseShop {
	private CoursePane coursePane;
	private MenuBarShop menuBarShop;
	private CourseBag courseBag;
	private BorderPane root;

	public CourseShop(CourseBag courseBag, MenuBarShop menuBarShop, BorderPane root) {
		coursePane = new CoursePane();
		this.menuBarShop = menuBarShop;
		this.courseBag = courseBag;
		this.root = root;
		setCallbacks();
	}

	public Pane getCoursePane() {
		return coursePane.getCoursePane();
	}

	private void setCallbacks() {
		menuBarShop.getInsertCourseMenuItem().setOnAction(e -> {
			root.setCenter(coursePane.getCoursePane());
		});

		coursePane.getInsertBtn().setOnAction(e -> {
			String shortTitle = coursePane.getCourseTitleShort();
			String longTitle = coursePane.getCourseTitleLong();
			String courseDesc = coursePane.getCourseDescription();
			String facId = coursePane.getFacultyID();
			String textISBN = coursePane.getTextbookISBN();
			String classroom = coursePane.getClassroom();
			double credits = coursePane.getCredits();
			Course course = new Course(shortTitle, longTitle, courseDesc, credits, facId, textISBN,
					coursePane.getBuildingName().charAt(0) + classroom);
			if (courseBag.findByCourseTitleShort(course.getCourseTitleShort()) != null) {
				if (Alerts.showRepeatItem()) {
					coursePane.clearAllFields();
				}
			} else {
				courseBag.insert(course);
				if (Alerts.showItemInserted()) {
					coursePane.clearAllFields();
				}
			}

		});

		coursePane.getSearchBtn().setOnAction(e -> {
			String title = coursePane.getCourseTitleShort();
			Course course = courseBag.findByCourseTitleShort(title);
			if (course != null) {
				if (Alerts.showItemFound()) {
					coursePane.setBuildingBox(String.valueOf(course.getClassroom().charAt(0)));
					coursePane.setClassroomField(course.getClassroom().substring(1));
					coursePane.setCourseDescriptionField(course.getCourseDescription());
					coursePane.setCourseTitleLongField(course.getCourseTitleLong());
					coursePane.setTextbookISBNField(course.getTextbookISBN());
					coursePane.setFacultyIDField(course.getFacultyID());
					coursePane.setNumberOfCredits(String.valueOf(course.getNumberOfCredits()));
				}
			} else {
				if (Alerts.showItemNotFound()) {
					coursePane.clearAllFields();
				}
			}
		});

		coursePane.getUpdateBtn().setOnAction(e -> {
			String shortTitle = coursePane.getCourseTitleShort();
			String longTitle = coursePane.getCourseTitleLong();
			String courseDesc = coursePane.getCourseDescription();
			String facId = coursePane.getFacultyID();
			String textISBN = coursePane.getTextbookISBN();
			String classroom = coursePane.getClassroom();
			double credits = coursePane.getCredits();
			Course course = new Course(shortTitle, longTitle, courseDesc, credits, facId, textISBN,
					coursePane.getBuildingName().charAt(0) + classroom);

			Course temp = courseBag.findByCourseTitleShort(shortTitle);
			if (temp != null) {
				courseBag.deleteByCourseTitleShort(temp.getCourseTitleShort());
				courseBag.insert(course);
				if (Alerts.showItemUpdated()) {
					coursePane.clearAllFields();
				}
			} else {
				if (Alerts.showItemNotUpdated()) {
					coursePane.clearAllFields();
				}
			}
		});

		coursePane.getDeleteBtn().setOnAction(e -> {
			String title = coursePane.getCourseTitleShort();
			if (courseBag.findByCourseTitleShort(title) != null) {
				Course course = courseBag.deleteByCourseTitleShort(title);
				if (Alerts.showItemDeleted()) {
					coursePane.setBuildingBox(String.valueOf(course.getClassroom().charAt(0)));
					coursePane.setClassroomField(course.getClassroom().substring(1));
					coursePane.setCourseDescriptionField(course.getCourseDescription());
					coursePane.setCourseTitleLongField(course.getCourseTitleLong());
					coursePane.setTextbookISBNField(course.getTextbookISBN());
					coursePane.setFacultyIDField(course.getFacultyID());
					coursePane.setNumberOfCredits(String.valueOf(course.getNumberOfCredits()));
				}
			} else {
				if (Alerts.showItemNotDeleted()) {
					coursePane.clearAllFields();
				}
			}
		});
	}
}
