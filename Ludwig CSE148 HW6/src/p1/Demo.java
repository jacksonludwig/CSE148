package p1;

public class Demo {

	public static void main(String[] args) {
		int[] values = {90, 20, 50, 30, 10, 65, 80, 75, 
				20, 95, 100, 50, 40, 19, 90, 95, 80, 85, 60};
		int[] invalidValues = {90, 20, 50, 30, 10, 65, 80, 75, 
				20, 95, 101, 50, 40, 19, 90, 95, 80, 85, 60};
		
		TestScores t1 = new TestScores(values);
		TestScores t2 = new TestScores(invalidValues);
		

	}

}
