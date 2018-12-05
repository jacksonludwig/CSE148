package view;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ChildWindow2 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Alert from Child Window 2.");
		alert.setHeaderText("Error Alert from Window 2");
		alert.setContentText("Ouch, something is wrong");
		alert.showAndWait();
	}

}
