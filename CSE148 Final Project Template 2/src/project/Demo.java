package project;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class Demo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("data/PersonBag.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Person[] personArray = (Person[]) (ois.readObject());
		System.out.println(Arrays.toString(personArray));
		System.out.println((int)(ois.readObject()));
		System.out.println();
		ois.close();
		fis = new FileInputStream("data/TextbookBag.dat");
		ois = new ObjectInputStream(fis);
		Textbook[] textbookArray = (Textbook[]) (ois.readObject());
		System.out.println(Arrays.toString(textbookArray));
		System.out.println((int)(ois.readObject()));
		System.out.println();
		ois.close();
	}

}
