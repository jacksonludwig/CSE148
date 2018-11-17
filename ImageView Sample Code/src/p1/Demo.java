package p1;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Demo extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws MalformedURLException {

		StackPane root = new StackPane();
		Scene scene = new Scene(root, 200, 200);

		File file = new File("peoplephotos/males/2.jpg");
		URL externalForm = file.toURI().toURL();
		Image image = new Image(externalForm.toString());
		ImageView imageView = new ImageView();
		imageView.setImage(image);
//		
		Rectangle2D viewportRect = new Rectangle2D(0, 0, 150, 150);
        imageView.setViewport(viewportRect);
        imageView.setRotate(15);

		root.getChildren().add(imageView);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
