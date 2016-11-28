'use strict';

angular.module('walkingApp')
  .controller('walkingCtrl', function($scope,$location,$http,toaster) {
	 
	  
	   $scope.walkingLists = [];
	   $scope.companyLists = [];
	   
	   $scope.serverScopeFetch = new serverTableRetrive(
			      "/api/v1/company/getInfo",
			      $http,
				   
				  function(){					
					  $scope.isLoading = true;
				  },
				  function(resultObj){		
					  $scope.companyLists  = resultObj;
					  $scope.isLoading = false;
				  }
		  );
	   
	   $scope.checkwalking= function(){
		   $http.get( "/api/v1/company/getInfo").then(function(responseObj){
			   $scope.walkingLists = responseObj.data.content;
			   $scope.isLoading = false;
			   
		   },function(errorResponse){
			   
			   
			   
		   });
	  
	   }
	   $scope.removeCompany =  function(companyobj){
		   
	
						$scope.companyLists.splice($scope.companyLists.indexOf(companyobj),1); // Splice the division Array and remove object from Array
						toaster.pop({type: 'success', title: 'Division Removed', body: 'Division Removed Successfully!!!'}); // PopUp the toaster Once division has removed 
						toaster.pop({type: 'error', title: 'Error', body: 'Unable To Remove Division. Please Try Again!!!'}); // On Error Response PopUp the toaster if division Not removed from DB
							   
	   }
	   
	   
	 console.log("walking Controller");	  
  });
