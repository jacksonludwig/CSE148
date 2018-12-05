package app;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import controllers.MenuBarShop;
import controllers.TextbookShop;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.College;

public class Demo extends Application {
	private ImageView welcomeImage;
	private BorderPane root;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// model
		College college = new College();

		// view
		root = new BorderPane();

		// Menubar shop
		MenuBarShop menuBarShop = new MenuBarShop(root);
		setWelcomeScreen();

		// textbook shop
		TextbookShop textbookShop = new TextbookShop(college.getTextbookBag(), menuBarShop, root);

		Scene scene = new Scene(root, 1200, 1000);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(e -> { // this can be used to save the files as well, or alerts, etc.
			System.out.println("Closed");
		});
	}

	public void setWelcomeScreen() {
		File file = new File("images/welcome.jpg");

		try {
			URL externalForm = file.toURI().toURL();
			Image image = new Image(externalForm.toString());
			welcomeImage = new ImageView();
			welcomeImage.setImage(image);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		root.setCenter(welcomeImage);

	}

}
