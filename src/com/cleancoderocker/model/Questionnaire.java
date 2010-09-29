package com.cleancoderocker.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Questionnaire {
	private String name = null;
	private List<Question> questions = null;

	public Questionnaire(String name) {
		this.name = name;
	}

	public void addQuestion(Question question) {
		this.getQuestionsMutable().add(question);
		question.setQuestionnaire(this);
	}

	private List<Question> getQuestionsMutable() {
		if (this.questions == null) {
			this.questions = new ArrayList<Question>();
		}
		return this.questions;
	}

	public List<Question> getQuestions() {
		return Collections.unmodifiableList(this.getQuestionsMutable());
	}

	public String getName() {
		return this.name;
	}

}
