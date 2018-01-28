package logic;

public class Question {
	int time, term1, term2, result;
	char op;
	term missingTerm;

	public Question(int term1, int term2, char op, int result, term missingTerm) {
		this.op = op;
		this.term1 = term1;
		this.term2 = term2;
		this.op = op;
		this.result = result;
		this.missingTerm = missingTerm;
	}

	@Override
	public String toString() {
		if(missingTerm == term.TERM_1) {
		return "? " + op + " " + term2 + " = " + result;
		}
		else if (missingTerm.TERM_1 == term.TERM_2) {
			return term2 + " " + op + " " + " ?" + " = " + result;
		}
		else {
			return term1 + " " +term2 + " = " + result;
		}
	}
	
	

}
