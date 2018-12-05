package view;

import java.util.Optional;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainWindow extends Application {
	private int x;
	private Optional<String> result = null;

	@Override
	public void start(Stage stage) throws Exception {

		Button showDialogBtn = new Button("Show Dialog");

		StackPane root = new StackPane();

		root.getChildren().add(showDialogBtn);

		Scene scene = new Scene(root, 300, 200);

		showDialogBtn.setOnAction(ev -> {

			TextInputDialog tid = new TextInputDialog();
			tid.setTitle("Text Input Dialog Window");
			tid.setHeaderText("Enter a choice");
			tid.setContentText("Please enter a number (1 or 2): ");
			result = tid.showAndWait();

			result.ifPresent(response -> {
				if (response.equals("1")) {
					ChildWindow1 cw1 = new ChildWindow1();
					x = 1;
					try {
						cw1.start(stage);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if (response.equals("2")) {
					ChildWindow2 cw2 = new ChildWindow2();
					x = 2;
					try {
						cw2.start(stage);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				result.ifPresent(answer -> System.out.println(answer + " from the showData method."));
				showData();
				System.out.println(x);

			});

		});

		System.out.println(x);
		stage.setScene(scene);
		stage.show();
	}

	public void showData() {
		result.ifPresent(answer -> System.out.println(answer + " from the showData method."));
	}
}
