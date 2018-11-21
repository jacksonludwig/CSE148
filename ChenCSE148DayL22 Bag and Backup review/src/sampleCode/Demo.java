package sampleCode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Demo extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		StudentBag theBag = new StudentBag(100);
		VBox box = new VBox(20);
		box.setAlignment(Pos.CENTER);
		box.setPadding(new Insets(30));
		TextField nameField = new TextField();
		nameField.setPromptText("name");
		Button addBtn = new Button("INSERT");
		Button saveBtn = new Button("SAVE");
		Button loadBtn = new Button("Load");

		// addBtn.setOnAction(new EventHandler<ActionEvent> () {
		//
		// @Override
		// public void handle(ActionEvent event) {
		// theBag.insert(nameField.getText());
		// nameField.clear();
		// }
		//
		// });

		addBtn.setOnAction(e -> {
			theBag.insert(nameField.getText());
			nameField.clear();
		});

		box.getChildren().addAll(nameField, addBtn, saveBtn, loadBtn);
		Scene scene = new Scene(box, 200, 200);
		primaryStage.setScene(scene);
		primaryStage.show();

		saveBtn.setOnAction(e -> {
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream("backupBag.dat");
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			ObjectOutputStream oos = null;
			try {
				oos = new ObjectOutputStream(fos);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				oos.writeObject(theBag);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				oos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("The Bag is saved as \"backupBag.dat\"");
		});
		
		loadBtn.setOnAction(e -> {
			
				FileInputStream fis = null;
				try {
					fis = new FileInputStream("backupBag.dat");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				ObjectInputStream ois = null;
				try {
					ois = new ObjectInputStream(fis);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					StudentBag theBag2 = (StudentBag)(ois.readObject());
					nameField.setText(theBag2.getArr()[0].getName());
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
		});

	}

}
