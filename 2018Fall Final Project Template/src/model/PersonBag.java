package model;

import java.io.Serializable;

public class PersonBag implements Serializable{
	private Person[] array;
	private int nElems;

	public PersonBag(int maxSize) {
		super();
		this.array = new Person[maxSize];
		this.nElems = 0;
	}
	
	public void insert(Person person) {
		array[nElems++] = person;
	}
	
	public void display() {
		for(int i = 0; i< nElems; i++) {
			System.out.println(array[i]);
		}
		System.out.println();
	}
	
	public Person findById(String id) {
		for(int i =0; i < nElems; i++) {
			if(array[i].getId().equals(id)) {
				return array[i];
			}
		}
		return null;
	}
	
	public Person removeById(String id) {
		int i = -1;
		for (i = 0; i < nElems; i++) {
			if(array[i].getId().equals(id)) {
				break;
			}
		}
		if(i == nElems) {
			return null;
		} else {
			Person temp = array[i];
			for(int j = i; j< nElems-1; j++) {
				array[j] = array[j+1];
			}
			nElems--;
			return temp;
		}
	}

}
