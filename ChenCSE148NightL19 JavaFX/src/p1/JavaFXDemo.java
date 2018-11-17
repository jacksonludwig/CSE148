package p1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXDemo extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Label nameLbl = new Label("Name"); // node
		nameLbl.setPrefSize(40, 30);
		TextField nameField = new TextField(); // node
		nameField.setPromptText("Name");
		HBox box1 = new HBox(20);
		box1.getChildren().addAll(nameLbl, nameField);
		box1.setAlignment(Pos.CENTER);

		Label idLbl = new Label("ID"); // node
		idLbl.setPrefSize(40, 30);
		TextField idField = new TextField(); // node
		idField.setPromptText("ID");
		HBox box2 = new HBox(20);
		box2.getChildren().addAll(idLbl, idField);
		box2.setAlignment(Pos.CENTER);

		Button okBtn = new Button("OK");
//		okBtn.setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent event) {
//				String name = nameField.getText();
//				String id = idField.getText();
//				nameField.setText(id);
//				idField.setText(name);
//			}
//
//		});
		
		okBtn.setOnAction(e -> {
			String name = nameField.getText();
			String id = idField.getText();
			nameField.setText(id);
			idField.setText(name);
		});

		VBox box3 = new VBox(10);
		box3.setAlignment(Pos.CENTER);
		box3.getChildren().addAll(box1, box2, okBtn);

		// box1.getChildren().add(nameLbl);
		// box1.getChildren().add(nameField);

		Scene scene = new Scene(box3, 400, 400); // scene
		stage.setScene(scene); // add scene to the stage
		stage.show(); // show the stage
	}

}
