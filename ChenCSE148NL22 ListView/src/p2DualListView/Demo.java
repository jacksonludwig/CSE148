package p2DualListView;

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

// BorderPane is recommended for project

public class Demo extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// root will hold gridpanes
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 400, 250);
		
		// this gridpane goes to center of borderpane
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(5));
		// amount of pixels between columns
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		
		// widths of the columns
		// format: min width, preferred width, max width
		ColumnConstraints column1 = new ColumnConstraints(150, 150, Double.MAX_VALUE);
		ColumnConstraints column2 = new ColumnConstraints(50); // always 50 pixels
		ColumnConstraints column3 = new ColumnConstraints(150, 150, Double.MAX_VALUE);
		
		column1.setHgrow(Priority.ALWAYS);
		column3.setHgrow(Priority.ALWAYS);
		
		// add all columns to gridpane
		gridPane.getColumnConstraints().addAll(column1, column2, column3);
		
		Label coursesToTakeLbl = new Label("Courses to Take");
		GridPane.setHalignment(coursesToTakeLbl, HPos.CENTER);
		// adds label to first column, first row (0,0)/(r,c)
		gridPane.add(coursesToTakeLbl, 0, 0);
		
		Label coursesTakingLbl = new Label("Courses Taking");
		GridPane.setHalignment(coursesTakingLbl, HPos.CENTER);
		// adds label to third column, first row
		gridPane.add(coursesTakingLbl, 2, 0);
		
		String[] courses = {"CSE110", "CSE118", "CSE148", "CSE218", "CSE222", "CSE248"};
		
		// asList function turns array into an arraylist, so it can be made an observablearraylist
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
		
		// vertical box for arrow buttons
		VBox vbox = new VBox(5);
		vbox.getChildren().addAll(sendRightButton, sendLeftButton);
		
		// put vbox on gridpane on 2nd row, 2nd column.
		gridPane.add(vbox, 1, 1);
		
		root.setCenter(gridPane);
		GridPane.setVgrow(root, Priority.ALWAYS);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	// this whole gridpane could be put within another to organize/allow for more functions.
}
