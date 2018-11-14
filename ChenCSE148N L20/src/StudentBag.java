import java.io.Serializable;

public class StudentBag implements Serializable{
	private Student[] array;
	private int nElms;
	
	public StudentBag(int maxSize) {
		array = new Student[maxSize];
		nElms = 0;
	}
	
	public void insert(Student s) {
		array[nElms++] = s;
	}
	
	public void display() {
		for(int i = 0; i < nElms; i++) {
			System.out.println(array[i]);
		}
		System.out.println();
	}
	
	public Student find(String id) {
		for(int i = 0; i < nElms; i++) {
			if(array[i].getId().equals(id)) {
				return array[i];
			}
		}
		return null;
	}
}
