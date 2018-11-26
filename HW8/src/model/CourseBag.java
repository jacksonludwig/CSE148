package model;

import java.util.Arrays;

public class CourseBag {
	private Course[] arr;
	private int nElems;

	public CourseBag(int maxSize) {
		arr = new Course[maxSize];
		nElems = 0;
	}

	public void insert() {
		Course c = new Course("outputData/CourseInventoryReformatted.txt");
		arr[nElems++] = c;
	}

	public void insert(Course c) {
		arr[nElems++] = c;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(arr[i]);
		}
	}

	public Course[] getArr() {
		return arr;
	}

	public int getnElems() {
		return nElems;
	}

	@Override
	public String toString() {
		return "CourseBag [arr=" + Arrays.toString(arr) + ", nElems=" + nElems + "]";
	}

}
