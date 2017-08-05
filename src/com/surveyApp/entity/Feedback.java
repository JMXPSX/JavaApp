package com.surveyApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblFeedback")
public class Feedback {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feedbackId;
	private int surveyId;
	private int userId;
	private String description;
	
	public Feedback() {};
	
	public Feedback(int feedbackId, int surveyId, int userId, String description) {
		
		this.feedbackId = feedbackId;
		this.surveyId = surveyId;
		this.userId = userId;
		this.description = description;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", surveyId=" + surveyId + ", userId=" + userId + ", description="
				+ description + "]";
	}	

}
