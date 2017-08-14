var myApp = angular.module("myApp", []);

myApp.controller("SurveyCtrl", function($http){
	var sCtrl = this;
	
	sCtrl.initialize = function() {		
		$http.get('/mySurvey-11193557/services/survey/getAllSurvey').then(function(data){		
			sCtrl.surveyList = data.data;
			
			sCtrl.survey = {
				username : undefined,
				surveyId : undefined,
				surveyDescription : undefined,
				surveyFeedback : undefined
			};			
			
			sCtrl.showSurveyList = true;
			sCtrl.showCreate = false;
			sCtrl.showUpdate = false;
			sCtrl.showDelete = false;
			sCtrl.showSave = false;
			sCtrl.showFeedbackDesc = false;
			sCtrl.showSaveFeedback = false;
			sCtrl.showBack = false;
			sCtrl.showSurveyForm = false;
			sCtrl.showFeedback = false;
			sCtrl.operation = '';				
		});		
	};
	
	sCtrl.initialize();
	
	sCtrl.selectSurvey = function(survey){		
		$http.get('/mySurvey-11193557/services/survey/getAllFeedback/' + survey.surveyId).then(function(data){			
			sCtrl.survey.surveyId = survey.surveyId;
			sCtrl.survey.username = survey.userId;
			sCtrl.survey.surveyDescription = survey.description;
			sCtrl.tableData = data.data;
			
			sCtrl.showSurveyList = false;
			sCtrl.showCreate = true;
			sCtrl.showUpdate = true;
			sCtrl.showDelete = true;
			sCtrl.showSave = false;
			sCtrl.showFeedbackDesc = false;
			sCtrl.showSaveFeedback = false;
			sCtrl.showBack = true;
			sCtrl.showSurveyForm = true;
			sCtrl.showFeedback = true;
			sCtrl.operation = 'select';			
		});	
	};
	
	sCtrl.createSurvey = function(survey){
		sCtrl.operation = 'create';
		sCtrl.clearForm(survey, false);		
		sCtrl.showCreate = false;
		sCtrl.showUpdate = false;
		sCtrl.showDelete = false;
		sCtrl.showSave = true;
		sCtrl.showFeedbackDesc = false;
		sCtrl.showSaveFeedback = false;
		sCtrl.showBack = true;
		sCtrl.showFeedback = false;		
	};	

	sCtrl.createFeedback = function(survey){
		sCtrl.operation = 'feedback';
		sCtrl.showCreate = false;
		sCtrl.showUpdate = false;
		sCtrl.showDelete = false;
		sCtrl.showSave = false;		
		sCtrl.showFeedbackDesc = true;
		sCtrl.showSaveFeedback = true;
		sCtrl.showBack = true;
		sCtrl.showFeedback = false;	
	};
	
	sCtrl.clearForm = function(survey, isClear) {
		
		sCtrl.survey = {
			surveyDescription : '',
			surveyFeedback : []
		};
		
		sCtrl.survey.username = (!isClear ? survey.username : '');
		sCtrl.survey.surveyId = (!isClear ? survey.surveyId : '');
	};
	
	sCtrl.back = function() {
		sCtrl.initialize();
	};
	
	sCtrl.updateSurvey = function(survey){
		sCtrl.operation = 'update';		
		sCtrl.showCreate = false;
		sCtrl.showUpdate = false;
		sCtrl.showDelete = false;
		sCtrl.showSave = true;
		sCtrl.showFeedbackDesc = false;
		sCtrl.showSaveFeedback = false;
		sCtrl.showBack = true;
		sCtrl.showFeedback = false;
	};	
	
	sCtrl.deleteSurvey = function(survey){
		sCtrl.operation = 'delete';
		
		$http.delete('/mySurvey-11193557/services/survey/delete/' + survey.surveyId);
		
		setTimeout(function(){
			sCtrl.initialize();
		}, 1000);
	};
	
	sCtrl.saveSurvey = function(survey, operation){	
		if(null !== survey.surveyDescription && '' !== survey.surveyDescription){
			var surveyObj = {};
			surveyObj.surveyId = survey.surveyId;
			surveyObj.userId = survey.username;
			surveyObj.description = survey.surveyDescription;
			
			var jsonObj = angular.toJson(surveyObj, false);	
			
			if(operation === 'create'){
				$http.post('/mySurvey-11193557/services/survey/create', jsonObj);
			}else{
				$http.put('/mySurvey-11193557/services/survey/update', jsonObj);
			}
			
			sCtrl.operation = 'save';			
			
		}else{
			alert("Survey Description is blank!");
		}
		
		setTimeout(function(){
			sCtrl.initialize();
		}, 3000);
	};
	
	sCtrl.saveFeedback = function(survey, operation){
		if(null !== survey.surveyFeedback && '' !== survey.surveyFeedback){			
						
			var feedbackId = sCtrl.tableData.length !== 0 ? sCtrl.tableData[sCtrl.tableData.length - 1].feedbackId : 0;
			var surveyObj = {};			
			
			surveyObj.feedbackId = feedbackId;
			surveyObj.surveyId = survey.surveyId;
			surveyObj.userId = survey.username;
			surveyObj.description = survey.surveyFeedback;
			
			var jsonObj = angular.toJson(surveyObj, false);				
			
			$http.post('/mySurvey-11193557/services/survey/feedback', jsonObj);			
			
		}else{
			alert("Survey Feedback is blank!");
		}
		
		setTimeout(function(){
			sCtrl.initialize();
		}, 3000);
		
	};

}); 

