package p1;

import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class ErrorAlertApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	// could put methods in a utility file that take in info to return accurate alerts/errors/etc.
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Error!");
		alert.setContentText("Oooops, there is an error!");
		alert.showAndWait();

		Alert alert2 = new Alert(AlertType.WARNING);
		alert2.setTitle("Warning Dialog");
		alert2.setHeaderText("Warning!");
		alert2.setContentText("Hey, Be careful!");
		alert2.showAndWait();

		Alert alert3 = new Alert(AlertType.INFORMATION);
		alert3.setTitle("Info Dialog");
		alert3.setHeaderText("Information!");
		alert3.setContentText("Student successfully added");
		alert3.showAndWait();

		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Text Input Dialog");
		dialog.setHeaderText("Look, a text input dialog");
		dialog.setContentText("Please enter your name!");
		Optional<String> result = dialog.showAndWait();

		if (result.isPresent()) {
			System.out.println("You entered: " + result.get());
			// Person p = personBag.searchById(result.get());
			// firstNameField.setText(p.getFirstName());
		}

	}

}
