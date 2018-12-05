package project;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class PersonBag implements Serializable{
	private Person[] personArray;
	private int nElems;

	public PersonBag(int maxSize) {
		personArray = new Person[maxSize];
		nElems = 0;
	}

	public void insert(Person person) {
		personArray[nElems++] = person;
	}

	public void save() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("data/PersonBag.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(personArray);
			oos.writeObject(nElems);
			oos.close();
		}  catch (IOException e) {
			Util.failureAlert("Failure saving PersonBag.dat file");
		}

	}
	
	public void load() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("data/PersonBag.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			personArray = (Person[])(ois.readObject());
			nElems = (int) (ois.readObject());
			ois.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			Util.failureAlert("Failure loading PersonBag.dat file");
		} catch (ClassNotFoundException e) {
		}
	}
	
	public Person[] getPersonArray() {
		return Arrays.copyOf(personArray, nElems);
	}

	@Override
	public String toString() {
		return "PersonBag [personArray=" + Arrays.toString(personArray) + ", nElems=" + nElems + "]";
	}
	
	
}
