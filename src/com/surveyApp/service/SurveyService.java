package com.surveyApp.service;

import java.util.List;

import javax.ws.rs.core.Response;

import com.surveyApp.entity.Survey;

public interface SurveyService {	
	void saveSurvey(Survey survey);
	void updateSurvey(Survey survey);
	void deleteSurvey(int SurveyId);
	
	List<Survey> getAllSurvey();
	Response getAllSurvey(int surveyid);
	
	List<Survey> getAllFeedback();
	Response getAllFeedback(int surveyid);
}
