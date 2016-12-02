/**
 * 
 */

'use strict';

angular.module('walkingApp')
  .controller('loginCtrl', function($scope,$location,$http,$state,AuthenticationFactory,UserAuthFactory) {
	 
	  $scope.isLoggedIn = AuthenticationFactory.isLoggedIn();
	   $scope.doLogin = function(){
		   
		    $state.go("home.dashboard.blank")
	   }
		  
  });



