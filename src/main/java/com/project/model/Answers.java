package com.project.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Answers")
public class Answers implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id", nullable = false)
	private QuestionnaireTable question;
	
	@Column(name="answer")
	private String answer; 
	
	public Answers() {}
	
	public Answers(User setU_id, QuestionnaireTable setQuestion,String setAnswer ) {
		this.user = setU_id;
		this.question = setQuestion;
		this.answer = setAnswer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user_id) {
		this.user = user_id;
	}

	public QuestionnaireTable getQuestion() {
		return question;
	}

	public void setQuestion(QuestionnaireTable question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
