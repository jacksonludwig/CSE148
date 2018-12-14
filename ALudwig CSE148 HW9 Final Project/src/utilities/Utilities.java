package utilities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;
import java.util.Optional;
import java.util.Random;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import model.ClassroomBag;
import model.College;
import model.CourseBag;
import model.PersonBag;
import model.TextbookBag;

public class Utilities {
	public static String generateRandomLineFromFile(String filename) {
		RandomAccessFile randomFile = null;
		try {
			randomFile = new RandomAccessFile(filename, "r");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		long randomByteNumber;
		String randomWord = null;
		try {
			do {
				randomByteNumber = new Random()
						.nextInt((int) randomFile.length() - (readLastLine(filename).length() * 2));
				randomFile.seek(randomByteNumber);
				if (randomFile.readChar() == '\n') {
					randomFile.seek(randomByteNumber + 2);
				}
				randomFile.readLine();
				randomWord = randomFile.readLine();
			} while (randomByteNumber >= randomFile.length());
			randomFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return randomWord;
	}

	public static String readLastLine(String filename) {
		FileReader fr = null;
		try {
			fr = new FileReader(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader input = new BufferedReader(fr);
		String last = "";
		String currentLine = "";
		try {
			while ((currentLine = input.readLine()) != null) {
				last = currentLine;
			}
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return last;
	}

	public static void load(College college, String filename) {
		ObjectInputStream ois = null;
		try {
			FileInputStream fis = new FileInputStream(filename);
			ois = new ObjectInputStream(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			PersonBag personBag = (PersonBag) (ois.readObject());
			college.setPersonBag(personBag);

			ClassroomBag classroomBag = (ClassroomBag) (ois.readObject());
			college.setClassroomBag(classroomBag);

			TextbookBag textbookBag = (TextbookBag) (ois.readObject());
			college.setTextbookBag(textbookBag);

			CourseBag courseBag = (CourseBag) (ois.readObject());
			college.setCourseBag(courseBag);

			ois.close();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
}
