package p1;

public class Student {
	private String name;
	private String id;
	private MidtermScore midtermScore;
	private FinalScore finalScore;

	private final static double MIDTERM_WEIGHT = .4;
	private final static double FINAL_WEIGHT = .6;

	public Student(String name, String id, MidtermScore midtermScore, FinalScore finalScore) {
		super();
		this.name = name;
		this.id = id;
		this.midtermScore = midtermScore;
		this.finalScore = finalScore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public MidtermScore getMidtermScore() {
		return midtermScore;
	}

	public void setMidtermScore(MidtermScore midtermScore) {
		this.midtermScore = midtermScore;
	}

	public FinalScore getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(FinalScore finalScore) {
		this.finalScore = finalScore;
	}

	public static double getMidtermWeight() {
		return MIDTERM_WEIGHT;
	}

	public static double getFinalWeight() {
		return FINAL_WEIGHT;
	}

	public char letterGrade(MidtermScore midtermTest, FinalScore finalTest) {
		double semesterScore = (midtermTest.combinedScore() * MIDTERM_WEIGHT)
				+ (finalTest.combinedScore() * FINAL_WEIGHT);
		
		if(semesterScore >= 90)
			return 'A';
		else if(semesterScore < 90 && semesterScore >= 80)
			return 'B';
		else if(semesterScore < 80 && semesterScore >= 70)
			return 'C';
		else if(semesterScore < 70 && semesterScore >= 60)
			return 'D';
		
		return 'F';
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", midtermScore=" + midtermScore + ", finalScore=" + finalScore
				+ "]";
	}

}
