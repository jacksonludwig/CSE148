package p1MonoListView;

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
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NYColleges extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Label response = new Label("Select a college or University: ");
		ListView<String> lvColleges;
		Text title = new Text("NY Colleges and Universities");
		title.setFill(Paint.valueOf("#2A5058"));
		title.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		
		FlowPane root = new FlowPane(10, 10);
		root.setAlignment(Pos.CENTER);
		
		ObservableList<String> colleges = FXCollections.observableArrayList("Stony Brook", "NYU",
							"Nassau CCC",  "Columbia", "Binghamton", "Buffalo", "St. Joe");
		lvColleges = new ListView<String>(colleges);
		lvColleges.setPrefSize(300, 150);
		
		MultipleSelectionModel<String> lvSelModel = lvColleges.getSelectionModel();
		lvSelModel.setSelectionMode(SelectionMode.MULTIPLE);
		lvSelModel.selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				response.setText("You selected " + newValue);
				System.out.println(newValue  + " is selected");
			}
			
		});
		
		
		root.getChildren().add(title);
		root.getChildren().add(lvColleges);
		root.getChildren().add(response);
		
		Scene scene = new Scene(root, 350, 300);
		
		primaryStage.setTitle("List View");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
