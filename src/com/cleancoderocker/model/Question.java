package com.cleancoderocker.model;

public class Question {
	private String text = null;
	private Questionnaire questionnaire = null;

	public Question(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	public String toString() {
		return this.getText();
	}

	public Object getQuestionnaire() {
		return this.questionnaire;
	}
	
	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
}
