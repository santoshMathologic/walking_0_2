/***
 *   Walking Controller
 *   @author : santosh sahu 
 *   @description : 
 *   @date: 11-28-2016
 * 
 */
'use strict';

angular.module('walkingApp')
  .controller('walkingCtrl', function($scope,$location,$http,toaster,$state) {
	 
	  $scope.string = $state.current.name;
		$scope.string = $scope.string
				.replaceParentHeader('.', ' > ');
		$scope.title = $scope.string;
    
	  
	  
	   
	   
	 	  
  });
