/**
 * 
 */

'use strict';

angular.module('walkingApp')
  .controller('loginCtrl', function($scope,$location,$http,$state,AuthenticationFactory,UserAuthFactory,$timeout,$window,toaster) {
	 
	  $scope.isLoggedIn = AuthenticationFactory.isLoggedIn();
	  $scope.auth = {
			  username:"",
			  password:""
	  };
	   $scope.doLogin = function(username,password){
		   
		    if((typeof username === 'undefined')&&(typeof password === 'undefined')){
		    	//  throw new Error("Username and Password are Empty")
		    	  $timeout(function(){
		    		  toaster.pop({type: 'error', title: 'Error', body: 'Unable To Login. Please Try Again!!!'}); // On Error Response PopUp the toaster if division Not removed from DB
		    	    },500);
		    	}
		    else{
		    	
		    	UserAuthFactory.login(username,password).success(function(response){
		    		
		    		console.log(response);
		    		
		    		$state.go("home.dashboard.blank")	
		    		
		    	});
		    		
		    }
		    
	   }
		  
  });



