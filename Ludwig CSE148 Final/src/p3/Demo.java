package p3;

import java.io.Serializable;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Demo extends Application implements Serializable{
	private BorderPane root;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		StudentBag studentBag = new StudentBag(2000);
		StudentPane studentPane = new StudentPane();
		root = new BorderPane();
		
		StudentShop studentShop = new StudentShop(studentPane, studentBag, root);
		
		Scene scene = new Scene(root, 400, 300);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
