/**
 * 
 */

'use strict';

angular.module('walkingApp')
  .controller('loginCtrl', function($scope,$location,$http,$state,AuthenticationFactory,UserAuthFactory,$timeout,$window) {
	 
	  $scope.isLoggedIn = AuthenticationFactory.isLoggedIn();
	   $scope.doLogin = function(username, password){
		   
		    if((typeof username === 'undefined')&&(typeof password === 'undefined')){
		    	//  throw new Error("Username and Password are Empty")
		    	  $timeout(function(){
		    	       window.alert("hi!");
		    	    },500);
		    	}
		    else{
		    	$state.go("home.dashboard.blank")	
		    }
		    
	   }
		  
  });



