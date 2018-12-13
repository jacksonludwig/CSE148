package p3;

public class MidtermScore {
	private int numberOfQuestionsTotal;
	private int numberOfQuestionsCorrect;

	public MidtermScore(int numberOfQuestionsTotal, int numberOfQuestionsCorrect) {
		super();
		this.numberOfQuestionsTotal = numberOfQuestionsTotal;
		this.numberOfQuestionsCorrect = numberOfQuestionsCorrect;
	}

	public int getNumberOfQuestionsTotal() {
		return numberOfQuestionsTotal;
	}

	public void setNumberOfQuestionsTotal(int numberOfQuestionsTotal) {
		this.numberOfQuestionsTotal = numberOfQuestionsTotal;
	}

	public int getNumberOfQuestionsCorrect() {
		return numberOfQuestionsCorrect;
	}

	public void setNumberOfQuestionsCorrect(int numberOfQuestionsCorrect) {
		this.numberOfQuestionsCorrect = numberOfQuestionsCorrect;
	}

	public double combinedScore() {
		return ((double) numberOfQuestionsCorrect / numberOfQuestionsTotal) * 100;
	}

	@Override
	public String toString() {
		return "MidtermScore [numberOfQuestionsTotal=" + numberOfQuestionsTotal + ", numberOfQuestionsCorrect="
				+ numberOfQuestionsCorrect + "]";
	}

}
