/**
 * 
 */

'use strict';

angular.module('walkingApp')
  .controller('loginCtrl', function($scope,$location,$http,$state) {
	 
	   $scope.doLogin = function(){
		   
		    $state.go("home.dashboard.blank")
	   }
	 console.log("login Controller");	  
  });



