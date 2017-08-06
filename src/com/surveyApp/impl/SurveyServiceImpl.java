package com.surveyApp.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.surveyApp.entity.Feedback;
import com.surveyApp.entity.Survey;
import com.surveyApp.impl.SurveyDAOImpl;
import com.surveyApp.service.SurveyService;

@Path("/survey")
public class SurveyServiceImpl {
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void saveSurvey(Survey survey) {
		SurveyDAOImpl surveyDAO = new SurveyDAOImpl();
		surveyDAO.save(survey);
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateSurvey(Survey survey) {		
		SurveyDAOImpl surveyDAO = new SurveyDAOImpl();		
		surveyDAO.update(survey);
	}

	@Path("/delete/{surveyId}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteSurvey(@PathParam("surveyId") int surveyId) {			
		SurveyDAOImpl surveyDAO = new SurveyDAOImpl();		
		surveyDAO.delete(surveyId);
	}
	
	@GET
	@Path("/getAllSurvey")
	@Produces(MediaType.APPLICATION_JSON)	
	public List<Survey> getAllSurvey() {
		List<Survey> surveyList = null;
		
		try {
			SurveyDAOImpl surveyDAOImpl = new SurveyDAOImpl();
			surveyList = (List<Survey>) surveyDAOImpl.getAllSurvey();
				
		}catch (Exception e){
			System.out.println("Exception Errors" + e);
		}		
		
		return surveyList;
	}
	
//	@GET
//	@Path("/getAllSurvey/{surveyid}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getAllSurvey(@Context UriInfo uriInfo) {		
//		int surveyIdParam = Integer.parseInt(uriInfo.getPathParameters().getFirst("surveyid"));		
//		
//		System.out.println("SURVEY ID PARAM " + surveyIdParam);
//		
//		ArrayList<Survey> surveyList = null;
//			
//		try {			
//			SurveyDAOImpl surveyDAOImpl = new SurveyDAOImpl();			
//			surveyList = (ArrayList<Survey>) surveyDAOImpl.getAllSurvey(surveyIdParam);				
//		}catch (Exception e){
//			System.out.println("Exception Errors" + e);
//		}		
//		
//		System.out.println("SURVEY LIST " + surveyList);
//
//		System.out.println(Response.status(200).entity(surveyList).build());
//		return Response.status(200).entity(surveyList).build();
//	}
	
	@GET
	@Path("/getAllSurvey/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Survey> getAllSurvey1(@Context UriInfo info){
		
		int userId = Integer.parseInt(info.getPathParameters().getFirst("userId"));
		
		System.out.println("USER ID PARAM " + userId);
		
		List<Survey> surveyList = null;
		
		try {
			SurveyDAOImpl surveyDAOImpl = new SurveyDAOImpl();
			surveyList = (List<Survey>) surveyDAOImpl.getAllSurvey(userId);
				
		}catch (Exception e){
			System.out.println("Exception Errors" + e);
		}		
		
		return surveyList;
		
		
		
		
	}

	@GET
	@Path("/getAllFeedback")
	@Produces(MediaType.APPLICATION_JSON)	
	public List<Feedback> getAllFeedback() {
		ArrayList<Feedback> feedbackList = null;
			
		try {
			SurveyDAOImpl surveyDAOImpl = new SurveyDAOImpl();
			feedbackList = (ArrayList<Feedback>) surveyDAOImpl.getAllFeedback();
			
		}catch (Exception e){
			System.out.println("Exception Errors" + e);
		}		
		
		return feedbackList;
	}
	
	@GET
	@Path("/getAllFeedback/{surveyid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllFeedback(@Context UriInfo uriInfo) {		
		int surveyIdParam = Integer.parseInt(uriInfo.getPathParameters().getFirst("surveyid"));		
		ArrayList<Feedback> feedbackList = null;
			
		try {			
			SurveyDAOImpl surveyDAOImpl = new SurveyDAOImpl();			
			feedbackList = (ArrayList<Feedback>) surveyDAOImpl.getAllFeedback(surveyIdParam);		
		}catch (Exception e){
			System.out.println("Exception Errors" + e);
		}		

		return Response.status(200).entity(feedbackList).build();
	}

}
