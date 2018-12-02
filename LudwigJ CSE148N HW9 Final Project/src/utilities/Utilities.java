package utilities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;
import java.util.Random;

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
		Random rand = new Random();
		int randomValue;
		long randomByteNumber;
		String randomWord = null;
		try {
			do {
				randomValue = rand.nextInt((int) randomFile.length() - (readLastLine(filename).length() * 2));
				randomByteNumber = randomValue;
				randomFile.seek(randomByteNumber);
				if (randomFile.readChar() == '\n') {
					randomFile.seek(randomByteNumber + 2);
				}
				randomFile.readLine();
				randomWord = randomFile.readLine();
			} while (randomByteNumber >= randomFile.length() || randomWord.equals("null"));
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
	
	public static void load(College college) {
		FileInputStream fis = null;
		PersonBag personBag = college.getPersonBag();
		ClassroomBag classroomBag = college.getClassroomBag();
		TextbookBag textbookBag = college.getTextbookBag();
		CourseBag courseBag = college.getCourseBag();
		try {
			fis = new FileInputStream("binaryData/allBags.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			personBag = (PersonBag) ois.readObject();
			classroomBag = (ClassroomBag) ois.readObject();
			textbookBag = (TextbookBag) ois.readObject();
			courseBag = (CourseBag) ois.readObject();
			ois.close();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
}
