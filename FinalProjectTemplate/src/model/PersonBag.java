package model;

public class PersonBag {
	private Person[] array;
	private int nElems;

	public PersonBag(int maxSize) {
		super();
		Person[] arr = new Person[maxSize];
		nElems = 0;
	}
	
	public void insert(Person person) {
		array[nElems++] = person;
	}

	public void display() {
		for(int i = 0; i < nElems; i++) {
			System.out.println(array[i]);
		}
		System.out.println();
	}
	
	public Person findById(String id) {
		for(int i = 0; i < nElems; i++) {
			if(array[i].getId().equals(id)) {
				return array[i];
			}
		}
		return null;
	}
	
	public Person deleteById(String id) {
		Person temp;
		int i = -1;
		for(i = 0; i < nElems; i++) {
			if(array[i].getId().equals(id)) {
				break;
			}
		}
		if(i == nElems) {
			return null;
		} else {
			temp = array[i];
			// the -1 prevents outofbounds if nElems=MaxSize
			for(int j = i; j < nElems - 1; j++) {
				array[j] = array[j + 1];
			}
			nElems--;
		}
		return temp;
	}
}


