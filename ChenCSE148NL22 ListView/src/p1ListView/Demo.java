package p1ListView;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Demo extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Label response = new Label("Select a college or university");
		ListView<String> lvColleges;
		Text title = new Text("NY Colleges and Universities");
		FlowPane root = new FlowPane(30, 30);
		root.setAlignment(Pos.CENTER);
		ObservableList<String> colleges = FXCollections.observableArrayList("SCCC", "NCCC", "Stony Brook", "NYU",
				"Columbia", "Binghamton");
		lvColleges = new ListView<String>(colleges);
		lvColleges.setPrefSize(200, 150);

		MultipleSelectionModel<String> lvSelectModel = lvColleges.getSelectionModel();
		lvSelectModel.setSelectionMode(SelectionMode.MULTIPLE);

		lvSelectModel.selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				response.setText(newValue);
			}

		});

		root.getChildren().addAll(title, lvColleges, response);
		Scene scene = new Scene(root, 250, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ListView");
		primaryStage.show();

	}
}
