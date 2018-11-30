package model;

public class TextbookBag {
	private Textbook[] array;
	private int nElems;
	
	public TextbookBag(int maxSize) {
		array = new Textbook[maxSize];
		nElems = 0;
	}
	
	public void insert(Textbook tex) {
		array[nElems++] = tex;
	}

	public void display() {
		for(int i = 0; i < nElems; i++) {
			System.out.println(array[i]);
		}
		System.out.println();
	}
	
	public Textbook findByIsbn(String id) {
		for(int i = 0; i < nElems; i++) {
			if(array[i].getIsbn().equals(id)) {
				return array[i];
			}
		}
		return null;
	}
	
	public Textbook deleteById(String id) {
		Textbook temp;
		int i = -1;
		for(i = 0; i < nElems; i++) {
			if(array[i].getIsbn().equals(id)) {
				break;
			}
		}
		if(i == nElems) {
			return null;
		} else {
			temp = array[i];
			// the - 1 from nElems prevents outofbounds if nElems=MaxSize
			for(int j = i; j < nElems - 1; j++) {
				array[j] = array[j + 1];
			}
			nElems--;
		}
		return temp;
	}
}
