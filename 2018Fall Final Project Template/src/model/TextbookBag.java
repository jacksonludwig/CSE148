package model;

import java.io.Serializable;

public class TextbookBag implements Serializable{
	private Textbook[] array;
	private int nElems;

	public TextbookBag(int maxSize) {
		array = new Textbook[maxSize];
		nElems = 0;
	}

	public void insert(Textbook textbook) {
		array[nElems++] = textbook;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(array[i]);
		}
		System.out.println();
	}

	public Textbook findById(String id) {
		for (int i = 0; i < nElems; i++) {
			if (array[i].getIsbn().equals(id)) {
				return array[i];
			}
		}
		return null;
	}

	public Textbook removeById(String id) {
		int i = -1;
		for (i = 0; i < nElems; i++) {
			if (array[i].getIsbn().equals(id)) {
				break;
			}
		}
		if (i == nElems) {
			return null;
		} else {
			Textbook temp = array[i];
			for (int j = i; j < nElems - 1; j++) {
				array[j] = array[j + 1];
			}
			nElems--;
			return temp;
		}
	}
}
