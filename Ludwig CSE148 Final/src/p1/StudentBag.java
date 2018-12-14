package p1;


public class StudentBag {
	private Student[] array;
	private int nElems;

	public StudentBag(int maxSize) {
		this.array = new Student[maxSize];
		this.nElems = 0;
	}

	public void insert(Student student) {
		array[nElems++] = student;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(array[i]);
		}
		System.out.println();
	}

	public Student findById(String id) {
		for (int i = 0; i < nElems; i++) {
			if (array[i].getId().equals(id)) {
				return array[i];
			}
		}
		return null;
	}

	public Student removeById(String id) {
		int i = -1;
		for (i = 0; i < nElems; i++) {
			if (array[i].getId().equals(id)) {
				break;
			}
		}
		if (i == nElems) {
			return null;
		} else {
			Student temp = array[i];
			for (int j = i; j < nElems - 1; j++) {
				array[j] = array[j + 1];
			}
			nElems--;
			return temp;
		}
	}

}
