package com.surveyApp.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.surveyApp.database.Database;
import com.surveyApp.entity.Feedback;
import com.surveyApp.entity.Survey;

public class SurveyDAOImpl {
	
	public void save(Survey survey) {		
		add(survey, true);	   
	}

	public void update(Survey survey) {		
//		add(survey, false);	
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
			     
		EntityManager em = emfactory.createEntityManager( );
		em.getTransaction( ).begin( );
//		Employee employee = entitymanager.find( Employee.class, 1201 );
		Survey surveyObj = em.find(Survey.class, survey.getSurveyId());
		  
		//before update
		System.out.println( surveyObj );
//		employee.setSalary( 46000 );
		surveyObj.setSurveyId(survey.getSurveyId());
		surveyObj.setUserId(survey.getUserId());
		surveyObj.setDescription(survey.getDescription());
		em.getTransaction( ).commit( );
		  
		//after update
		System.out.println( surveyObj );
		em.close();
		emfactory.close();

		
	}
	
	private void add(Survey survey, boolean isCreate) {	
		
//		try {
//			Database database = new Database();
//			Connection connection = database.Get_Connection();
//			String sqlStatement;
//			int surveyId = isCreate ? survey.getSurveyId() + 1 : survey.getSurveyId();
//			
//			if(isCreate) {
//				sqlStatement = "INSERT INTO tblSurvey"
//						+ "(userId, description, surveyId) VALUES"
//						+ "(?,?,?)";
//			}else {
//				sqlStatement = "UPDATE tblSurvey SET userId = ? , description = ?"
//						+ " WHERE surveyId = ?";
//			}
//			
//			PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
//			
//			preparedStatement.setInt(1, survey.getUserId());
//			preparedStatement.setString(2, survey.getDescription());
//			preparedStatement.setInt(3, surveyId);			
//
//			preparedStatement .executeUpdate();			
//			
//			preparedStatement.close();	
//			connection.close();						
//			
//		}catch(Exception e) {
//			System.out.println("Exception Errors 2dfdfdf " + e);
//		}
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		Survey surveyObj = new Survey();
		surveyObj.setSurveyId(survey.getSurveyId() + 1);
		surveyObj.setUserId(survey.getUserId());
		surveyObj.setDescription(survey.getDescription());
		
		em.persist( surveyObj );
	    em.getTransaction( ).commit( );

	    em.close( );
	    emfactory.close( );

	}

	public void delete(int surveyId) {
		
//		try {			
//			Database database = new Database();
//			Connection connection = database.Get_Connection();			
//			PreparedStatement ps = connection.prepareStatement("DELETE FROM tblsurvey WHERE surveyId = ?");
//			ps.setInt(1, surveyId);
//			
//			ps.executeUpdate();
//			
//			ps.close();
//			
//		}catch(Exception e) {
//			System.out.println("Exception Errors 2 " + e);
//		}
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
	    EntityManager em = emfactory.createEntityManager( );
	    em.getTransaction( ).begin( );
	      
//	    Employee employee = entitymanager.find( Employee.class, 1201 );
	    Survey surveyObj = em.find(Survey.class, surveyId);
	    em.remove( surveyObj );
	    em.getTransaction( ).commit( );
	    em.close( );
	    emfactory.close( );
		
	}
	
	public List<Survey> getAllSurvey() {
//		ArrayList<Survey> surveyList = new ArrayList<Survey>();
		
//		try {
//			Database database = new Database();
//			Connection connection = database.Get_Connection();			
//			PreparedStatement ps = connection.prepareStatement("SELECT surveyId, userId, description FROM tblSurvey ORDER BY id ASC");
//			
//			ResultSet rs = ps.executeQuery();			
//			
//			while(rs.next()) {
//				
//				Survey survey = new Survey();				
//				survey.setSurveyId(rs.getInt("surveyId"));				
//				survey.setUserId(rs.getInt("userId"));				
//				survey.setDescription(rs.getString("description"));				
//				surveyList.add(survey);	
//				
//			}	
//			
//			rs.close();
//			ps.close();	
//			connection.close();
//		}catch(Exception e) {
//			System.out.println("Exception Errors 2 " + e);
//		}
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
		EntityManager em = emfactory.createEntityManager();
		
		em.getTransaction().begin();
		

		
		List<Survey> surveyList = em.createQuery("SELECT s FROM Survey s").getResultList();
		
		System.out.print("SURVEY LIST" + surveyList);
		
		em.getTransaction().commit();
		
		em.close();
		
		emfactory.close();	
		
		return surveyList;
	}

