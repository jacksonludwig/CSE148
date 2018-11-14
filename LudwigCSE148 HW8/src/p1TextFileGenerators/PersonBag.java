package p1TextFileGenerators;

import java.util.Arrays;

public class PersonBag {
	private Person[] arr;
	private int nElms; // counter -- How many items are currently in the bag (NOT SIZE OF THE ARRAY)

	public PersonBag(int maxSize) {
		arr = new Person[maxSize];
		nElms = 0;
	}

	// user will not have to worry about indices because it is dealt with HERE (hence abstraction).
	public void insert(Person person) {
		arr[nElms++] = person; 
	}
	
	public Person deletePersonById(String id) {
		int i = -1;
		for(i = 0; i < nElms; i++) {
			if(arr[i].getId().equals(id)) {
				break;
			}
		}
		if(i == nElms) {
			return null;
		}
		else {
			Person temp = arr[i]; // person to be deleted
			for(int j = i; j < nElms; j++) { // shifts array
				arr[j] = arr[j + 1];
			}
			nElms--;
			
			return temp;
		}
			
	}

	public Person findPersonById(String id) {
		for(int i = 0; i < nElms; i++) {
			if(arr[i].getId().equals(id)) 
				return arr[i];
		}
		return null;
	}
	
	public void display() {
		for(int i = 0; i < nElms; i++) {
			System.out.println(arr[i]);
		}
		System.out.println();
	}

	public Person[] getArr() {
		return arr;
	}

	public void setArr(Person[] arr) {
		this.arr = arr;
	}

	public int getNElms() {
		return nElms;
	}

	public void setNElms(int nElms) {
		this.nElms = nElms;
	}

	@Override
	public String toString() {
		return "PersonBag [arr=" + Arrays.toString(arr) + ", nElms=" + nElms + "]";
	}
	
	
}
