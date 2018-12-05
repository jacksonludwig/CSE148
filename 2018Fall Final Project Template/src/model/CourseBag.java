package model;

import java.io.Serializable;

public class CourseBag implements Serializable {
	private Course[] array;
	private int nElems;

	public CourseBag(int maxSize) {
		array = new Course[maxSize];
		nElems = 0;
	}

	public void insert(Course course) {
		array[nElems++] = course;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(array[i]);
		}
		System.out.println();
	}

	public Course findById(String id) {
		for (int i = 0; i < nElems; i++) {
			if (array[i].getCourseNumber().equals(id)) {
				return array[i];
			}
		}
		return null;
	}

	public Course removeById(String id) {
		int i = -1;
		for (i = 0; i < nElems; i++) {
			if (array[i].getCourseNumber().equals(id)) {
				break;
			}
		}
		if (i == nElems) {
			return null;
		} else {
			Course temp = array[i];
			for (int j = i; j < nElems - 1; j++) {
				array[j] = array[j + 1];
			}
			nElems--;
			return temp;
		}
	}
}
