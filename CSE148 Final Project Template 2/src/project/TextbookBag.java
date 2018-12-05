package project;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TextbookBag implements Serializable {
	private Textbook[] textbookArray;
	private int nElems;

	public TextbookBag(int maxSize) {
		textbookArray = new Textbook[maxSize];
		nElems = 0;
	}

	public void insert(Textbook textbook) {
		textbookArray[nElems++] = textbook;
	}

	public Textbook findByISBN(String isbn) {
		for (int i = 0; i < nElems; i++) {
			if (textbookArray[i].getIsbn().equals(isbn)) {
				return textbookArray[i];
			}
		}
		return null;
	}

	public Textbook removeByISBN(String isbn) {
		int i = -1;
		for (i = 0; i < nElems; i++) {
			if (textbookArray[i].getIsbn().equals(isbn)) {
				break;
			}
		}
		if (i == nElems) {
			return null;
		} else {
			Textbook temp = textbookArray[i];
			for (int j = i; j < nElems - 1; j++) {
				textbookArray[j] = textbookArray[j + 1];
			}
			nElems--;
			return temp;
		}
	}

	public void save() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("data/TextbookBag.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(textbookArray);
			oos.writeObject(nElems);
			oos.close();
		} catch (IOException e) {
			Util.failureAlert("Failure saving file.");
		}

	}

	public void load() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("data/TextbookBag.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			textbookArray = (Textbook[]) (ois.readObject());
			nElems = (int) (ois.readObject());
			ois.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			Util.failureAlert("Failure loading file");
		} catch (ClassNotFoundException e) {
		}

	}
}
