package p1TextFileGenerators;

import java.util.Arrays;

public class TextbookBag {
	private Textbook[] array;
	private int nElms;
	
	public TextbookBag(int maxSize) {
		array = new Textbook[maxSize];
		nElms = 0;
	}
	
	public void insert(Textbook textbook) {
		array[nElms++] = textbook; 
	}
	
	public void display() {
		for(int i = 0; i < nElms; i++) {
			System.out.println(array[i]);
		}
		System.out.println();
	}

	public Textbook[] getArray() {
		return array;
	}

	public void setArray(Textbook[] array) {
		this.array = array;
	}

	public int getnElms() {
		return nElms;
	}

	public void setnElms(int nElms) {
		this.nElms = nElms;
	}

	@Override
	public String toString() {
		return "TextbookBag [array=" + Arrays.toString(array) + ", nElms=" + nElms + "]";
	}
	
}
