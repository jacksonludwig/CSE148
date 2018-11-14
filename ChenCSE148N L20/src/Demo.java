import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Demo implements Serializable {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		StudentBag bag = new StudentBag(20);
		File file = new File("students.txt");
		Scanner input = new Scanner(file);
		while (input.hasNextLine()) {
			String string = input.nextLine();
			String[] tokens = string.split(", "); // reg expression to split
			Student s = new Student(tokens[0], tokens[1], tokens[2]);
			bag.insert(s);
		}
		input.close();
		bag.display();
		System.out.println(bag.find("2"));

		FileOutputStream fos = new FileOutputStream("students.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(bag);
		oos.close();
		System.out.println("saved backup to students.dat");
		// the above can be read with FileinputStream and ObjectinputStream in the same
		// fashion:
		FileInputStream fis = new FileInputStream("students.bat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		StudentBag retrievedBag = (StudentBag)(ois.readObject());
		ois.close();
		retrievedBag.display();
	}
}
