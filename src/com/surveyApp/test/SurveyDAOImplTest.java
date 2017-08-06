package com.surveyApp.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.surveyApp.impl.SurveyDAOImpl;

public class SurveyDAOImplTest {

	@Test
	public void testFindMax() {
		assertEquals(4, SurveyDAOImpl.findMax(new int[] {1,3,4,2} ));
		assertEquals(-1, SurveyDAOImpl.findMax(new int[] {-12,-1,-3,-4,-2}));
	}
}
