package p1;

import java.util.Arrays;

public class TestScores {
	private int[] scores = new int[20];

	public TestScores(int[] scores) {
		super();
		this.scores = scores;
		for(int i = 0; i < scores.length; i++) {
			if(scores[i] < 0 || scores[i] > 100)
				throw new IllegalArgumentException();
		}
	}

	@Override
	public String toString() {
		return "TestScores [scores=" + Arrays.toString(scores) + "]";
	}
	
	
}
