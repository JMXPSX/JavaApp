package com.surveyApp.service;

import java.util.List;

import javax.ws.rs.core.Response;

import com.surveyApp.entity.Survey;

public interface SurveyService {	
	Response saveSurvey(Survey survey);
	Response updateSurvey(Survey survey);
	Response deleteSurvey(int SurveyId);
	List<Survey> getAllSurvey();
}
