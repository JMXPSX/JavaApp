<html>
	<head>
		<title>Survey</title>
		<link href="include/style.css" rel="stylesheet">
		
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
		<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>		
			
		<script type="text/javascript" src="include/app.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">
	</head>
	
	<body ng-app="app" ng-controller="SurveyCtrl as surveyCtrl">
		<section id="contact" class="content-section text-center">
	        <div class="contact-section">
	            <div class="container">
	              <h2>Survey Application</h2>
	              
	              <div class="row">
	                <div class="col-md-8 col-md-offset-2">
	                
	                <div ng-if="surveyCtrl.showSurveyList" class="row add-padding scrollable">
		                <div class="list-group">
		                    <a href="" class="list-group-item" 
		                       ng-repeat="survey in surveyCtrl.surveyList"
		                       ng-click="surveyCtrl.selectSurvey(survey)">
		                        <h4 class="list-group-item-heading">
		                            <span class="header-h3">
		                                <strong>{{survey.description}}</strong>
		                            </span>
		                        </h4>
		                    </a>
		                </div> 		                
		            </div>	                
	                
	                <form ng-if="surveyCtrl.showSurveyForm" class="form-horizontal" method="post">
	                    <div class="form-group">
	                      <label for="exampleInputName2">Username</label>
	                      <input type="text" class="form-control" name = "name" ng-model="surveyCtrl.survey.username" placeholder="JMXPSX" disabled>
	                    </div>
	                    <div class="form-group">
	                      <label for="exampleInputEmail2">Survey Description</label>
	                      <input class="form-control" name = "description"  ng-model="surveyCtrl.survey.surveyDescription" placeholder="Duterte SONA">
	                    </div>
	                    
	                    <hr/>	
	                    
	                    <div ng-if="surveyCtrl.showFeedback">                    
	                   						
							<div class="form-group" >
		                      	<label>Feedback</label>
	
								<div class="divTable">
						             <div ng-repeat="name in surveyCtrl.tableData" class="headRow">
						                <div class="divCell">{{name.name}}</div>
						             </div>									
	      						</div>	                 			
		                    </div>
		                    
		                    <button class="btn btn-default" ng-click="surveyCtrl.createFeedback()">Create Feedback</button>
								
							<hr/>
						
						</div>
						
	                    <button type="submit" class="btn btn-default" ng-if="surveyCtrl.showCreate" ng-click="surveyCtrl.createSurvey(surveyCtrl.survey)">Create Survey</button>
	                    <button class="btn btn-default" ng-if="surveyCtrl.showUpdate" ng-click="surveyCtrl.updateSurvey(surveyCtrl.survey)">Update Survey</button>
	                    <button class="btn btn-default" ng-if="surveyCtrl.showDelete" ng-click="surveyCtrl.deleteSurvey(surveyCtrl.survey)">Delete Survey</button>
	                    <button class="btn btn-default" ng-if="surveyCtrl.showSave" ng-click="surveyCtrl.saveSurvey(surveyCtrl.survey, surveyCtrl.operation)">Save Survey</button>
	                    <button class="btn btn-default" ng-if="surveyCtrl.showBack" ng-click="surveyCtrl.back()">Back to List</button>
	                    
	                  </form>

	                </div>
	              </div>
	            </div>
	        </div>
      </section>	
      

		
	</body>
</html>