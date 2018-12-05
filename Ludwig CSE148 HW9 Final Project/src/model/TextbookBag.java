package model;

import java.io.Serializable;
import java.util.Arrays;

public class TextbookBag implements Serializable{
	private Textbook[] arr;
	private int nElems;

	public TextbookBag(int maxSize) {
		arr = new Textbook[maxSize];
		nElems = 0;
	}

	public void insert() {
		Textbook t = new Textbook("outputData/Textbooks.txt");
		arr[nElems++] = t;
	}

	public void insert(Textbook t) {
		arr[nElems++] = t;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public Textbook findByTitle(String id) {
		for(int i = 0; i < nElems; i++) {
			if(arr[i].getTitle().equals(id)) {
				return arr[i];
			}
		}
		return null;
	}
	
	public Textbook deleteByTitle(String id) {
		Textbook temp;
		int i = -1;
		for(i = 0; i < nElems; i++) {
			if(arr[i].getTitle().equals(id)) {
				break;
			}
		}
		if(i == nElems) {
			return null;
		} else {
			temp = arr[i];
			for(int j = i; j < nElems - 1; j++) {
				arr[j] = arr[j + 1];
			}
			nElems--;
		}
		return temp;
	}

	public Textbook[] getArr() {
		return arr;
	}

	public int getnElems() {
		return nElems;
	}

	@Override
	public String toString() {
		return "TextbookBag [arr=" + Arrays.toString(arr) + ", nElems=" + nElems + "]";
	}

}
