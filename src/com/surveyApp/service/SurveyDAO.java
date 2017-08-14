package com.surveyApp.service;

import java.util.List;

import javax.ws.rs.core.Response;

import com.surveyApp.entity.Feedback;
import com.surveyApp.entity.Survey;

public interface SurveyDAO {
	Response save(Survey survey);
	Response update(Survey survey);
	Response delete( int SurveyId);
	List<Survey> getAllSurvey(int surveyid);
}
