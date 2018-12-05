package project;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class App extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		College college = new College();
		BorderPane root = new BorderPane();
		TopPane topPane = new TopPane(college);
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

		Scene scene = new Scene(root, 800, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent we) {
				college.save();
				Platform.exit();
			}
		});
		
	}

}
