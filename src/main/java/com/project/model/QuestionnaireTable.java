package com.project.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Questionnaire2")
public class QuestionnaireTable {

	@Id
	@GeneratedValue
	private int id;

	@Column(name="Questions")
	private String question; 

	public QuestionnaireTable() {}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



}
