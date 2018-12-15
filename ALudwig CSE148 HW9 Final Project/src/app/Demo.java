package app;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import controllers.ClassroomShop;
import controllers.CourseShop;
import controllers.FacultyShop;
import controllers.MenuBarShop;
import controllers.StudentShop;
import controllers.TextbookShop;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.College;
import model.FileSaver;
import utilities.Alerts;

public class Demo extends Application {
	private ImageView welcomeImage;
	private BorderPane root;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		College college = new College();

		root = new BorderPane();

		MenuBarShop menuBarShop = new MenuBarShop(college, root);
		setWelcomeScreen();

		TextbookShop textbookShop = new TextbookShop(college.getTextbookBag(), menuBarShop, root);
		
		ClassroomShop classroomShop = new ClassroomShop(college.getClassroomBag(), menuBarShop, root);
		
		CourseShop courseShop = new CourseShop(college.getCourseBag(), menuBarShop, root);
		
		StudentShop studentShop = new StudentShop(college.getPersonBag(), college.getCourseBag(), menuBarShop, root);
		
		FacultyShop facultyShop = new FacultyShop(college.getPersonBag(), college.getCourseBag(), menuBarShop, root);

		Scene scene = new Scene(root, 1080, 580);
		primaryStage.setScene(scene);
		primaryStage.show();
		Alerts.showAllLoaded();
		
		primaryStage.setOnCloseRequest(e -> {
			if (Alerts.closeCheck()) {
				final FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Save Binary File");
				File initialDir = new File("savedFiles");
				fileChooser.setInitialDirectory(initialDir);
				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Binary Files (*.dat)", "*.dat");
				fileChooser.getExtensionFilters().add(extFilter);
				File file = fileChooser.showSaveDialog(null);
				if (file != null) {
					FileSaver.saveAllBags(college.getPersonBag(), college.getClassroomBag(), college.getTextbookBag(),
							college.getCourseBag(), file.getAbsolutePath());
					Alerts.showNewSaved();
				}
			}
		});
	}

	public void setWelcomeScreen() {
		File file = new File("images/welcome.jpg");

		try {
			URL externalForm = file.toURI().toURL();
			Image image = new Image(externalForm.toString());
			welcomeImage = new ImageView();
			welcomeImage.setImage(image);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		root.setCenter(welcomeImage);

	}

}
