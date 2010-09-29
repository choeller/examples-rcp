package com.cleancoderocker.model;

public class QuestionnaireProvider {
	public static Questionnaire findQuestionnaire(String name) {
		return createDummyQuestionnaire(name);
	}

	private static Questionnaire createDummyQuestionnaire(String name) {
		Questionnaire questionnaire = new Questionnaire(name);
		Question question1 = new Question("Tests");
		Question question2 = new Question("Tests");
		Question question3 = new Question("Tests");
		Question question4 = new Question("Tests");
		questionnaire.addQuestion(question1);
		questionnaire.addQuestion(question2);
		questionnaire.addQuestion(question3);
		questionnaire.addQuestion(question4);
		return questionnaire;
	}
}
