package p1;

public class FinalScore {
	private int grammarScore;
	private int spellingScore;
	private int lengthScore;
	private int contentScore;

	private final static double GRAMMAR_WEIGHT = .3;
	private final static double SPELLING_WEIGHT = .2;
	private final static double LENGTH_WEIGHT = .2;
	private final static double CONTENT_WEIGHT = .3;

	public FinalScore(int grammarScore, int spellingScore, int lengthScore, int contentScore) {
		super();
		this.grammarScore = grammarScore;
		this.spellingScore = spellingScore;
		this.lengthScore = lengthScore;
		this.contentScore = contentScore;
	}

	public int getGrammarScore() {
		return grammarScore;
	}

	public void setGrammarScore(int grammarScore) {
		this.grammarScore = grammarScore;
	}

	public int getSpellingScore() {
		return spellingScore;
	}

	public void setSpellingScore(int spellingScore) {
		this.spellingScore = spellingScore;
	}

	public int getLengthScore() {
		return lengthScore;
	}

	public void setLengthScore(int lengthScore) {
		this.lengthScore = lengthScore;
	}

	public int getContentScore() {
		return contentScore;
	}

	public void setContentScore(int contentScore) {
		this.contentScore = contentScore;
	}

	public static double getGrammarWeight() {
		return GRAMMAR_WEIGHT;
	}

	public static double getSpellingWeight() {
		return SPELLING_WEIGHT;
	}

	public static double getLengthWeight() {
		return LENGTH_WEIGHT;
	}

	public static double getContentWeight() {
		return CONTENT_WEIGHT;
	}

	public double combinedScore() {
		return (grammarScore * GRAMMAR_WEIGHT) + (spellingScore * SPELLING_WEIGHT) + (lengthScore * LENGTH_WEIGHT)
				+ (contentScore * CONTENT_WEIGHT);
	}

	@Override
	public String toString() {
		return "FinalScore [grammarScore=" + grammarScore + ", spellingScore=" + spellingScore + ", lengthScore="
				+ lengthScore + ", contentScore=" + contentScore + "]";
	}

}
