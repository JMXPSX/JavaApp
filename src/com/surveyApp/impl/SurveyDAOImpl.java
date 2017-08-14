package com.surveyApp.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Response;

import com.surveyApp.entity.Feedback;
import com.surveyApp.entity.Survey;
import com.surveyApp.service.SurveyDAO;

public class SurveyDAOImpl implements SurveyDAO {
	
	private static final String WS200 = "{\"Info\" : \"WS200\"}";
	private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
	private EntityManager em = emfactory.createEntityManager();	
	
	public Response save(Survey survey) { 
		em.getTransaction().begin();
		
		Survey surveyObj = new Survey();
		
		surveyObj.setSurveyId(survey.getSurveyId() + 1);
		surveyObj.setUserId(survey.getUserId());
		surveyObj.setDescription(survey.getDescription());
		
		em.persist(surveyObj);
	    em.getTransaction().commit();
	    
	    em.close();
	    emfactory.close();
	    
		return Response.status(200).entity(WS200).build();
	}
	
	public Response saveFeedback(Feedback feedback) {
		em.getTransaction().begin();
		
		Feedback feedbackObj = new Feedback();
		
		feedbackObj.setFeedbackId(feedback.getFeedbackId() + 1);
		feedbackObj.setSurveyId(feedback.getSurveyId());
		feedbackObj.setUserId(feedback.getUserId());		
		feedbackObj.setDescription(feedback.getDescription());
		
		em.persist(feedbackObj);
	    em.getTransaction().commit();
	    
	    em.close();
	    emfactory.close();
	    
		return Response.status(200).entity(WS200).build();
	}

	public Response update(Survey survey) {		
		em.getTransaction( ).begin( );		
		Survey surveyObj = em.find(Survey.class, survey.getSurveyId());	
		surveyObj.setSurveyId(survey.getSurveyId());
		surveyObj.setUserId(survey.getUserId());
		surveyObj.setDescription(survey.getDescription());
		em.getTransaction( ).commit( );
		em.close();
		emfactory.close();
		
		return Response.status(200).entity(WS200).build();
	}

	public Response delete(int surveyId) {	    
	    em.getTransaction().begin();
	    Survey surveyObj = em.find(Survey.class, surveyId);
	    em.remove(surveyObj);
	    em.getTransaction().commit();
	    em.close();
	    emfactory.close();
	    
	    return Response.status(200).entity(WS200).build();
	}
	
	public List<Survey> getAllSurvey() {		
		em.getTransaction().begin();
		List<Survey> surveyList = em.createQuery("SELECT s FROM Survey s").getResultList();
		em.getTransaction().commit();		
		em.close();		
		emfactory.close();
		return surveyList;
	}

	public List<Survey> getAllSurvey(int userId) {	
		em.getTransaction().begin();		
		List<Survey> surveyList = em.createQuery("SELECT s FROM Survey s WHERE s.userId = " + userId).getResultList();
		
		em.getTransaction().commit();		
		em.close();		
		emfactory.close();			
		return surveyList;
	}
	
	public List<Feedback> getAllFeedback(int surveyid) {			
		em.getTransaction().begin();
		
		List<Feedback> feedbackList = em.createQuery("SELECT f FROM Feedback f WHERE f.surveyId = " + surveyid).getResultList();	
		
		em.getTransaction().commit();		
		em.close();		
		emfactory.close();			
		return feedbackList;
	}
	
	public Response deleteFeedBack(int surveyId) {
	    em.getTransaction().begin();
	    
	    List<Feedback> feedbackList = em.createQuery("SELECT f FROM Feedback f WHERE f.surveyId = " + surveyId).getResultList();
	    	    	    
	    for(Feedback feedback : feedbackList) {
	    	em.remove((Feedback) em.find(Feedback.class, feedback.getFeedbackId()));
	    }    

	    em.getTransaction().commit();
	    em.close();
	    emfactory.close();
	    
	    return Response.status(200).entity(WS200).build();
	}

}
