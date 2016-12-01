/**
 * 
 */

'use strict';

angular.module('walkingApp')
  .controller('companyCtrl', function($scope,$location,$http,$state) {
	  
	  $scope.string = $state.current.name;
		$scope.string = $scope.string
				.replaceParentHeader('.', ' > ');
		$scope.title = $scope.string;
  
	  
	   $scope.walking = {};
	   $scope.companyLists = [];
	   $scope.isLoading = true;
	   
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
	   
	   $scope.checkwalking= function(compnayObj){
		   
		   
		   if(typeof compnayObj === 'object'||typeof compnayObj !== "undefined"){
			
			   $scope.query = {
					   walkinId : (compnayObj.id) ? compnayObj.id : 0 
					}
			   $http.get("api/v1/walking/getWalkinginfo",{params:$scope.query}).then(function(responseObj){
				   $scope.walking = responseObj.data;
				   $scope.isLoading = false;
				   
			   },function(errorResponse){
				   
				   
				   
			   });
		  
		   }
		   
	   }
	   $scope.removeCompany =  function(companyobj){
		   
	
						$scope.companyLists.splice($scope.companyLists.indexOf(companyobj),1); // Splice the division Array and remove object from Array
						if($scope.companyLists.length>=0){
							toaster.pop({type: 'success', title: 'company Removed', body: 'company Removed Successfully!!!'}); // PopUp the toaster Once division has removed	
						}else{
							 toaster.pop({type: 'error', title: 'Error', body: 'Unable To Remove company. Please Try Again!!!'}); // On Error Response PopUp the toaster if division Not removed from DB	
						}
						 
						
							   
	   }
	   
	   
	  
	  
	  
	 
	 	  
  });



