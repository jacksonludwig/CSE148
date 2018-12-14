package p3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javafx.scene.layout.BorderPane;

public class StudentShop implements Serializable {
	private StudentPane studentPane;
	private StudentBag studentBag;
	private BorderPane root;

	public StudentShop(StudentPane studentPane, StudentBag studentBag, BorderPane root) {
		super();
		this.studentPane = studentPane;
		this.studentBag = studentBag;
		this.root = root;
		setCallbacks();
		root.setCenter(studentPane.getStudentPane());
	}

	public void setCallbacks() {
		studentPane.getInsertBtn().setOnAction(e -> {
			Student student;
			try {
				student = new Student(studentPane.getNameField().getText(),
						Double.parseDouble(studentPane.getGpaField().getText()));
			} catch (NumberFormatException e1) {
				student = new Student(studentPane.getNameField().getText(), 0.0);
			}
			studentBag.insert(student);
			System.out.println("Person added");
		});

		studentPane.getSaveBtn().setOnAction(e -> {
			try {
				FileOutputStream fos = new FileOutputStream("students.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(studentBag);
				System.out.println("file saved");
				oos.close();
			} catch (IOException e1) {
				System.out.println("No saved files yet");
			}
		});

		studentPane.getLoadBtn().setOnAction(e -> {
			try {
				FileInputStream fis = new FileInputStream("students.dat");
				ObjectInputStream ois = new ObjectInputStream(fis);
				studentBag = (StudentBag) ois.readObject();
				System.out.println("file loaded");
				ois.close();
			} catch (ClassNotFoundException | IOException e1) {
				System.out.println("No saved files yet");
			}
		});
	}

}
