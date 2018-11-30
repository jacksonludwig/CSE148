package p1TextFileGenerators;

import java.util.Arrays;

public class ClassroomBag {
	private Classroom[] array;
	private int nElms;
	
	public ClassroomBag(int maxSize) {
		array = new Classroom[maxSize];
		nElms = 0;
	}
	
	public void insert(Classroom classroom) {
		array[nElms++] = classroom; 
	}
	
	public void display() {
		for(int i = 0; i < nElms; i++) {
			System.out.println(array[i]);
		}
		System.out.println();
	}

	public Classroom[] getArray() {
		return array;
	}

	public void setArray(Classroom[] array) {
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
		return "ClassroomBag [array=" + Arrays.toString(array) + ", nElms=" + nElms + "]";
	}
	
}
