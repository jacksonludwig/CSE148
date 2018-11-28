package p2DualListViews;

import java.util.Arrays;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DualListViews extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 400, 250);
		
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(5));
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		
		ColumnConstraints column1 = new ColumnConstraints(150, 150, Double.MAX_VALUE);
		ColumnConstraints column2 = new ColumnConstraints(50);
		ColumnConstraints column3 = new ColumnConstraints(150, 150, Double.MAX_VALUE);
		
		column1.setHgrow(Priority.ALWAYS);
		column3.setHgrow(Priority.ALWAYS);
		
		gridPane.getColumnConstraints().addAll(column1, column2, column3);
		
		Label coursesToTakeLbl = new Label("Courses to Take");
		GridPane.setHalignment(coursesToTakeLbl, HPos.CENTER);
		gridPane.add(coursesToTakeLbl, 0, 0);
		
		Label coursesTakingLbl = new Label("Courses Taking");
		GridPane.setHalignment(coursesTakingLbl, HPos.CENTER);
		gridPane.add(coursesTakingLbl, 2, 0);
		
		String[] courses = {"CSE110", "CSE118", "CSE148", "CSE218", "CSE222", "CSE248"};
		
		ObservableList<String> coursesToTakeList = FXCollections.observableArrayList(Arrays.asList(courses));
		ListView<String> coursesToTakeListView = new ListView<>(coursesToTakeList);
		gridPane.add(coursesToTakeListView, 0, 1);
		
		ObservableList<String> coursesTakingList = FXCollections.observableArrayList(Arrays.asList());
		ListView<String> coursesTakingListView = new ListView<>(coursesTakingList);
		gridPane.add(coursesTakingListView, 2, 1);
		
		Button sendRightButton = new Button("->");
		Button sendLeftButton = new Button("<-");
		
		sendRightButton.setOnAction(e -> {
			String potential = coursesToTakeListView.getSelectionModel().getSelectedItem();
			if(potential != null) {
				coursesToTakeListView.getSelectionModel().clearSelection();
				coursesToTakeList.remove(potential);
				coursesTakingList.add(potential);
			}
		});
		
		sendLeftButton.setOnAction(e -> {
			String potential = coursesTakingListView.getSelectionModel().getSelectedItem();
			if(potential != null) {
				coursesTakingListView.getSelectionModel().clearSelection();
				coursesTakingList.remove(potential);
				coursesToTakeList.add(potential);
			}
		});
		
		VBox vbox = new VBox(5);
		vbox.getChildren().addAll(sendRightButton, sendLeftButton);
		
		gridPane.add(vbox, 1, 1);
		
		root.setCenter(gridPane);
		GridPane.setVgrow(root, Priority.ALWAYS);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
