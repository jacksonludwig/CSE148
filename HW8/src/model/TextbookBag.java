package model;

import java.util.Arrays;

public class TextbookBag {
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
