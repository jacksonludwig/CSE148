package model;

import java.io.Serializable;
import java.util.Arrays;

public class ClassroomBag implements Serializable{
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

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(arr[i]);
		}
	}

	public Classroom findByRoom(String room) {
		for (int i = 0; i < nElems; i++) {
			if (arr[i].getRoomNumber().equals(room)) {
				return arr[i];
			}
		}
		return null;
	}

	public Classroom deleteByRoom(String id) {
		Classroom temp;
		int i = -1;
		for (i = 0; i < nElems; i++) {
			if (arr[i].getRoomNumber().equals(id)) {
				break;
			}
		}
		if (i == nElems) {
			return null;
		} else {
			temp = arr[i];
			for (int j = i; j < nElems - 1; j++) {
				arr[j] = arr[j + 1];
			}
			nElems--;
		}
		return temp;
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
