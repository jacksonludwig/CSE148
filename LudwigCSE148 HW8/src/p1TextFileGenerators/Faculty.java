package p1TextFileGenerators;

import java.io.IOException;
import java.util.Random;

public class Faculty extends Person {
	private String phoneDepartment;
	private String salary;
	private String coursesTeaching;

	private static final double MIN_SALARY = 10000.00;
	private static final double MAX_SALARY = 100000.00;
	private static final int MAX_CLASSES = 6;

	public Faculty() throws IOException {
		super();
		phoneDepartment = Utilities.generateMajor();
		salary = Utilities.generateDoubleInRange(MIN_SALARY, MAX_SALARY);
		coursesTeaching = "";

		Random rand = new Random();
		int randomValue = rand.nextInt(MAX_CLASSES);
		for (int i = 0; i < randomValue; i++) {
			if (i == randomValue - 1) {
				coursesTeaching += Utilities.getCourses();
			} else {
				coursesTeaching += Utilities.getCourses() + ",";
			}
		}

	}

	@Override
	public String toString() {
		return super.toString() + phoneDepartment + " " + salary + " " + coursesTeaching;
	}

}
