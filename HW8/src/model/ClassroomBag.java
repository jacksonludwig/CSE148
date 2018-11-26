package model;

import java.util.Arrays;

public class ClassroomBag {
	private Classroom[] arr;
	private int nElems;

	public ClassroomBag(int maxSize) {
		arr = new Classroom[maxSize];
		nElems = 0;
	}

	public void insert() {
		Classroom c = new Classroom("outputData/Classroom.txt");
		arr[nElems++] = c;
	}

	public void insert(Classroom c) {
		arr[nElems++] = c;
	}

	public void insert(String room) {
		Classroom c = new Classroom(room, "outputData/Classroom.txt");
		arr[nElems++] = c;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(arr[i]);
		}
	}

	public Classroom[] getArr() {
		return arr;
	}

	public int getnElems() {
		return nElems;
	}

	@Override
	public String toString() {
		return "ClassroomBag [arr=" + Arrays.toString(arr) + ", nElems=" + nElems + "]";
	}

}
