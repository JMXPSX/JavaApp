<html lang="en">
	<head>
        <meta charset="UTF-8">
		<title>Survey</title>	

		<script type="text/javascript" src="include/angular.min.js"></script>		
		<script type="text/javascript" src="include/angular-animate.min.js"></script>			
		<script type="text/javascript" src="include/app.js"></script>		
		
		<link rel="stylesheet" href="include/style.css">
		
		<meta name="viewport" content="width=device-width, initial-scale=1">        
	</head>
	
	<body ng-app="myApp" ng-controller="SurveyCtrl as surveyCtrl"> 

		<section class="artistpage">
		
		    <div class="search" ng-if="surveyCtrl.showSurveyList">
		        <h1 class="form-control">Survey Application</h1>

		    </div>
		    
		    <div class="main" ng-if="surveyCtrl.showSurveyList">        
		        <ul class="artistlist" >
		            <li ng-animate="'animate'" class="artist cf" ng-repeat="survey in surveyCtrl.surveyList" ng-click="surveyCtrl.selectSurvey(survey)">		                
		                <a ng-href="" >
		                    <img ng-src="include/survey-icon.png" alt="Photo of {{survey.description}}">
		                    <div class="info">
		                        <h2>{{survey.description}}</h2>

		                    </div>
		                </a>		                
		            </li>
		        </ul>
		    </div>
		    
           <form ng-if="surveyCtrl.showSurveyForm" class="search" method="post">
           
               <div class="form-group">
                 <label>Username</label>
                 <input type="text" class="form-control" name = "username" ng-model="surveyCtrl.survey.username" placeholder="username..." disabled>
               </div>
               
               <div class="form-group">
                 <label>Survey Description</label>
                 <input class="form-control" name = "description"  ng-model="surveyCtrl.survey.surveyDescription" placeholder="description...">
               </div>
               
               <hr/>	
               
               <div ng-if="surveyCtrl.showFeedback" class="form-control">                    
              						
					<div class="form-group" >
					
	                  	<label>Feedback</label>
						
						<ul class="artistlist" >
				            <li ng-animate="'animate'" class="artist cf" ng-repeat="feedback in surveyCtrl.tableData">				                
				                <a ng-href="" >
				                    <img ng-src="include/feedback-icon.png" alt="Photo of {{feedback.description}}">
				                    <div class="info">
				                        <h2>{{feedback.description}}</h2>				                        
				                    </div>
				                </a>				                
				            </li>
				        </ul>
	 					                 			
	                </div>
	                
	                <button class="btn btn-default" ng-click="surveyCtrl.createFeedback()">Create Feedback</button>
			
					<hr/>

				</div>
				
               <div ng-if="surveyCtrl.showFeedbackDesc" class="form-group">
                 <label>Survey Feedback</label>
                 <input class="form-control" name = "feedback"  ng-model="surveyCtrl.survey.surveyFeedback" placeholder="Feedback...">
               </div>

			   <div class="row form-control">
	               <button type="submit" class="btn btn-default" ng-if="surveyCtrl.showCreate" ng-click="surveyCtrl.createSurvey(surveyCtrl.survey)">Create Survey</button>
	               <button class="btn btn-default" ng-if="surveyCtrl.showUpdate" ng-click="surveyCtrl.updateSurvey(surveyCtrl.survey)">Update Survey</button>
	               <button class="btn btn-" ng-if="surveyCtrl.showDelete" ng-click="surveyCtrl.deleteSurvey(surveyCtrl.survey)">Delete Survey</button>
               </div>
               
               <div class="row form-control add-padding">
	               <button class="btn btn-default" ng-if="surveyCtrl.showSave" ng-click="surveyCtrl.saveSurvey(surveyCtrl.survey, surveyCtrl.operation)">Save Survey</button>
	               <button class="btn btn-default" ng-if="surveyCtrl.showSaveFeedback" ng-click="surveyCtrl.saveFeedback(surveyCtrl.survey, surveyCtrl.operation)">Save Feedback</button>
	               <button class="btn btn-default" ng-if="surveyCtrl.showBack" ng-click="surveyCtrl.back()">Back to List</button>
               </div>
               
             </form>
		    
		</section>

	</body>
	
</html>