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
	private int id;
	
//	@Column(name="answers")
//	private List<Boolean> answers; 
	
	@Column(name="q1")
	private String q1;
	@Column(name="q2")
	private String q2;
	@Column(name="q3")
	private String q3;
	@Column(name="q4")
	private String q4;
	@Column(name="q5")
	private String q5;
	@Column(name="q6")
	private String q6;
	@Column(name="q7")
	private String q7;
	@Column(name="q8")
	private String q8;
	@Column(name="q9")
	private String q9;
	@Column(name="q10")
	private String q10;
	@Column(name="q11")
	private String q11;
	
	public Questions() {}
	
	public Questions(List answers,int id) {
		this.id = id;
		this.q1 = (String) answers.get(0);
		this.q2 = (String) answers.get(1);
		this.q3 = (String) answers.get(2);
		this.q4 = (String) answers.get(3);
		this.q5 = (String) answers.get(4);
		this.q6 = (String) answers.get(5);
		this.q7 = (String) answers.get(6);
		this.q8 = (String) answers.get(7);
		this.q9 = (String) answers.get(8);
		this.q10 = (String) answers.get(9);
		this.q11 = (String) answers.get(10);
	}

	public String getQ1() {
		return q1;
	}

	public void setQ1(String q1) {
		this.q1 = q1;
	}

	public String getQ2() {
		return q2;
	}

	public void setQ2(String q2) {
		this.q2 = q2;
	}

	public String getQ3() {
		return q3;
	}

	public void setQ3(String q3) {
		this.q3 = q3;
	}

	public String getQ4() {
		return q4;
	}

	public void setQ4(String q4) {
		this.q4 = q4;
	}

	public String getQ5() {
		return q5;
	}

	public void setQ5(String q5) {
		this.q5 = q5;
	}

	public String getQ6() {
		return q6;
	}

	public void setQ6(String q6) {
		this.q6 = q6;
	}

	public String getQ7() {
		return q7;
	}

	public void setQ7(String q7) {
		this.q7 = q7;
	}

	public String getQ8() {
		return q8;
	}

	public void setQ8(String q8) {
		this.q8 = q8;
	}

	public String getQ9() {
		return q9;
	}

	public void setQ9(String q9) {
		this.q9 = q9;
	}

	public String getQ10() {
		return q10;
	}

	public void setQ10(String q10) {
		this.q10 = q10;
	}

	public String getQ11() {
		return q11;
	}

	public void setQ11(String q11) {
		this.q11 = q11;
	}

//	public List<Boolean> getAnswers() {
//		return answers;
//	}
//
//	public void setAnswers(List<Boolean> answers) {
//		this.answers = answers;
//	}
	
}
