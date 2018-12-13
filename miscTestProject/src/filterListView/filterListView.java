package filterListView;

import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class filterListView extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) {

	    ObservableList<String> data = FXCollections.observableArrayList();
	    IntStream.range(0, 1000).mapToObj(Integer::toString).forEach(data::add);

	    FilteredList<String> filteredData = new FilteredList<>(data, s -> true);

	    TextField filterInput = new TextField();
	    filterInput.textProperty().addListener(obs->{
	        String filter = filterInput.getText(); 
	        if(filter == null || filter.length() == 0) {
	            filteredData.setPredicate(s -> true);
	        }
	        else {
	            filteredData.setPredicate(s -> s.contains(filter));
	        }
	    });


	    BorderPane content = new BorderPane(new ListView<>(filteredData));
	    content.setBottom(filterInput);

	    Scene scene = new Scene(content, 500, 500);
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
}
