package file_utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class StringBag {
	public String[] strs;
	private int nElems;

	public StringBag(String fileName) {
		strs = new String[countLines(fileName)];
		nElems = 0;
		loadBag(fileName);
	}
	
	public StringBag(int maxSize) {
		strs = new String[maxSize];
		nElems = 0;
	}
	
	public int getNElems() {
		return nElems;
	}

	private Scanner openFile(String fileName) {
		File file = new File(fileName);
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return scanner;
	}

	public void insert(String name) {
		strs[nElems++] = name;
	}

	private void loadBag(String fileName) {
		Scanner scanner = openFile(fileName);
		while (scanner.hasNextLine()) {
			insert(scanner.nextLine());
		}
		scanner.close();
	}

	public String emitString() {
		return strs[(new Random()).nextInt(nElems)];
	}

	private int countLines(String fileName) {
		Scanner scanner = openFile(fileName);
		int lineCounter = 0;
		while (scanner.hasNextLine()) {
			scanner.nextLine();
			lineCounter++;
		}

		scanner.close();
		return lineCounter;
	}
}
