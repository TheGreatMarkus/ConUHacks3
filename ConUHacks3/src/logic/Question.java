package logic;

public class Question {

	public static enum MissingTerm {
		TERM_1, TERM_2, RESULT;
	}

	private int time, term1, term2, result;
	private char op;
	private MissingTerm missingTerm;
	private boolean answeredCorrectly;

	public Question(int term1, int term2, char op, int result, MissingTerm missingTerm) {
		this.op = op;
		this.term1 = term1;
		this.term2 = term2;
		this.op = op;
		this.result = result;
		this.missingTerm = missingTerm;
		this.answeredCorrectly = false;
	}

	@Override
	public String toString() {
		if (missingTerm == MissingTerm.TERM_1) {
			return "? " + op + " " + term2 + " = " + result;
		} else if (missingTerm == MissingTerm.TERM_2) {
			return term2 + " " + op + " " + " ?" + " = " + result;
		} else {
			return term1 + " " + op + " " + term2 + " = ?";
		}
	}

	public int getTerm1() {
		return term1;
	}

	public int getTerm2() {
		return term2;
	}

	public MissingTerm getMissingTerm() {
		return missingTerm;
	}

	public char getOp() {
		return op;
	}

	public int getResult() {
		return result;
	}

	public int getTime() {
		return time;
	}

}
