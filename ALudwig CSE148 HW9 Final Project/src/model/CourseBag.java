package model;

import java.io.Serializable;
import java.util.Arrays;

public class CourseBag implements Serializable{
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

	public Course findByCourseTitleShort(String id) {
		for(int i = 0; i < nElems; i++) {
			if(arr[i].getCourseTitleShort().equals(id)) {
				return arr[i];
			}
		}
		return null;
	}
	
	public Course deleteByCourseTitleShort(String id) {
		Course temp;
		int i = -1;
		for(i = 0; i < nElems; i++) {
			if(arr[i].getCourseTitleShort().equals(id)) {
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
	
	public Course getCourse(int num) {
		return arr[num];
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
