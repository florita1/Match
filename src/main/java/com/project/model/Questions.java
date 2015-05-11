package com.project.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Questions")
public class Questions {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="answers")
	private List<Boolean> answers; 
	
	public Questions() {}

	public List<Boolean> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Boolean> answers) {
		this.answers = answers;
	}
	
}
