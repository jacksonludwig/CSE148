package project;

import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class App2 {

	private College college = new College();
	private BorderPane root = new BorderPane();
	private TopPane topPane = new TopPane(college);

	public App2() {
		root.setTop(topPane.getMenuBar());

		MenuItem studentMenuItem = topPane.getStudentMenuItem();
		studentMenuItem.setOnAction(e -> {
			StudentPane centerPane = new StudentPane(college);
			root.setCenter(centerPane.getGridPane());
		});

		MenuItem facultyMenuItem = topPane.getFacultyMenuItem();
		facultyMenuItem.setOnAction(e -> {
			FacultyPane centerPane = new FacultyPane(college);
			root.setCenter(centerPane.getGridPane());
		});

		MenuItem classroomMenuItem = topPane.getClassroomMenuItem();
		classroomMenuItem.setOnAction(e -> {
			StudentPane centerPane = new StudentPane(college);
			root.setCenter(centerPane.getGridPane());
		});

		MenuItem courseMenuItem = topPane.getCourseMenuItem();
		courseMenuItem.setOnAction(e -> {
			CoursePane centerPane = new CoursePane(college);
			root.setCenter(centerPane.getGridPane());
		});

		MenuItem textbookMenuItem = topPane.getTextbookMenuItem();
		textbookMenuItem.setOnAction(e -> {
			TextbookPane centerPane = new TextbookPane(college);
			root.setCenter(centerPane.getGridPane());
		});

	}

}
