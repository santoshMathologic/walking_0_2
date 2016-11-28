'use strict';

angular.module('walkingApp')
  .controller('walkingCtrl', function($scope,$location,$http) {
	 
	  
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
			   
			   
			   
		   })
		
		        
	   }
	   
	   
	 console.log("walking Controller");	  
  });
