package com.surveyApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblSurvey")
public class Survey {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int surveyId;
	private int userId;
	private String description;
	
	public Survey() {}

	public Survey(int surveyId, int userId, String description) {
		this.surveyId = surveyId;
		this.userId = userId;
		this.description = description;
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
		return "Survey [surveyId=" + surveyId + ", userId=" + userId + ", description=" + description + "]";
	};	

}
