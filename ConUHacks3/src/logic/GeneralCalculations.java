package logic;

import java.util.Random;

import logic.Question.MissingTerm;

public class GeneralCalculations {

	public static enum Difficulty {
		EASY, NORMAL, HARD;
	}

	public static enum Topic {
		ADD, SUB, MULT, DIV;
	}

	public static enum GameMode {
		FIND_RESULT;
	}

	public static int EASY_NUM_QUESTION = 10;
	public static int NORMAL_NUM_QUESTION = 25;
	public static int HARD_NUM_QUESTION = 50;

	public static int ADD_SUB_EASY_NUM_RANGE = 10;
	public static int ADD_SUB_NORMAL_NUM_RANGE = 40;
	public static int ADD_SUB_HARD_NUM_RANGE = 200;

	public static int MULT_DIV_EASY_NUM_RANGE = 5;
	public static int MULT_DIV_NORMAL_NUM_RANGE = 12;
	public static int MULT_DIV_HARD_NUM_RANGE = 20;

	public static Question[] generateQuestions(Difficulty difficulty, Topic topic, GameMode gameMode) {
		Question[] questions;
		Random rand = new Random();
		int addSubNumberRange, multDivNumberRange;
		// Defining the number of questions and the range of the questions
		if (difficulty == Difficulty.EASY) {
			questions = new Question[EASY_NUM_QUESTION];
			addSubNumberRange = ADD_SUB_EASY_NUM_RANGE;
			multDivNumberRange = MULT_DIV_EASY_NUM_RANGE;
		} else if (difficulty == Difficulty.NORMAL) {
			questions = new Question[NORMAL_NUM_QUESTION];
			addSubNumberRange = ADD_SUB_NORMAL_NUM_RANGE;
			multDivNumberRange = MULT_DIV_NORMAL_NUM_RANGE;
		} else {
			questions = new Question[HARD_NUM_QUESTION];
			addSubNumberRange = ADD_SUB_HARD_NUM_RANGE;
			multDivNumberRange = MULT_DIV_HARD_NUM_RANGE;
		}
		// Finding what is the gamemode
		MissingTerm mt = MissingTerm.RESULT;
		if (gameMode == GameMode.FIND_RESULT) {
			mt = MissingTerm.RESULT;
		} else {

		}
		// Generating a question based on previous calculated settings
		for (int i = 0; i < questions.length; i++) {
			char op = '!';
			int term1 = 0, term2 = 0, result = 0;
			if (mt == MissingTerm.RESULT) {
				if (topic == Topic.ADD) {
					op = '+';
					term1 = rand.nextInt(addSubNumberRange);
					term2 = rand.nextInt(addSubNumberRange);
					result = term1 + term2;
				} else if (topic == Topic.SUB) {
					op = '-';
					term1 = rand.nextInt(addSubNumberRange);
					term2 = rand.nextInt(addSubNumberRange);
					result = term1 - term2;
				} else if (topic == Topic.MULT) {
					op = 'X';
					term1 = rand.nextInt(multDivNumberRange);
					term2 = rand.nextInt(multDivNumberRange);
					result = term1 * term2;
				} else {
					op = '÷';

					do {
						term2 = rand.nextInt(multDivNumberRange);
						term1 = rand.nextInt(multDivNumberRange * 2);
						if (term2 != 0 && term1 % term2 == 0) {
							result = term1 / term2;
							break;
						}
					} while (true);
				}
			}
			questions[i] = new Question(term1, term2, op, result, mt);
			System.out.println(questions[i]);
			System.out.println(result);
			System.out.println(questions.length);
		}

		return questions;
	}

}
