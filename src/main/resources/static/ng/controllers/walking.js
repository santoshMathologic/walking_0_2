'use strict';

angular.module('walkingApp')
  .controller('walkingCtrl', function($scope,$location,$http) {
	 
	  
	   $scope.walkingLists = [];
	   
	   $scope.serverScopeFetch = new serverTableRetrive(
			      "/api/v1/company/getInfo",
			      $http,
				   
				  function(){					
					  $scope.isLoading = true;
				  },
				  function(resultObj){		
					  $scope.walkingLists = resultObj;
					  $scope.isLoading = false;
				  }
		  );
	   
	   
	 console.log("walking Controller");	  
  });
