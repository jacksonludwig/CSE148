package model;

public class ClassroomBag {
	private Classroom[] array;
	private int nElems;
	
	public ClassroomBag(int maxSize) {
		array = new Classroom[maxSize];
		nElems = 0;
	}
	
	public void insert(Classroom classroom) {
		array[nElems++] = classroom;
	}

	public void display() {
		for(int i = 0; i < nElems; i++) {
			System.out.println(array[i]);
		}
		System.out.println();
	}
	
	public Classroom findByClassNum(String id) {
		for(int i = 0; i < nElems; i++) {
			if(array[i].getRoomNumber().equals(id)) {
				return array[i];
			}
		}
		return null;
	}
	
	public Classroom deleteById(String id) {
		Classroom temp;
		int i = -1;
		for(i = 0; i < nElems; i++) {
			if(array[i].getRoomNumber().equals(id)) {
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
