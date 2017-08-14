package com.surveyApp.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.surveyApp.entity.Feedback;
import com.surveyApp.entity.Survey;
import com.surveyApp.impl.SurveyDAOImpl;
import com.surveyApp.service.SurveyService;

@Path("/survey")
public class SurveyServiceImpl implements SurveyService{
	
	private SurveyDAOImpl surveyDAO = new SurveyDAOImpl();
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveSurvey(Survey survey) {
		return surveyDAO.save(survey);
	}	
	
	@POST
	@Path("/feedback")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveFeedback(Feedback feedback) {
		return surveyDAO.saveFeedback(feedback);
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateSurvey(Survey survey) {
		return surveyDAO.update(survey);
	}

	@Path("/delete/{surveyId}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteSurvey(@PathParam("surveyId") int surveyId) {	
		SurveyDAOImpl surveyDAO_1 = new SurveyDAOImpl();		
		surveyDAO_1.delete(surveyId);
		SurveyDAOImpl surveyDAO_2 = new SurveyDAOImpl();
		return surveyDAO_2.deleteFeedBack(surveyId);
	}
	
	@GET
	@Path("/getAllSurvey")
	@Produces(MediaType.APPLICATION_JSON)	
	public List<Survey> getAllSurvey() {
		SurveyDAOImpl surveyDAOImpl = new SurveyDAOImpl();
		List<Survey> surveyList = (List<Survey>) surveyDAOImpl.getAllSurvey();	
		
		return surveyList;
	}
	
	@GET
	@Path("/getAllSurvey/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Survey> getAllSurvey(@Context UriInfo info){		
		int userId = Integer.parseInt(info.getPathParameters().getFirst("userId"));	

		SurveyDAOImpl surveyDAOImpl = new SurveyDAOImpl();
		List<Survey> surveyList = (List<Survey>) surveyDAOImpl.getAllSurvey(userId);	
		
		return surveyList;		
	}
	
	@GET
	@Path("/getAllFeedback/{surveyid}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Feedback> getAllFeedback(@Context UriInfo uriInfo) {		
		int surveyIdParam = Integer.parseInt(uriInfo.getPathParameters().getFirst("surveyid"));		
						
		SurveyDAOImpl surveyDAOImpl = new SurveyDAOImpl();			
		List<Feedback> feedbackList = (List<Feedback>) surveyDAOImpl.getAllFeedback(surveyIdParam);	

		return feedbackList;
	}

}
