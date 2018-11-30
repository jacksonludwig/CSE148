package model;

public class CourseBag {
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

	public Course findByClassNum(String id) {
		for (int i = 0; i < nElems; i++) {
			if (array[i].getCourseNumber().equals(id)) {
				return array[i];
			}
		}
		return null;
	}

	public Course deleteById(String id) {
		Course temp;
		int i = -1;
		for (i = 0; i < nElems; i++) {
			if (array[i].getCourseNumber().equals(id)) {
				break;
			}
		}
		if (i == nElems) {
			return null;
		} else {
			temp = array[i];
			// the - 1 from nElems prevents outofbounds if nElems=MaxSize
			for (int j = i; j < nElems - 1; j++) {
				array[j] = array[j + 1];
			}
			nElems--;
		}
		return temp;
	}
}
