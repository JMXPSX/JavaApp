package com.surveyApp.test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import org.junit.Test;

public class SurveyDAOImplTest {
	
	@Test
	public void testSaveSurvey() {
		try {

			Client client = Client.create();

			WebResource webResource = client
			   .resource("http://localhost:8080/mySurvey-11193557/services/survey/create");

			String input = "{\"surveyId\":\"6\",\"userId\":\"101\",\"description\":\"Earthquake Survey\"}";

			ClientResponse response = webResource.type("application/json")
			   .post(ClientResponse.class, input);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
				     + response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

		  } catch (Exception e) {

			e.printStackTrace();

		  }
	}
	
	@Test
	public void testSaveFeedback() {
		try {

			Client client = Client.create();

			WebResource webResource = client
			   .resource("http://localhost:8080/mySurvey-11193557/services/survey/feedback");

			String input = "{\"feedbackId\":\"6\",\"surveyId\":\"6\",\"userId\":\"101\",\"description\":\"Earthquake feedback\"}";

			ClientResponse response = webResource.type("application/json")
			   .post(ClientResponse.class, input);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
				     + response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

		  } catch (Exception e) {

			e.printStackTrace();

		  }
	}
	
	@Test
	public void testGetAllSurvey() {	
		
		try {
			Client client = Client.create();
			WebResource webResource = client
					   .resource("http://localhost:8080/mySurvey-11193557/services/survey/getAllSurvey");
			
			ClientResponse response = webResource.accept("application/json")
	                   .get(ClientResponse.class);
			
			if (response.getStatus() != 200) {
				   throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
				}

				String output = response.getEntity(String.class);

				System.out.println("Output from Server .... \n");
				System.out.println(output);
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
		
	}
	
	@Test
	public void testGetAllSurvey_userId() {
		
		try {
			Client client = Client.create();
			WebResource webResource = client
					   .resource("http://localhost:8080/mySurvey-11193557/services/survey/getAllSurvey/101");
			
			ClientResponse response = webResource.accept("application/json")
	                   .get(ClientResponse.class);
			
			if (response.getStatus() != 200) {
				   throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
				}

				String output = response.getEntity(String.class);

				System.out.println("Output from Server .... \n");
				System.out.println(output);
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
		
	}
	
	@Test
	public void testGetAllFeedback_surveyId() {
		
		try {
			Client client = Client.create();
			WebResource webResource = client
					   .resource("http://localhost:8080/mySurvey-11193557/services/survey/getAllFeedback/4");
			
			ClientResponse response = webResource.accept("application/json")
	                   .get(ClientResponse.class);
			
			if (response.getStatus() != 200) {
				   throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
				}

				String output = response.getEntity(String.class);

				System.out.println("Output from Server .... \n");
				System.out.println(output);
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
		
	}
	
}
