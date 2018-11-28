package comboBox;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ComboBoxDemo extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ObservableList<String> list = FXCollections.observableArrayList("A", "B+", "B", "C+", "C", "D+", "D", "F");
		ComboBox<String> box = new ComboBox<>();
		box.setItems(list);

//		box.setOnAction( e -> {
//			String item = (String) box.getValue();
//			System.out.println(item + " is selected.");
//		});
		
		box.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println(oldValue);
				System.out.println(newValue);
			}

		});

		HBox root = new HBox();
		root.setAlignment(Pos.CENTER);
		root.getChildren().add(box);
		primaryStage.setScene(new Scene(root, 300, 200));
		primaryStage.show();

	}

}

// can be used for area code in phone number, majors, grades, etc. ListView should be used if there are a very large amount of options.