package app;

import javafx.application.Application;
import javafx.stage.Stage;
import model.College;

public class Demo extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		College college = new College();
	}

}