	public List<Survey> getAllSurvey(int userId) {		
//		ArrayList<Survey> surveyList = new ArrayList<Survey>();
//		
//		try {
//			Database database = new Database();
//			Connection connection = database.Get_Connection();			
//			PreparedStatement ps = connection.prepareStatement("SELECT surveyId, userId, description FROM tblSurvey WHERE surveyId = " + surveyid + " ORDER BY id ASC");
//			
//			ResultSet rs = ps.executeQuery();			
//			
//			while(rs.next()) {
//				
//				Survey survey = new Survey();				
//				survey.setSurveyId(rs.getInt("surveyId"));				
//				survey.setUserId(rs.getInt("userId"));				
//				survey.setDescription(rs.getString("description"));				
//				surveyList.add(survey);					
//			}			
//			rs.close();
//			ps.close();	
//			connection.close();
//			
//		}catch(Exception e) {
//			System.out.println("Exception Errors 2 " + e);
//		}
		
		
		System.out.println("USER ID " + userId);
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
		EntityManager em = emfactory.createEntityManager();
		
		em.getTransaction().begin();
		

		
		List<Survey> surveyList = em.createQuery("SELECT s FROM Survey s WHERE s.userId = " + userId).getResultList();
		
		System.out.print("SURVEY LIST" + surveyList);
		
		em.getTransaction().commit();
		
		em.close();
		
		emfactory.close();	
		
		return surveyList;
	}
	
	public List<Feedback> getAllFeedback() {		
		ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();
		
		try {
			Database database = new Database();
			Connection connection = database.Get_Connection();			
			PreparedStatement ps = connection.prepareStatement("SELECT feedbackId, surveyId, userId, description FROM tblFeedback ORDER BY id ASC");

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Feedback feedback = new Feedback();
				feedback.setFeedbackId(rs.getInt("feedbackId"));
				feedback.setSurveyId(rs.getInt("surveyId"));
				feedback.setUserId(rs.getInt("userId"));
				feedback.setDescription(rs.getString("description"));
				feedbackList.add(feedback);
				
			}
			
			rs.close();
			ps.close();	
			connection.close();
		}catch(Exception e) {
			System.out.println("Exception Errors 2 " + e);
		}
		
		return feedbackList;		
	}
	
	public List<Feedback> getAllFeedback(int surveyid) {		
		ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();
		
		try {
			Database database = new Database();
			Connection connection = database.Get_Connection();			
			PreparedStatement ps = connection.prepareStatement("SELECT feedbackId, surveyId, userId, description FROM tblFeedback WHERE surveyId = " + surveyid + " ORDER BY id ASC");
			
			ResultSet rs = ps.executeQuery();			
			
			while(rs.next()) {
				
				Feedback feedback = new Feedback();
				feedback.setFeedbackId(rs.getInt("feedbackId"));
				feedback.setSurveyId(rs.getInt("surveyId"));
				feedback.setUserId(rs.getInt("userId"));
				feedback.setDescription(rs.getString("description"));
				feedbackList.add(feedback);
				
			}
			
			rs.close();
			ps.close();	
			connection.close();
		}catch(Exception e) {
			System.out.println("Exception Errors 2adcadcadc " + e);
		}
		
		return feedbackList;
		
	}
	
	public static int findMax(int arr[]) {
		int max = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		return max;
	}

}
