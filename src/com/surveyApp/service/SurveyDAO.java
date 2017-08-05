package com.surveyApp.service;

import java.util.List;

import com.surveyApp.entity.Feedback;
import com.surveyApp.entity.Survey;

public interface SurveyDAO {
	void save(Survey survey);
	int update(Survey survey);
	int delete( int SurveyId);
	
	List<Survey> getAllSurvey();
	List<Survey> getAllSurvey(int surveyid);
	
	List<Feedback> getAllFeedback();
	List<Feedback> getAllFeedbackSurveyId(int surveyid);
}
