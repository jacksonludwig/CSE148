package p1TextFileGenerators;

public class CourseBag {
	private Course[] array;
	private int nElms;
	
	public CourseBag(int maxSize) {
		array = new Course[maxSize];
		nElms = 0;
	}
	
	public void insert(Course course) {
		array[nElms++] = course; 
	}
	
	public void display() {
		for(int i = 0; i < nElms; i++) {
			System.out.println(array[i]);
		}
		System.out.println();
	}
	
}
