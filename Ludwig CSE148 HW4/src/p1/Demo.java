package p1;

public class Demo {
	public final static int NUMBER_OF_STUDENTS = 5;

	public static void main(String[] args) {
		Student[] fiveStudents = new Student[NUMBER_OF_STUDENTS];
		String[] fiveNames = generateFiveNames();
		String[] fiveIds = generateFiveIds();
		MidtermScore[] fiveMidterms = generateFiveMidtermScores();
		FinalScore[] fiveFinals = generateFiveFinalScores();

		for (int i = 0; i < fiveStudents.length; i++) {
			fiveStudents[i] = new Student(fiveNames[i], fiveIds[i], fiveMidterms[i], fiveFinals[i]);
		}

		System.out.println("Name:\tID:\tGrade:\t");
		
		for (int i = 0; i < fiveStudents.length; i++) {
			System.out.println(fiveStudents[i].getName() + "\t" + fiveStudents[i].getId() + "\t"
					+ fiveStudents[i].letterGrade(fiveStudents[i].getMidtermScore(), fiveStudents[i].getFinalScore()));
		}
	}

	public static String[] generateFiveNames() {
		String[] fiveNames = { "Jack", "Jane", "Hank", "Ed", "Sam" };
		return fiveNames;
	}

	public static String[] generateFiveIds() {
		String[] fiveIds = { "111", "222", "333", "444", "555" };
		return fiveIds;
	}

	public static MidtermScore[] generateFiveMidtermScores() {
		MidtermScore[] fiveMidterms = { new MidtermScore(50, 25), new MidtermScore(50, 50), new MidtermScore(30, 17),
				new MidtermScore(40, 35), new MidtermScore(35, 25) };
		return fiveMidterms;
	}

	public static FinalScore[] generateFiveFinalScores() {
		FinalScore[] fiveFinals = { new FinalScore(100, 100, 100, 100), new FinalScore(80, 60, 90, 40),
				new FinalScore(10, 76, 100, 70), new FinalScore(85, 80, 10, 90), new FinalScore(90, 80, 90, 85) };
		return fiveFinals;
	}
}
